package _11_Trees;
import java.io.*;
import java.util.*;

public class  _22_IsGenericTreeSymmetric{
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static int size(Node node) {
        int s = 0;

        for (Node child : node.children) {
            s += size(child);
        }
        s += 1;

        return s;
    }
    public static boolean areMirror(Node n1, Node n2) {
        if(n1.children.size() != n2.children.size()){ // check krta hai ki dono node ke children ke numbers equal hai ya nhi
            return false;
        }
        for(int i=0;i<n1.children.size();i++){
             int j= n1.children.size()-1-i;
             Node c1 = n1.children.get(i);
             Node c2 = n2.children.get(j);
            // c1 = phle tree ka ith children(left to right)
            // c2 = dusre tree ka last children mtlb ulta check krrhe h (right to left)
            if(areMirror(c1,c2) == false){
                return false;
            }
            //recursive call se check krte hai ki ye dono children mirror haa ya nhi ,age kisi bhi level par match nhi milta to false return ho jyega
        }
        return true;

    }
    public static boolean IsSymmetric(Node node) {
        // write your code here
        return areMirror(node,node);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        boolean sym = IsSymmetric(root);
        System.out.println(sym);
    }
}
