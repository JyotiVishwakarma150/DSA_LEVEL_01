package _04_Arrays;
import java.io.*;
import java.util.*;

public class _10_SubsetOfArray{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
        int limit = (int)Math.pow(2, arr.length);
        for(int i=0;i<limit;i++){
            String set  = " ";
            int temp = i;
            for(int j=arr.length-1;j>=0;j--){
                int r = temp%2;
                temp=temp/2;
                if(r==0){
                    set = "_\t" + set;
                } else{
                    set = arr[j] + "\t" +set;
                }
            }
            System.out.println(set);
        }
    }

}
