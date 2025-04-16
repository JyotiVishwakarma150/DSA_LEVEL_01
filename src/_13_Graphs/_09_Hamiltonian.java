package _13_Graphs;
import java.io.*;
import java.util.*;
public class _09_Hamiltonian {
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

        int src = Integer.parseInt(br.readLine());//src: starting vertex (jahan se path start hoga)
         HashSet<Integer> visited=new HashSet<>();//ek HashSet banaya gaya hai jisme hum already visited vertices ko store karenge
        //(path so far): ab tak ka path ek string ke form mein
        //osrc: original source (starting point), jiska use check karne ke liye hota hai ki path cycle banata hai ya nahi
         hamiltonian(graph,src,visited,src+"",src);
    }

    public static void hamiltonian(ArrayList<Edge>[] graph,int src,HashSet<Integer> visited,String psf,int osrc ) {
        if (visited.size() == graph.length - 1) {//Agar visited size n-1 ho gaya matlab saare vertices visit ho chuke hain ek path mein
            System.out.print(psf);//Path ko print karo
            boolean closingEdgeFound = false;
            //Check karo ki kya last vertex se starting vertex tak direct edge hai ya nahi.
            for (Edge e : graph[src]) {
                if (e.nbr == osrc) {
                    closingEdgeFound = true;
                    break;
                }
            }
            //Agar haan to Hamiltonian Cycle hai (print *), warna sirf Hamiltonian Path hai (print .)
            if (closingEdgeFound == true) {
                System.out.println("*");
            } else {
                System.out.println(".");
            }
            return;
        }
        //Har vertex ke liye recursion call kiya jata hai agar wo visited nahi hai
        visited.add(src);
        for(Edge e:graph[src]){
            if(visited.contains(e.nbr)==false){
                hamiltonian(graph,e.nbr,visited,psf+e.nbr,osrc);
            }
        }
       // Jab backtrack karte hain to visited.remove(src) se current vertex ko hata dete hain
        visited.remove(src);
    }
}
