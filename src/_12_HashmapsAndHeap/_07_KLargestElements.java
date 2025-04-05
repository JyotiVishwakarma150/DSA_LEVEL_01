package _12_HashmapsAndHeap;
import java.io.*;
import java.util.*;
public class _07_KLargestElements {
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
        for(int i=0;i<arr.length;i++){
            if(i<k) {//First k elements ko heap mein daal diya jaata hai
                pq.add(arr[i]);
            }else{
                ////Uske baad, har naye element ke liye check karte hain:
                if(arr[i]>pq.peek()){//Agar woh current heap ke smallest element se bada hai (arr[i] > pq.peek()), to
                    pq.remove();//Sabse chhota (peek) element heap se hata dete hain
                    pq.add(arr[i]);//Naya element insert kar dete hain
                }
            }
        }
       // atlast .... Heap mein hamare paas hamesha top k largest elements hi bache hote hain.
        while(pq.size()>0){
            System.out.println(pq.remove());
        }
    }
}
