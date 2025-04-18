package _13_Graphs;
import java.io.*;
import java.util.*;

public class _11_IsCyclic {
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

        // write your code here
        boolean[] visited = new boolean[vtces];//Track karega ki kaunsa vertex pehle hi visit ho chuka hai
        //Har component ko check kar rahe hain. Agar kahin bhi cycle mil gaya toh true print karke return kar denge.
        for(int v=0;v<vtces;v++){
            if(visited[v] == false){
                boolean cycle = IsCyclic(graph,v,visited);
                if(cycle){
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }
    static class Pair {
        int v;
        String psf;

        Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }
    }
    public static boolean IsCyclic(ArrayList<Edge>[] graph,int src,boolean[] visited){
        //BFS queue banayi jisme Pair class se node aur path store karte hain.
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src,src+""));
        while(q.size()>0){
            Pair rem = q.removeFirst();
            if(visited[rem.v]== true){
                return true; // cycle detected!
            }
            visited[rem.v]=true;
            for(Edge e:graph[rem.v]){
                if(visited[e.nbr]==false){
                    q.add(new Pair(e.nbr,rem.psf+e.nbr));
                }
            }
        }
        return  false;
    }
}
