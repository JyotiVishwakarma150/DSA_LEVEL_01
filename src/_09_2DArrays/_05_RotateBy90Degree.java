package _09_2DArrays;
import java.io.*;
import java.util.*;

public class _05_RotateBy90Degree {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println("Enter no of rows in matrix : ");
        int[][] arr = new int[n][n];
        System.out.println("Enter elements in matrix : ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
            //transpose
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr[0].length; j++) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
            //reverse
            for (int i = 0; i < arr.length; i++) {
                int li = 0;
                int ri = arr[i].length - 1;
                while (li < ri) {
                    int temp = arr[i][li];
                    arr[i][li] = arr[i][ri];
                    arr[i][ri] = temp;
                    li++;
                    ri--;
                }
            }
            display(arr);
        }

    public static void display ( int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
