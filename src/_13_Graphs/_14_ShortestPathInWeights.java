package _13_Graphs;
import java.io.*;
import java.util.*;
public class _14_ShortestPathInWeights {
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
        // write your code here
        //PriorityQueue use hoti hai minimum distance wale node ko pehle process karne ke liye
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,src+"",0));
        boolean[] visited =  new boolean[vtces];//Taaki kisi node ko repeat na karein (once visited, skip karo)
        while(pq.size()>0){
            Pair rem = pq.remove();//Queue se minimum weight wala path nikaal lo.
            if(visited[rem.v]==true){//Agar node already visited hai, skip karo.
                continue;
            }
            visited[rem.v]=true;//Nahi toh visit mark kar do
            //Har node ke liye:rem.v: kaunsa node :rem.psf: kis path se wahan tak aaye : rem.wsf: total weight (distance)
            System.out.println(rem.v + " via " + rem.psf + " @ "+rem.wsf);
            //Har neighbor ke liye:Agar visit nahi hua, toh uska new path bana ke queue me daal do
            for(Edge e:graph[rem.v]){
                if(visited[e.nbr] == false){
                    pq.add(new Pair(e.nbr,rem.psf+e.nbr,rem.wsf+e.wt)); //Path and total weight update karo.
                }
            }
        }
    }
    public static class Pair implements Comparable<Pair>{
        int v;
        String psf;
        int wsf;
        Pair(int v, String psf, int wsf){
            this.v=v;
            this.psf=psf;
            this.wsf=wsf;
        }
        public int compareTo(Pair o){
            return this.wsf-o.wsf;
        }
    }
}
