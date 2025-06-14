package _16_TimeAndSpace;
import java.io.*;
import java.util.*;
public class _04_MergeTwoSortedArrays {
    public static int[] mergeTwoSortedArrays(int[] a, int[] b){
        //write your code here
        int[] res = new int[a.length+b.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<a.length&&j<b.length){
            if(a[i]<b[i]){
                res[k]=a[i];
                i++;
                k++;
            }else{
                res[k]=b[j];
                j++;
                k++;
            }
        }
        while(i<a.length){
            res[k]=a[i];
            i++;
            k++;
        }
        while(j<b.length){
            res[k]=a[j];
            j++;
            k++;
        }

        return res;
    }

    public static void print(int[] arr){
        for(int i = 0 ; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0 ; i < n; i++){
            a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for(int i = 0 ; i < m; i++){
            b[i] = scn.nextInt();
        }
        int[] mergedArray = mergeTwoSortedArrays(a,b);
        print(mergedArray);
    }


}
