package _14_DynamicProgramming;

import java.util.Scanner;

public class _02_ClimbingStairs {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
       // int cp=countPaths(n, new int[n+1]);
        int cp = countPathsTab(n);
        System.out.println(cp);
    }
    public static int countPaths(int n,int[] qb){
        if(n==0){
            return  1;
        } else if (n<0) {
            return 0;
        }
        if(qb[n]>0){
            return qb[n];
        }
        int nm1 = countPaths(n-1,qb);
        int nm2 = countPaths(n-2,qb);
        int nm3 = countPaths(n-3,qb);
        int cp = nm1 + nm2 + nm3;
        qb[n]=cp;
        return cp;
    }
    public  static int countPathsTab(int n){
        int[] dp = new int[n+1];//dp[i] ka matlab: i-th step tak pahuchne ke total ways
        //Size n+1 isliye, kyunki 0 se leke n tak store karenge.
        dp[0]=1;//Step 0 pe khade ho already — us tak aane ka ek hi tareeka hai: kuch bhi mat karo
        for(int i=1;i<=n;i++){//Har step i ke liye calculate karo ki wahan tak kaise aa sakte ho
            if(i==1){
                dp[i]=dp[i-1];//Bas ek step pichhle se aa sakte ho (i.e., 0 → 1)
            }else if(i==2){//2 treek se i tak phuch skte hain
                dp[i]=dp[i-1]+dp[i-2];
            }else {//Ab tum 3 tareeke se i tak pahuch sakte ho
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }
        return dp[n];//n-th step tak pahuchne ke total ways dp[n] mein store honge
    }
}
