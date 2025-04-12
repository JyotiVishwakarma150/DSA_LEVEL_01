package _13_Graphs;
import java.io.*;
import java.util.*;
public class _02_PrintAllPaths {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
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
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());
        //Ek visited array maintain karte hain jisse hum track kar sakein ki kaunse nodes ek path ke dauraan visit ho chuke hain.
        boolean[] visited = new boolean[vtces];
        //psf = "Path So Far" (ab tak ka bana hua path)
        printAllPaths(graph,src,dest,visited,src+"");
    }
     public static void printAllPaths(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited,String psf) {
        //Agar current node hi destination hai, toh path complete ho gaya. Print karo and return
         if (src == dest) {
             System.out.println(psf);
             return;
         }
         //Current node ko visited mark karo
         visited[src] = true;
         //Har neighbor ke liye check karo agar wo visited nahi hai, toh us path par aage jao (recursion se)
         //psf + edge.nbr ka matlab hai: path mein naye node ko jod dena
         for (Edge edge : graph[src]) {
             if (visited[edge.nbr] == false) {
                 printAllPaths(graph, edge.nbr, dest, visited, psf + edge.nbr);
             }
         }
         //Backtracking: Jab ek path explore ho jaaye, toh wapas aake us node ko unvisited mark karo, taki doosre paths mein use kiya ja sake
         visited[src] = false;
     }
}
