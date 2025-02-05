package _10_Recursion;
import java.io.*;
import java.util.*;

public class _29_NQueens {
    public static void main(String[] args) throws Exception {
       Scanner scn = new Scanner(System.in);
       int n = scn.nextInt();
       int[][] chess = new int[n][n];
       printNQueens(chess,"",0);
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
         if(row==chess.length){
          System.out.println(qsf +".");
          return;
          }
          for(int col=0;col< chess.length;col++) {
             if(isItaSafePlaceFotTheQueen(chess,row,col) == true){
                 chess[row][col]=1; // queens bharne ke liye
                 printNQueens(chess,qsf+row+"-"+col+",",row+1);
                 chess[row][col] = 0;// call k baad queens ko hatane ke liye
             }
          }
    }
    public  static boolean isItaSafePlaceFotTheQueen(int[][] chess,int row,int col){
        for(int i=row-1,j=col;i>=0;i--){ // for checking  -  up
            if(chess[i][j] == 1){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){ // for checking - diagonal left
            if(chess[i][j] == 1){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0 && j<chess.length;i--,j++){ // for checking - diagonal right
            if(chess[i][j] == 1){
                return false;
            }
        }
        return true;
    }
}

