package _13_Graphs;
import java.io.*;
import java.util.*;
public class _08_PerfectFriends {
    public static class Edge{
        int v;
        int n;
        Edge(int v,int n){
            this.v=v;
            this.n=n;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int v=0;v<n;v++){
            graph[v]=new ArrayList<>();
        }
        //Ye input se har edge ko read kar ke graph me add karta hai (undirected graph hai to dono direction me add karta hai).
        for(int e=0;e<k;e++){
            String line = br.readLine();
            String[] parts = line.split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1,v2));
            graph[v2].add(new Edge(v2,v1));
        }
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for(int v=0;v<n;v++){
            if(visited[v]==false){
                ArrayList<Integer> comp = new ArrayList<>();
                drawTreeAndCreateComp(graph,v,comp,visited);
                comps.add(comp);
            }
        }
        //DFS ka function: given a node, uske saare connected nodes ko explore karta hai
        //Ye final kaam karta hai:
        int pairs=0;
        for(int i=0;i<comps.size();i++){
            for(int j=i+1;j<comps.size();j++){
                int count=comps.get(i).size()*comps.get(j).size();//Har 2 components ke sizes ko multiply karta hai.
                pairs += count;//Kyunki har node from comp1 can pair with each node from comp2
            }
        }
        System.out.println(pairs);
    }
    //Har unvisited node ke liye DFS chala ke ek component banata hai
    public static void drawTreeAndCreateComp(ArrayList<Edge>[] graph,int src,ArrayList<Integer> comp,boolean[] visited){
        visited[src] = true;
        comp.add(src);
        for(Edge e: graph[src]){
            if(visited[e.n]==false){
                drawTreeAndCreateComp(graph,e.n,comp,visited);
            }
        }
    }
}
