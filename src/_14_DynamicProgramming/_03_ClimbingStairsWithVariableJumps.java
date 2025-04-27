package _14_DynamicProgramming;

import java.util.Scanner;

public class _03_ClimbingStairsWithVariableJumps {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();// No. of stairs input le rahe hain
        int[] arr = new int[n];//Ek array banayi jisme har stair se max kitna jump kar sakte ho, wo store hoga
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt(); //Har stair ki jump capacity input le rahe hain
        }
        int[] dp = new int[n+1];//Ek DP array banayi jisme dp[i] ka matlab hai i-th stair se destination tak kitne ways hain
        dp[n]=1;//Destination pe pahunch gaye to ek hi tarika hai wahan rehne ka (base case)
        for(int i=n-1;i>=0;i--){//Last se pehle wale stair se start karenge
            for(int j=1;j<=arr[i]&&i+j<dp.length;j++){
                dp[i] += dp[i+j];// i se jitna jump allowed hai, utne aage wale dp values ka sum kar rahe hain
            }
        }
        System.out.println(dp[0]);//dp[0] me answer hoga: stair 0 se destination tak kitne ways hain
    }
}
