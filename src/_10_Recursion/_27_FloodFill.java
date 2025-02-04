package _10_Recursion;
import java.io.*;
import java.util.*;
public class _27_FloodFill {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];//ye rokne k liye ki -- hum unhi dabbo m jarhe h , jinme hum
        // 1 bar ja chuke hain i]usme nai jana
        floodfill(arr, 0, 0, "",visited);
    }

    // asf -> answer so far
    public static void floodfill(int[][] maze, int row, int col, String asf,boolean[][] visited) {
       if(row<0 || col<0 || row== maze.length || col== maze[0].length
               || maze[row][col] == 1 || visited[row][col]==true ){
           return;
       }
       if(row== maze.length-1 && col==maze[0].length-1){
           System.out.println(asf);
           return;
       }
       visited[row][col] = true;//jate huye visted mtlb jis dabbe mein ja chuke hai uspr ik tik lg jayega
       floodfill(maze,row-1,col,asf+"t",visited);
       floodfill(maze,row,col-1,asf+"l",visited);
       floodfill(maze,row+1,col,asf+"d",visited);
       floodfill(maze,row,col+1,asf+"r",visited);
       visited[row][col] = false; // wapas aate huye visited uda dege taki dusr paths ready hoske
    }
}
