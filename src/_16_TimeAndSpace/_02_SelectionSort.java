package _16_TimeAndSpace;
import java.io.*;
import java.util.*;
public class _02_SelectionSort {
    public static void selectionSort(int[] arr) {
        //for n input the number of iterations will be n-1
       for(int i=0;i<arr.length-1;i++){
           int mi=i;// assume that ki initially minimum hai ye aur i to mim h hi means dono initially minimum ko hi point krte hain
           for(int j=i+1;j<arr.length;j++){
               //baaki elements ke sth compare krege to find the actual minimum
               if(isSmaller(arr,j,mi)){
                   //agr arr[j] chhota hai arr[mi] se to  mi=j ko update krdiya
                   mi=j;
               }
           }
           swap(arr,i,mi);//minimum element ko current position pe le aate hai
       }


    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // return true if ith element is smaller than jth element
    public static boolean isSmaller(int[] arr, int i, int j) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if (arr[i] < arr[j]) {
            return true;
        } else {
            return false;
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
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        selectionSort(arr);
        print(arr);
    }


}
