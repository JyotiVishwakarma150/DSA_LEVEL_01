package _10_Recursion;

import java.util.Scanner;

public class _09_DisplayArrayRecursion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        displayArray(arr,0);
    }
    public static  void displayArray(int[] arr , int idx){
         if(idx == arr.length){
             return;
         }
        System.out.println(arr[idx]);
         displayArray(arr,idx+1);

    }
}
