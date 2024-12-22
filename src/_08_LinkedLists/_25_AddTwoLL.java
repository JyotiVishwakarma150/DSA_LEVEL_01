package _08_LinkedLists;

import java.io.*;
import java.util.*;

public class _25_AddTwoLL {
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
        public static int addListHelper(Node one, int pv1, Node two, int pv2, LinkedList res) {
            if (one == null && two == null) {
                return 0;
            }
            int data = 0;
            if (pv1 > pv2) {
                int oc = addListHelper(one.next, pv1 - 1, two, pv2, res);
                data = one.data + oc;
            } else if (pv1 < pv2) {
                int oc = addListHelper(one, pv1, two.next, pv2 - 1, res);
                data = two.data + oc;
            } else{
                int oc = addListHelper(one.next, pv1-1, two.next, pv2-1, res);
                data = one.data + two.data + oc;
            }
            int nd = data % 10;
            int nc = data / 10;
            res.addFirst(nd);
            return nc;
        }

        public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
            LinkedList res = new LinkedList();
            int oc = addListHelper(one.head, one.size, two.head, two.size, res);
            if (oc > 0) {
                res.addFirst(oc);
            }
            return res;
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

        int n2 = Integer.parseInt(br.readLine());
        LinkedList l2 = new LinkedList();
        String[] values2 = br.readLine().split(" ");
        for (int i = 0; i < n2; i++) {
            int d = Integer.parseInt(values2[i]);
            l2.addLast(d);
        }

        LinkedList sum = LinkedList.addTwoLists(l1,l2);

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        l1.display();
        l2.display();
        sum.display();
        sum.addFirst(a);
        sum.addLast(b);
        sum.display();
    }
}
