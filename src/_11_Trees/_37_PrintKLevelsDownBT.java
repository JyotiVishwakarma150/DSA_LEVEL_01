package _11_Trees;
import java.io.*;
import java.util.*;

public class _37_PrintKLevelsDownBT {
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
            Node node; //
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

        public static void printKLevelsDown(Node node, int k) {
            // node==null ka mtlb ki tree ka leaf node cross hogya hai
            // k<0 hone ka mtlb h ki koi logical reason nhi hai , par safety ke liye check lgaya gya h
            if(node==null || k<0){
                        return ;
                    }
            // k==0 ka mtlb ki hum exactly kth level par phuch chuke hain , to node.data ko print karege
                    if(k==0){
                        System.out.println(node.data);
                    }
                    //function left subtree aur right subtree dono ko call krega ,par k-1 pass krega ,taki level
            // decrement hote hote exactly kth level tak phuch sake
            //isla mtlb h ki har recursive call tree ke ek level niche jarhi hai,tab node.data print ho jata hai
                    printKLevelsDown(node.left,k-1);
                    printKLevelsDown(node.right,k-1);
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

            int k = Integer.parseInt(br.readLine());

            Node root = construct(arr);
            printKLevelsDown(root, k);
        }
    }