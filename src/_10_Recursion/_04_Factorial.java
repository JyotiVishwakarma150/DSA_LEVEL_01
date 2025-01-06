package _10_Recursion;
import java.io.*;
import java.util.*;

public class  _04_Factorial{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int f= factorial(n);
        System.out.println(f);
    }

    public static int factorial(int n) {
        if( n==1){
            return 1;
        }
        int fn = factorial(n-1);
        int fnm1 = n*fn;
        return fnm1;
    }

}
