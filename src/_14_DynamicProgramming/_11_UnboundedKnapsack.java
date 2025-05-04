package _14_DynamicProgramming;

import java.util.Scanner;

public class _11_UnboundedKnapsack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int[] vals=new int[n];
        int[] wts = new int[n];
        for(int i=0;i<vals.length;i++){
            vals[i]=scn.nextInt();
        }
        for(int i=0;i<wts.length;i++){
            wts[i]=scn.nextInt();
        }
        int cap =scn.nextInt();
        //dp[i] → maximum value jo i capacity ke bag mein aa sakti hai.
        //dp[0] = 0 kyunki bag mein kuch daala hi nahi, toh value bhi 0.
        int[] dp = new int[cap+1];
        dp[0]=0;
        for(int bagc=1;bagc<=cap;bagc++){//Outer loop: 1 se cap tak → har capacity ke liye max value calculate karenge
            int max=0;//bagc means current bag capacity
            for(int i=0;i<n;i++){//Inner loop: har item check karo.
                //Agar item ka weight current bag capacity se kam ya equal hai, toh usse include kar sakte ho.
                if(wts[i]<=bagc){
                    //rbagc → remaining capacity after taking item i
                    //rbagv → us remaining capacity ki best value
                    //tbagv → agar main item i add karu, toh total value kya banegi?
                    int rbagc=bagc-wts[i];
                    int rbagv=dp[rbagc];
                    int tbagv=rbagv+vals[i];
                    //Sabhi items try karne ke baad, jo bhi maximum value mil rahi hai
                    // current capacity bagc ke liye, usse store kar diya dp[bagc] mein.
                    if(tbagv>max){
                        max=tbagv;
                    }
                }
            }
            dp[bagc]=max;
        }
        System.out.println(dp[cap]);
    }
}
