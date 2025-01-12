package _10_Recursion;

import java.util.Scanner;

public class _11_MaxOfAnArray {
//    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        int n = scn.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = scn.nextInt();
//        }
//        FindMax(arr,0,-1);
//    }
//    public static void FindMax(int[] arr,int idx , int max){
//        if(idx== arr.length){
//            System.out.println(max);
//            return;
//        }
//        if(arr[idx]>max){
//            max = arr[idx];
//        }
//        FindMax(arr,idx+1,max);
//    }
    public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int max = maxOfArray(arr,0);
        System.out.println(max);
    }
    public static int maxOfArray(int[] arr , int idx){
        if(idx == arr.length-1){
            return arr[idx];
        }
        int misa = maxOfArray(arr,idx+1);
        if(misa> arr[idx]){ // misa = max in smaller array
            return misa;
        }
        else{
            return arr[idx];
        }
    }
}
