package _03_Function;
import java.util.Scanner;
public class _01_nPr {
    public static void display(int n,int r,int npr){
        System.out.println(n + " p " + r + " = " + npr);
    }
    public static int fact(int x){
        int rv=1;
        for(int i=1;i<=x;i++){
            rv = rv*i;
        }
        return rv;
    }
    public static void main(String[] args) {
     Scanner scn = new Scanner(System.in);
     int n= scn.nextInt();

     int r = scn.nextInt();
      int nfact = fact(n);
      int nmrfact = fact(n-r);
    int   npr = nfact / nmrfact;
      display(n,r,npr);
}
   }
