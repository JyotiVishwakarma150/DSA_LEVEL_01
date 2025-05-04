package _14_DynamicProgramming;

import java.util.Scanner;

public class _10_ZeroOneKnapsack {
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
        int[][] dp = new int[n+1][cap+1];
        for(int i=1;i<dp.length;i++){//Loop over items (i) and capacity (j)
            for(int j=1;j<dp[0].length;j++){
                //Agar item i-1 ka weight cuts[i-1] current capacity j se kam ya equal hai, toh:
                //Remainder capacity = j - weight
                //Ab check karenge: agar item lo toh better hai ya na lo
                if(j>=wts[i-1]){
                    int rcap = j-wts[i-1];
                    if(dp[i-1][rcap]+vals[i-1]>dp[i-1][j]){//Item lete hain
                        dp[i][j] = dp[i-1][rcap]+vals[i-1];
                    }else{
                        dp[i][j] = dp[i-1][j];//Item nahi lete
                    }
                }else{//Agar weight allow nahi karta toh item nahi le sakte, toh same value copy karo.
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][cap]);
    }
}
