package _14_DynamicProgramming;

import java.util.Scanner;

public class _22_FriendsPairing {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            //dp[i - 1]...agar ith friend single rhe, to phle wale (i-1) friends ke arrangements dp[i-1] honge
            //Jab ith friend pair bana leta hai kisi ek ke saath,
            // to bache hue (i-2) logon ke pairing ke total ways hote hain dp[i-2].
            dp[i]=dp[i-1]+dp[i-2]*(i-1);
        }
        System.out.println(dp[n]);
    }
}
