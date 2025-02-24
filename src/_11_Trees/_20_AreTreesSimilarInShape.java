package _11_Trees;
import java.io.*;
import java.util.*;

public class _20_AreTreesSimilarInShape {
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

    public static boolean areSimilar(Node n1, Node n2) {
        // write your code here
      if(n1.children.size() != n1.children.size()){ // check krta hai ki dono node ke children ke numbers equal hai ya nhi
          return false;
      }
      for(int i=0;i<n1.children.size();i++){ // ye loop dono nodes ke children ko ek ek krke check krta hai
          Node c1 = n1.children.get(i); // n1 ke ith child ko c1 mein store krta h
          Node c2 = n2.children.get(i);//n2 ke ith child ko c2 mein store krta hai
          if(areSimilar(c1,c2) == false){ // ye recursively check krta hai ki c1 aur c2 similar hai ya nhi ...agr kisi bhi pair ke bache similar nhi huye toh function false return krdega
              return false;
          }
      }
      return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n1];
        String[] values1 = br.readLine().split(" ");
        for (int i = 0; i < n1; i++) {
            arr1[i] = Integer.parseInt(values1[i]);
        }
        Node root1 = construct(arr1);

        int n2 = Integer.parseInt(br.readLine());
        int[] arr2 = new int[n2];
        String[] values2 = br.readLine().split(" ");
        for (int i = 0; i < n2; i++) {
            arr2[i] = Integer.parseInt(values2[i]);
        }
        Node root2 = construct(arr2);

        boolean similar = areSimilar(root1, root2);
        System.out.println(similar);
    }
}
