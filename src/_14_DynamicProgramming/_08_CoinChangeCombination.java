package _14_DynamicProgramming;

import java.util.Scanner;

public class _08_CoinChangeCombination {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        int amt = scn.nextInt();//amt input liya — target amount jisko banane ke liye combinations chahiye
        //dp array banayi jisme dp[i] ka matlab hai: kitne combinations se amount i ban sakta hai.
        int[] dp = new int[amt+1];
        //Base case: 0 amount banane ka 1 tareeka hota hai — koi coin na lena.
        dp[0]=1;
        //Har coin ko consider kar rahe hain ek-ek karke
        //Yeh isliye important hai kyunki order matter nahi karta — isliye coin pehle fix kar rahe hain
        for(int i=0;i<arr.length;i++){
            //j represent karta hai current amount
            //Agar hum arr[i] coin use karte hain, toh j amount banane ke combinations mein dp[j - arr[i]] aur add ho jaayenge
            for(int j=arr[i];j<dp.length;j++){
                //Agar tum arr[i] coin use karoge, toh j banana ka naya tareeka hoga:
                //jitne tareeke se j - arr[i] ban sakta hai.
                dp[j]+=dp[j-arr[i]];
            }
        }
        System.out.println(dp[amt]);
    }
}
