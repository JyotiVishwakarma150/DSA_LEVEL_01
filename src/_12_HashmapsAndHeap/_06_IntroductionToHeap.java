package _12_HashmapsAndHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class _06_IntroductionToHeap {
    //priority queue
    public static void main(String[] args) {
       // PriorityQueue<Integer> pq = new PriorityQueue<>(); //default behaviour ...min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());//max heap using comparator
        int[] ranks = {22,99,3,11,88,4,1};
        for(int val:ranks){
            pq.add(val);
        }
        while(pq.size()>0){
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
