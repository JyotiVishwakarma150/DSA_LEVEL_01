package _10_Recursion;

import java.util.Scanner;

public class _23_PrintMazePaths {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int m = scn.nextInt();
        printMazePaths(1,1,n,m,"");

    }
    public  static void printMazePaths( int sr,int sc,int dr,int dc,String psf){
        //call smart base case normal
//        if(sr==dr && sc==dc){
//            System.out.println(psf);
//            return;
//        }
//        if(sc<dc){
//            printMazePaths(sr,sc+1,dr,dc,psf+"h");
//        }
//        if(sr<dr){
//            printMazePaths(sr+1,sc,dr,dc,psf+"v");
//        }

        // base case smart ,call stupid
        if(sr>dr || sc>dc){
            return;
        }
        if(sr==dr && sc==dc){
            System.out.println(psf);
            return;
        }
            printMazePaths(sr,sc+1,dr,dc,psf+"h");
            printMazePaths(sr+1,sc,dr,dc,psf+"v");
     }
}
