package _14_DynamicProgramming;

import java.util.Scanner;

public interface _20_TilingWith2mulby1Tiles {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dp = new int[n+1];
        //base case fitted for dp[1] and dp[2]
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            //ek tile vertical lgayege to floor (i-1) bacha ,dp[i-1]ways bnege
            //do tiles horizontal lgayege floor (i-2) bachega to dp[i-2] ways  bnege
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
