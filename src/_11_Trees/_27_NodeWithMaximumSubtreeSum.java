package _11_Trees;
import java.io.*;
import java.util.*;

public class _27_NodeWithMaximumSubtreeSum {
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
    static int msn = 0; // ye us node ka data store karega jiska subtree sum sabse jade hoga
    static int ms=Integer.MIN_VALUE; // ye maximum subtree sum store krega.phle  Integer.MIN_VALUE set kiya gya hai taki koi bhi nya subtree sum isse bd ho ske
    static int retSumAndCalculateMSST(Node node){ //max sum sub tree ... ye function ek node ka subtree sum calculate krega aur maximum subtree sum wala node dhundhega
        int sum=0;
        for(Node child:node.children){ // ye loop har node par chlega
            int csum = retSumAndCalculateMSST(child); // recursively child ka subtree sum nikal rhe hain
            sum += csum;// har child ka subtree sum current node ke sum me add kar diya
        }
        //csum variable child ka subtree sum store karega
        sum += node.data; // jab sare children ka sum add ho jaye,tab current node ka data bhi add kar diya ,taki poora subtree sum mil sake
        if(sum>ms){ //check kar rhe hain ki ab tak ka maximum subtree sum mila hai ya nhi , agr sum ,ms se bda hai toh iska mtlb hume ek nya maximum subtree sum mila hai
            msn=node.data; // maximum subtree ko  update kiya aur uss node ka data msn bhi update kr diya
            ms=sum;
        }

        return sum; // current node ka subtree return krdiya
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
        // write your code here
        retSumAndCalculateMSST(root);
        System.out.println(msn +"@" +ms);
    }
}
