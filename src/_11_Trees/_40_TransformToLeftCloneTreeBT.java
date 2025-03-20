package _11_Trees;

import java.io.*;
import java.util.*;

public class _40_TransformToLeftCloneTreeBT {
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

    public static Node createLeftCloneTree(Node node) {
        // write your code here
        if(node==null){ // base case of the recursion
            return null;
        }
        // ab hum recursively  left  aur right subtree  ko clone krte hain
        Node lcr = createLeftCloneTree(node.left);
        Node rcr = createLeftCloneTree(node.right);
        //Ab hum ek naya node (newNode) banate hain jo current node ka clone hoga. Is node ka data same hoga
        // jo node ka data tha, aur iska left child jo humne already clone kiya hai (leftClone) hoga, lekin
        // iska right child null hoga (kyunki hum sirf left clone bana rahe hain).
        Node nn = new Node(node.data,lcr,null);
        //Ab hum current node (node) ke left child ko newNode se link karte hain. Matlab,
        // ab current node ka left child jo hai wo uska clone ban gaya hai
        node.left=nn;
        //Current node ke right child ko hum unchanged rakhte hain. Matlab,
        // jo right child tha, wo waise ka waise hi rahega, bas humne left side ko clone kiya hai.
        node.right=rcr;
        return node;
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
        root = createLeftCloneTree(root);
        display(root);
    }
}