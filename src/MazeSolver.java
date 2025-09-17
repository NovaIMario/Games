import java.util.Arrays;
import java.util.HashSet;

public class MazeSolver {
    private static HashSet<String> visited;
    public static void main(String[] args) {
        //Assuming it's always a solvable maze and the length of entrance is only one space
        //The 1 represents the walls, 0 represents the path and 2 is one of the possible path
        visited = new HashSet<>();
        int[][] test = {{1,1,1,1,1,1},
                        {1,0,0,0,0,0},
                        {0,0,1,1,0,1},
                        {1,1,1,1,1,1}};
        int startRow = 2, startCol = 0;
        backtrack(startRow, startCol, test, false);
        for(int i = 0; i< test.length; i++){
            System.out.println(Arrays.toString(test[i]));
        }
    }
    private static boolean backtrack(int r, int c, int[][] board, boolean end){
        int rows = board.length, cols = board[0].length;
        if(r<0 || c<0 || r>=rows || c>=cols || board[r][c] != 0)return false;
        if(visited.contains(r+","+c))return false;
        visited.add(r+","+c);
        if(end && (c==0||r==0||r==rows-1||c==cols-1)){
            board[r][c] = 2;
            return true;
        }
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int[] direction: directions){
            int newRow = r+direction[0], newCol = c+direction[1];
            if(backtrack(newRow, newCol, board, true)){
                board[r][c] = 2;
                return true;
            }
        }
        return false;
    }
}
