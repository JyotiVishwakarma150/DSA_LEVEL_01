package _12_HashmapsAndHeap;
import java.io.*;
import java.util.*;


public class _08_SortKSortedArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        // write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<=k;i++){
            pq.add(arr[i]); // loop lgakr sare elements ko queue mein daal diya
        }
        for(int i=k+1;i<arr.length;i++){ //abb k+1 se mtlb k ke age se start krege loop chlayege
            System.out.println(pq.remove()); // k+1 mein jo sbse chhota bnda hai whi release ho jyega
            pq.add(arr[i]);//agle bnde ko add krdiya
        }
        while(pq.size()>0){
            System.out.println(pq.remove());// bche huye elements koprint krne ke liye
        }
    }
}
