package _11_Trees;
import java.io.*;
import java.util.*;

public class _31_DisplayBT {
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
        Node root = new Node(arr[0], null, null); // root node create hoti hai(jo array ka phla element hota hai
        Pair rtp = new Pair(root, 1);// iska mtlb hai ki ye node abhi state 1 mein hai (left child process krna hai)

        Stack<Pair> st = new Stack<>();
        st.push(rtp); // stack mein ye root node push ho jata hai

        int idx = 0; // ye array mein traverse krega
        while (st.size() > 0) { // jb tkk stack non- empty hai ,tbb tk loop chlta rhega
            Pair top = st.peek(); // stack ke top element ko peek() krke process krege
            if (top.state == 1) { // left child process krna hai
                idx++; // ye krke next element dekhege
                if (arr[idx] != null) { // age null nhi hai to new node bnayege aur stack me push krdege
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else { // agr null hai to left mein null assign krdege
                    top.node.left = null;
                }

                top.state++; // iska state 2 ho jyega (right child process ke liye)
            } else if (top.state == 2) { // state 2 ka mtlb right child process krna hai
                idx++; // ye krke next element k check krege
                if (arr[idx] != null) { // agr null nhi hai to right child create hoga aur stack mein push hoga
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;// agr null nhi hai to right , null assign hoga
                }

                top.state++; // iska state 3 ho jyega (node completely processed)
            } else { // state 3 .... mtlb ye node poora process ho chuka hai ,ab isko stack se hta skte hain
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
        display(root);
    }
}
