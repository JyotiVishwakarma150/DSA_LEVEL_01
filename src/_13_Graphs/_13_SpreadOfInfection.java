package _13_Graphs;
import java.io.*;
import java.util.*;
public class _13_SpreadOfInfection {
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
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        // write your code here
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src,1));//src ,t=1 pr wo bimar hogya tha
        // Visited array store karta hai kis time pe person infect hua tha
        int[] visited = new int[vtces]; // 0 means not visited
        int count=0;
        while(q.size()>0){
            Pair rem = q.removeFirst();
            if(visited[rem.v] > 0){ //Agar wo already infected hai,toh skip kar do (usko dobara infect nahi karna)
                continue;
            }
            visited[rem.v]=rem.time; //Us person ko mark kar do ki kis time pe wo infect hua
            if(rem.time>t){//Agar infect hone ka time t se bada hai toh iske baad koi bhi person infect nahi ho sakta
                break;
            }
            count++;  // Ek valid infected person mil gaya, count++
            for(Edge e: graph[rem.v]){//Ab uske neighbors ko check karo
                if(visited[e.nbr]==0){ //    Jo neighbor abhi tak infect nahi hua
                    q.add(new Pair(e.nbr, rem.time+1));
                    //usko queue mein daal do next time slot mein infect hone ke liye
                }
            }
        }
        System.out.println(count);

    }
     public static class Pair{
        int v;
        int time;
        Pair(int v,int time){
            this.v=v;
            this.time=time;
        }
     }
}
