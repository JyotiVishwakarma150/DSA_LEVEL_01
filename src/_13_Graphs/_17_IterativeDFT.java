package _13_Graphs;
import java.io.*;
import java.util.*;
public class _17_IterativeDFT {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
      public static class Pair{
        int v;
        String psf;
        Pair(int v,String psf){
            this.v=v;
            this.psf=psf;
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

        // write your code here
        boolean[] visited = new boolean[vtces];//Yeh array track karega ki kaunse nodes already visit ho chuke hain
        Stack<Pair> st = new Stack<>();//DFS ke liye stack use ho raha hai
        st.push(new Pair(src,src+""));//Pehle source node ko stack mein daala, path so far mein wahi node hai
        while(st.size()>0){
            Pair rem = st.pop();//Stack se ek node nikala (LIFO order – last in first out)
            if(visited[rem.v] == true){//Agar node already visit ho chuki hai, to usko skip kar do
                continue;
            }
            visited[rem.v] = true;//Node ko visit mark karo
            System.out.println(rem.v+"@"+rem.psf);//Print karo: current node + us tak ka path.
            for(Edge e:graph[rem.v]){//Har neighbour ke liye:
                //Agar wo visited nahi hai, to stack mein daal do with updated path
                if(visited[e.nbr]==false){
                    st.push(new Pair(e.nbr,rem.psf+e.nbr));
                }
            }
        }
    }

}
