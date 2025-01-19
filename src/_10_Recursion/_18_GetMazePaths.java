package _10_Recursion;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class _18_GetMazePaths {

    public static void main(String[] args) throws Exception {
       Scanner scn= new Scanner(System.in);
       int n = scn.nextInt();
       int m = scn.nextInt();
       ArrayList<String> paths = getMazePaths(1,1,n,m);// top left se bottom right jana h
        System.out.println(paths);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr==dr && sc==dc){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> hpaths = new ArrayList<>();
        ArrayList<String> vpaths = new ArrayList<>();
        /* agr last row mein hain to sirf horizontal call lgegi aur agr last column mein honge
        to sirf vertical call hi lgegi to ye dono if condition dikhate hai yhi */
        if(sc<dc){
            hpaths= getMazePaths(sr,sc+1,dr,dc); // horizontal move h kyunki column badha hai ... faith
        }
        if(sr<dr){
            vpaths = getMazePaths(sr+1,sc,dr,dc);// vertical move hai kyunki row badha hai .... faith
        }
        ArrayList<String> paths = new ArrayList<>();
        for(String hpath: hpaths){
            paths.add("h" + hpath);
        }
        for(String vpath: vpaths){
            paths.add("v"+vpath );
        }
        return paths;
    }

}
