package _09_2DArrays;
import java.util.Scanner;
public class _03_WaveTraversal {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter no of rows in matrix : ");
        int n= scn.nextInt();
        System.out.println("Enter no of columns in matrix : ");
        int m = scn.nextInt();
        System.out.println("Enter elements of matrix : ");
        int[][] arr = new int[n][m];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j< arr[0].length;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        for(int j=0;j<arr[0].length;j++){
            if(j % 2 == 0){
                for(int i=0;i<arr.length;i++){
                    System.out.println(arr[i][j]);
                }
            } else {
                for (int i = arr.length-1;i>=0;i--) {
                    System.out.println(arr[i][j]);
                }
            }
        }
    }
}
