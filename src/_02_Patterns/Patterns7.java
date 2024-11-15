package _02_Patterns;
import java.util.Scanner;
public class Patterns7 {
    public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    //MY CODE ---------------------------------------------
//        int sp = 0;
//        int st = 1;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= sp; j++) {
//                System.out.print("\t");
//            }
//            for (int j = 1; j <= st; j++) {
//                System.out.println("*\t");
//            }

//            sp++;
//            System.out.println();
//        }


        //PEPCODING--------------------------------
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j){
                    System.out.print("*\t");
                } else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}


