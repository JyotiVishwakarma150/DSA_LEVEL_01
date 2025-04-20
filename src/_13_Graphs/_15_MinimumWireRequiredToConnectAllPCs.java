package _13_Graphs;
import java.io.*;
import java.util.*;
public class _15_MinimumWireRequiredToConnectAllPCs {
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
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,-1,0));//Sabse pehle node 0 se start karte hain
        boolean[] visited = new boolean[vtces];//Har vertex ke liye track karenge ki wo MST me aa chuka hai ya nahi.Cycle avoid karne ke liye ye important hai.
        while(pq.size()>0){
            Pair rem = pq.remove();//pq.remove() se sabse chhoti weight wali edge nikalte hain
            if(visited[rem.v]==true){//Agar node already MST me hai, skip kar do
                continue;
            }
            visited[rem.v]=true;//Mark as visited.
            if(rem.av!=-1){
                //MST ka ek edge print karo — rem.v ko rem.av se rem.wt cost me joda gaya hai.
                System.out.println("[" +rem.v+ "-"+rem.av+"@"+rem.wt+"]");
            }
            //Current vertex ke saare neighbors dekho.
            //Agar neighbor visit nahi hua, toh usse queue me daal do with updated info.
            for(Edge e: graph[rem.v]){
                if(visited[e.nbr]==false){
                    pq.add(new Pair(e.nbr,rem.v,e.wt));
                }
            }
        }
    }
    public static class Pair implements  Comparable<Pair>{
        int v;
        int av;
        int wt;
        Pair(int v,int av,int wt){
            this.v=v;
            this.av=av;
            this.wt=wt;
        }
        public int compareTo(Pair o){
            return this.wt-o.wt;
        }
    }
}
