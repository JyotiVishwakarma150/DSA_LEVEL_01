package _10_Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class _17_GetStairPaths {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> paths = getStairPaths( n);
        System.out.println(paths);
    }
    public static  ArrayList<String> getStairPaths(int n){
        if(n==0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        } else if(n<0){
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }
        ArrayList<String > paths1 = getStairPaths(n-1);
        ArrayList<String > paths2 = getStairPaths(n-2);
        ArrayList<String > paths3 = getStairPaths(n-3);
        ArrayList<String > paths = new ArrayList<>();
        for(String path:paths1){
            paths.add(1 + path);
        }
        for(String path:paths2){
            paths.add(2+ path);
        }
        for(String path : paths3){
            paths.add(3+path);
        }
        return paths;
    }
}
