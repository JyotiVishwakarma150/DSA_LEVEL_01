package _14_DynamicProgramming;

import java.util.Scanner;

public class _12_CountBinaryStrings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
//        int[] dp0 = new int[n+1];
//        int[] dp1 = new int[n+1];
//        dp0[1]=1;
//        dp1[1]=1;
//        for(int i=2;i<=n;i++){
//            dp1[i]=dp1[i-1]+dp0[i-1];
//            dp0[i]=dp1[i-1];
//        }
//        System.out.println(dp1[n]+dp0[n]);
//    }
      int oczeros=1;//oczeros = old count of strings ending with 0
      int ocones=1;//ocones = old count of strings ending with 1
      for(int i=2;i<=n;i++){
          //nczeros: new count of strings ending with 0 for length
          //ncones: new count of strings ending with 1 for length i
          //Agar tumhare last char 0 hona chahiye,
          // toh previous character sirf 1 ho sakta hai (kyunki 2 0 allowed nahi)
          int nczeros=ocones;
          //Agar last char 1 ho, toh tum 0 ya 1 dono se string ko extend kar sakte ho
          int ncones=oczeros+ocones;
          ocones=ncones;
          oczeros=nczeros;
      }
        System.out.println(oczeros+ocones);
    }
}
