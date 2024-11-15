package _02_Patterns;
import java.util.Scanner;
public class Patterns8 {
    public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
       int n= scn.nextInt();
       //MY LOGIC ---------------------------------------
//       for(int i=1;i<=n;i++){
//           for(int j=n;j>=1;j--){
//               if(i==j){
//                   System.out.print("*\t");
//               } else{
//                   System.out.print("\t");
//               }
//           }



        //PEPCODING--------------------------------------------------------
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i+j==n+1){
                    System.out.print("*\t");
                }
                else{
                    System.out.print("\t");
                }
            }
           System.out.println();
       }
    }
}
