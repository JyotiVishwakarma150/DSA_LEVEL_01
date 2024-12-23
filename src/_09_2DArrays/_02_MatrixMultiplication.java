package _09_2DArrays;
import java.io.*;
import java.util.*;

public class _02_MatrixMultiplication{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the rows of first matrix : ");
        int r1 = scn.nextInt();
        System.out.println("enter the columns of first matrix : ");
        int c1 = scn.nextInt();
        int[][] one = new int[r1][c1];
        System.out.println("enter elements of first matrix : ");
        for(int i=0;i<one.length;i++){
            for(int j=0;j< one[0].length;j++){
                one[i][j] = scn.nextInt();
            }
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("enter the rows of second matrix : ");
        int r2 = scn.nextInt();
        System.out.println("enter the columns of second matrix : ");
        int c2 = scn.nextInt();
        int[][] two = new int[r2][c2];
        System.out.println("enter elements of second matrix : ");
        for(int i=0;i<two.length;i++){
            for(int j=0;j< two[0].length;j++){
                two[i][j] = scn.nextInt();
            }
        }
        System.out.println("---------------------------------------------------------------");
        if(c1!=r2){
            System.out.println("Invalid input");
        }
        int[][] prd = new int[r1][c2];
        for(int i=0;i< prd.length;i++){
            for(int j=0;j< prd[0].length;j++){
                for(int k=0;k<c1;k++){
                    prd[i][j] += one[i][k] * two[k][j];
                }
            }
        }
        for(int i=0;i< prd.length;i++){
            for(int j=0;j< prd[0].length;j++){
                System.out.print(prd[i][j] + " ");
                }
            System.out.println();
            }
    }

}
