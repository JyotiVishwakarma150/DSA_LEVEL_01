package _06_Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class _01_QueueBasic {
    public static void main(String[] args) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(10);
        System.out.println(que);
        que.add(20);
        System.out.println(que);
        que.add(30);
        System.out.println(que);
//        System.out.println(que.remove());//10
//        System.out.println(que);// [20,30]
        System.out.println(que.peek());//10
        System.out.println(que);//[10,20,30]
        System.out.println(que.remove());//20
        System.out.println(que);//[30]
    }
}
