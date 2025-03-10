package _10_Recursion;

import java.util.Scanner;

public class _21_PrintStairPaths {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printStairPaths(n,"");
    }
    public static void printStairPaths(int n, String path) {
        if(n<0){
            return;
        }
        if(n==0){
            System.out.println(path);
            return;
        }
        printStairPaths(n-1,path+"1");
        printStairPaths(n-2,path+"2");
        printStairPaths(n-3,path+"3");
    }
}
