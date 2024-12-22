package _08_LinkedLists;
import java.io.*;
import java.util.*;

public class _24_FoldLL {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public int size() {
            return size;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        public void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;

            if (size == 0) {
                tail = temp;
            }

            size++;
        }
        private void foldHelper(Node right,int floor){
            if(right == null){
                return;
            }
            foldHelper(right.next,floor+1);
            if(floor>size/2){
                Node temp = fleft.next;
                fleft.next = right;
                right.next=temp;
                fleft = temp;
            } else if(floor==size/2){
                tail = right;
                tail.next= null;
            }
        }
        Node fleft;
        public void fold() {
            // write your code here
            fleft = head;
            foldHelper(head,0);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());
        LinkedList l1 = new LinkedList();
        String[] values1 = br.readLine().split(" ");
        for (int i = 0; i < n1; i++) {
            int d = Integer.parseInt(values1[i]);
            l1.addLast(d);
        }

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        l1.display();
        l1.fold();
        l1.display();
        l1.addFirst(a);
        l1.addLast(b);
        l1.display();
    }
}
