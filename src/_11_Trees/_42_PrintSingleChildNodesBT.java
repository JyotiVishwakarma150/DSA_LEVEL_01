package _11_Trees;
import java.io.*;
import java.util.*;

public class _42_PrintSingleChildNodesBT {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void printSingleChildNodes(Node node, Node parent) {
        // write your code here
        if(node==null){
            return;
        }
//        parent != null → Ensure karte hain ki root ke upar ka node exist kare.
//                parent.left == node && parent.right == null
//        Parent ka left child toh hai, but right child nahi hai
//        Matlab node single child hai, toh print kar do.
//        parent.right == node && parent.left == null
//        Parent ka right child toh hai, but left child nahi hai
//        Matlab node single child hai, toh print kar do.

        if(parent!=null && parent.left==node && parent.right==null) {
            System.out.println(node.data);
        }else if(parent != null && parent.right==node && parent.left==null ){
            System.out.println(node.data);
        }
        printSingleChildNodes(node.left,node);
        printSingleChildNodes(node.right,node);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);
        printSingleChildNodes(root, null);
    }
}
//mine thinking
//        if(node.left != null && node.right == null){
//            System.out.println(node.left.data);
//        }
//        if(node.left==null && node.right!=null){
//            System.out.println(node.right.data);
//        }