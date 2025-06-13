import java.util.*;

public class Snake {
    public static void print(char[][] grid){
        System.out.println(Arrays.toString(grid[0]));
        System.out.println(Arrays.toString(grid[1]));
        System.out.println(Arrays.toString(grid[2]));
        System.out.println(Arrays.toString(grid[3]));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] grid = new char[4][4];
        grid[0][0] = 'O';
        boolean win = true;
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{0, 0});
        System.out.println("Welcome to the Snake Game");
        while(deque.size()<16){
            boolean apple = true;
            boolean space = false;
            for(int i = 0; i<4; i++){
                for(int j = 0; j<4; j++){
                    if(grid[i][j]==0)space = true;
                    if(grid[i][j]=='X')apple = false;
                }
            }
            while(apple){
                int x = (int) (Math.random() * 4);
                int y = (int) (Math.random() * 4);
                if(grid[y][x] == 0) {
                    grid[y][x] = 'X';
                    apple = false;
                }
            }
            print(grid);
            int[] cord = deque.peekLast(); int x = cord[0]; int y = cord[1];
            int newX;int newY;
            System.out.println("Put movement (wasd): ");
            String str = scanner.nextLine().toUpperCase();
            if(str.equals("W")){
                newX = x-1;
                newY = y;
            }
            else if(str.equals("A")){
                newX = x;
                newY = y-1;
            }
            else if(str.equals("S")){
                newX = x+1;
                newY = y;
            }
            else{
                newX = x;
                newY = y+1;
            }
            if(newX<0 || newY<0 || newX>=4 || newY>=4){
                System.out.println("You hit the wall, you lost!!!");
                win = false;
                break;
            }
            if(grid[newX][newY]=='O'){
                System.out.println("You hit yourself, you lost!!!");
                win = false;
                break;
            }
            else if(grid[newX][newY]!='X'){
                int[] tail = deque.poll();
                grid[tail[0]][tail[1]] = 0;
            }
            deque.add(new int[]{newX, newY});
            grid[newX][newY] = 'O';

        }
        if(win)System.out.println("Congratulations on beating the snake game");
        scanner.close();
    }
}
