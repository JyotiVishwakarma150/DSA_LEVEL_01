package _15_Strings;
import java.io.*;
import java.util.*;
public class _07_PermutationsOfStrings{
    public static void solution(String str){
        // write your code here
        int n=str.length();
        int f = factorial(n);// phle factorial find krege string ka
        for(int i=0;i<f;i++){//i=0 se f-1tk loop ko chlayege ...hr iteration me ek permutation generate hojyegi
            StringBuilder sb = new StringBuilder(str);
            int temp = i;// i ko bachakr rkh liya kyuki i pr  operations honge to i ka asli value khtm ho jyega
            for(int div=n;div>=1;div--){// ye loop hr level pr ek character fix krne k liye chlaya gya h
                int q = temp/div;//ye line ya nikalti h ki ..konsa character nikalna h
                int r = temp%div;// ye line next round ke liye temp ko update krti hai
                System.out.print(sb.charAt(r));//rth position ka character print krdo
                sb.deleteCharAt(r);// fr ussi character ko dlt krdo taki agle level pr usse dubara se use nhi kre
                temp=q;// temp update kiya next level k liye
            }
            System.out.println();




        }
    }
    public static int factorial(int n){
        int val=1;
        for(int i=2;i<=n;i++){
            val*=i;
        }
        return val;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);
    }

}
