package _14_DynamicProgramming;

import java.util.Scanner;

public class _01_FibonacciDP {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int fibn = FibMemoized(n,new int[n+1]);
        System.out.println(fibn);
    }
    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        int fibnm1=fib(n-1);
        int fibnm2 = fib(n-2);
        int fibnm = fibnm1+ fibnm2;
        return fibnm;
    }
    public static int FibMemoized(int n,int[] qb){
        if(n==0 || n==1){
            return n;
        }
        if(qb[n]!=0){
            return qb[n];
        }
        int fibnm1 = FibMemoized(n-1,qb);
        int fibnm2 = FibMemoized(n-2,qb);
        int fibn = fibnm1 + fibnm2;
        qb[n] = fibn;
        return fibn;
    }
}
