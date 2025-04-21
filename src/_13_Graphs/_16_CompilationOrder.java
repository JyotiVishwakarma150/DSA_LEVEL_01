package _13_Graphs;
import java.io.*;
import java.util.*;
public class _16_CompilationOrder {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
        }

        // write your code here
        boolean[] visited = new boolean[vtces];// visited[]: track karega ki kaunse nodes visit ho chuke hain
        Stack<Integer> st = new Stack<>();// Stack: final topological order store karne ke liye
        for(int v=0;v<vtces;v++){// Har vertex ke liye check kar rahe hain ki wo visited hai ya nahi Agar nahi, to topologicalSort() (DFS) call kar rahe hain.
            if(visited[v]==false){
                topologicalSort(graph,v,visited,st);
            }
        }
        while(st.size()>0){// Stack me jo order hai, usko pop karke print kar rahe hai Ye hi final topological order hai!
            System.out.println(st.pop());
        }
    }
    public static void topologicalSort(ArrayList<Edge>[] graph,int src,boolean[] visited,Stack<Integer> st){
        visited[src]=true;// Sabse pehle current src node ko visited mark kar diya
        //Har neighbor ke liye check kar rahe hain
        //Agar wo visit nahi hua, to us pe bhi DFS call kar do
        for(Edge e:graph[src]){
            if(visited[e.nbr]==false){
                topologicalSort(graph,e.nbr,visited,st);
            }
        }
        st.push(src);// Jab saare neighbors explore ho jaayein, tab current node ko stack me daal do
    }
}
