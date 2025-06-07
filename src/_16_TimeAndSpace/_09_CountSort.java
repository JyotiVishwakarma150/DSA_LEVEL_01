package _16_TimeAndSpace;
import java.io.*;
import java.util.*;
public class _09_CountSort {
    public static void countSort(int[] arr, int min, int max) {
        //write your code here
        int range = max-min+1;
        int[] farr = new int[range];//farr = frequency array banayi hai → isme har value ka count store hoga
        for(int i=0;i< arr.length;i++){
           //Har element ke liye: arr[i] - min karke uska correct index nikaala frequency array ke liye
            int idx = arr[i]-min;
            farr[idx]++;
        }
        //Yeh banata hai prefix sum
        for(int i=1;i< farr.length;i++){
            //Matlab: har index pe store hoga ki kitne elements us value tak aa chuke hain.
            //Iska kaam hota hai: kis position pe element ko place karna hai ans[] array mein
            farr[i]=farr[i]+farr[i-1];
        }
        //Sorted array ban raha hai ans[] naam se
        //Har element ko uski correct sorted position pe daala ja raha hai, using prefix sum array farr[]
        int[] ans = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            int val = arr[i];
            int pos = farr[val-min];
            int idx =pos-1;
            ans[idx]=val;
            farr[val-min]--;
        }
        for(int i=0;i<ans.length;i++){
            arr[i]=ans[i];
        }

    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr,min,max);
        print(arr);
    }


}
