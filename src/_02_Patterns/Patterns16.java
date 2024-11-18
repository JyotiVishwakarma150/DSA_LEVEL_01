package _02_Patterns;
import java.util.Scanner;
public class Patterns16 {
    public static void main(String[] args) {
     Scanner scn = new Scanner(System.in);
     int n= scn.nextInt();
     int sp = 2*n-3;
     int st=1;
     for(int i=1;i<=n;i++){
         int val =1;
         //for number
         for(int j=1;j<=st;j++){
             System.out.print(val + "\t");
             val++;
         }
         //for space
         for(int j=1;j<=sp;j++){
             System.out.print("\t");
         }
         //special case
         if(i==n){
             st--;
             val--;
         }
         // for number
         for(int j=1;j<=st;j++){
             val--;
             System.out.print(val + "\t");
         }
         st++;
         sp-=2;
         System.out.println();
     }
    }
}
