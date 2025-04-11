package _13_Graphs;
import java.io.*;
import java.util.*;
public class _01_HasPath {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for(int i = 0; i < vtces; i++){
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for(int i = 0; i < edges; i++){
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            //Graph undirected hai, isliye har edge dono direction mein add ho rahi hai — v1 -> v2 aur v2 -> v1.
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());

        // write your code here
        boolean[] visited = new boolean[vtces];
        boolean path = hasPath(graph,src,dest,visited);
        System.out.println(path);
    }
    //Yeh function DFS (Depth First Search) ka use karke yeh check karta hai ki src se dest tak koi path hai ya nahi.
    public static boolean hasPath(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited) {
        if (src == dest) {//Agar hum destination par pahunch gaye toh path mil gaya — return true.
           return true;
        }
        visited[src] = true;//Taki hum dubara ussi node par na chale jayein (infinite loop se bachein).
        //Agar kisi neighbor ke through path mil jata hai destination tak, to return true.
        for(Edge edge : graph[src]){
            if(visited[edge.nbr]==false){
                boolean hasNbrPath = hasPath(graph,edge.nbr,dest,visited);
                if(hasNbrPath == true){
                    return true;
                }
            }
        }
        return false;
    }

}

