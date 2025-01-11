package _10_Recursion;

import java.util.Scanner;

public class _10_DisplayArrayReverse {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        ReverseArray(arr,0);
    }
    public static  void ReverseArray(int[] arr , int idx) {
        if (idx == arr.length) {
            return;
        }
        ReverseArray(arr, idx + 1);
        System.out.println(arr[idx]);

    }
}
