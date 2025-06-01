package _16_TimeAndSpace;
import java.io.*;
import java.util.*;
public class _03_InsertionSort {

    public static void insertionSort(int[] arr) {
        //write your code here
        for(int i=1;i<arr.length;i++){//maan liya ki 0th index wala element already sorted hai isliye loop i=1 se start krege
            for(int j=i-1;j>=0;j--){// ye inner loop hai jo pichle elements ko compare krta hai
                if(isGreater(arr,j,j+1)){//agr jth element j+1th element se bda hai tbb...
                    swap(arr,j,j+1);// khud ko j+1th wale ke sth swap krdege
                }else{//agr chhota hai tbb...
                    break;//nhi to break kyuki mere se phle wale tumse to chhote honge hi honge
                }
            }
        }

    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // return true if jth element is greater than ith element
    public static boolean isGreater(int[] arr, int j, int i) {
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
        insertionSort(arr);
        print(arr);
    }


}
