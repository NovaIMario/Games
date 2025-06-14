import java.util.Arrays;
import java.util.Scanner;

public class Connect3 {
    public static final int n = 5;
    public static final int l = 3;
    public static final int d = n-l;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Connect 3");
        char[][] grid = new char[n][n];
        int turn = 0;
        boolean draw = true;
        while(turn<16){
            char player;
            if(turn % 2 == 0){
                player = 'O';
            }
            else{
                player = 'X';
            }
            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(grid[i]));
            }
            System.out.println(player + " choose the col: ");
            int input = scanner.nextInt();
            while(input<0 || input>=n){
                System.out.println("Invalid");
                input = scanner.nextInt();
            }
            for(int i = 4; i>=0; i--){
                if(grid[i][input]==0){
                    grid[i][input] = player;
                    break;
                }
                if(i==4){
                    System.out.println("Congrats on wasting a move");
                }
            }
            if(checkW(grid)){
                draw=false;
                for (int i = 0; i < n; i++) {
                    System.out.println(Arrays.toString(grid[i]));
                }
                break;
            }
            turn ++;
        }
        if(draw)System.out.println("Nobody won");
        scanner.close();
    }
    public static boolean checkW(char[][] grid){
        for (int a = 0; a <=d ; a++) {
            for(int i = 0; i<n; i++){
                if(grid[i][a]==0)continue;
                boolean w = true;
                for(int j = 1; j<=d; j++){
                    w = grid[i][a+j] == grid[i][a];
                    if(!w)break;
                }
                if(w){
                    System.out.println(grid[i][a] + " won!");
                    return true;
                }
            }
        }
        for (int a = 0; a <= d; a++) {
            for(int i = 0; i<n; i++){
                if(grid[a][i]==0)continue;
                boolean w = true;
                for(int j = 1; j<=d; j++){
                    w = grid[a+j][i] == grid[a][i];
                    if(!w)break;
                }
                if(w){
                    System.out.println(grid[a][i] + " won!");
                    return true;
                }
            }
        }

        for(int a = 0; a<=d; a++){
            for(int i = 0; i<=d; i++){
                if(grid[i][a]==0)continue;
                boolean w = true;
                for(int j = 1; j<=d; j++){
                    w = grid[i+j][a+j] == grid[i][a];
                    if(!w)break;
                }
                if(w){
                    System.out.println(grid[i][a] + " won!");
                    return true;
                }
            }
        }
        for(int a = 0; a<=d; a++){
            for(int i = 4; i>=d; i--){
                if(grid[i][a]==0)continue;
                boolean w = true;
                for(int j = 1; j<=d; j++){
                    w = grid[i-j][a+j] == grid[i][a];
                    if(!w)break;
                }
                if(w){
                    System.out.println(grid[i][a] + " won!");
                    return true;
                }
            }
        }


        return false;
    }
}
