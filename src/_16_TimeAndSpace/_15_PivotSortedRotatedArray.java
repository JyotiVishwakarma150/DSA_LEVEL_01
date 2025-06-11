package _16_TimeAndSpace;
import java.io.*;
import java.util.*;
public class _15_PivotSortedRotatedArray {

    public static int findPivot(int[] arr) {
        // write your code here
        int lo=0;
        int hi=arr.length-1;
        while(lo<hi){
            int mid = (lo+hi)/2;
            if(arr[mid]<arr[hi]){//mid se  high ki or value bdh rhi hai (mid , high se chhota hai )to first half mein belong krega
                hi=mid;
            }else{//mid, high se bda hai to second half mein belong krega
                lo=mid+1;
            }
        }
        return arr[hi];//loop se niklne ke baad lo , hi aur mid teeno ki values same ho jaegi
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int pivot = findPivot(arr);
        System.out.println(pivot);
    }

}
