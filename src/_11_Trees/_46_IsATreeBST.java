package _11_Trees;
import java.io.*;
import java.util.*;

public class _46_IsATreeBST{
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

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        int th = Math.max(lh, rh) + 1;
        return th;
    }
    public static class BSTPair{
        boolean isBST;
        int min;
        int max;
    }
    public static BSTPair isBST(Node node){
          if(node==null){//Agar current node null hai, iska matlab hum ek empty subtree pe pahunch gaye hain.
              BSTPair bp = new BSTPair();//Ek naya BSTPair object banayenge
              bp.min=Integer.MAX_VALUE;
              bp.max=Integer.MIN_VALUE;
              bp.isBST = true;//kyunki ek empty tree hamesha BST hota hai
              return bp;//Return kar diya jata hai ye object
          }
          //Recursive call kiya gaya left aur right subtree pe
          BSTPair lp = isBST(node.left);
          BSTPair rp = isBST(node.right);
          //Ek naya BSTPair object mp banaya jo current node ka result store karega
          BSTPair mp = new BSTPair();
          //3 Conditions Check Hoti Hain:
        //Left subtree BST hona chahiye → lp.isBST
        //Right subtree BST hona chahiye → rp.isBST
        //Current node ka data left ke max se bada aur right ke min se chhota hona chahiye
          mp.isBST = lp.isBST && rp.isBST && (node.data>=lp.max && node.data<=rp.min);
          //Minimum & Maximum Value Update Karna
          mp.min=Math.min(node.data,Math.min(lp.min,rp.min));// Current node, left subtree aur right subtree ke min ka smallest value
          mp.max=Math.max(node.data,Math.max(lp.max,rp.max));// Current node, left subtree aur right subtree ke max ka largest value
          return mp;
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

        // write your code here
        BSTPair bp = isBST(root);
        System.out.println(bp.isBST);
    }
}
