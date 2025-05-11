package _14_DynamicProgramming;

import java.util.Scanner;

public class _21_TilingTiles2 {
    public static void main(String[] args) throws Exception {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int m = scn.nextInt();
      int[] dp = new int[n+1];
      for(int i=1;i<=n;i++){
          //base case
          if(i<m){//agr floor ki length tile se chhoti h to sirf 1 hi way hoga ...ya fr tile lga hi ni skte
              dp[i]=1;
          }else if(i==m){//agr floor ki length tile ke equal hai to ways honge ..ya to sare tiles vertically lgao ya fr sare horizontally
              dp[i]=2;
          }else{
              //main kaam ye line kregi
              //agr floor bda hai tbbb...jb hum vertically rkhege tbb i-1 space bchega ,horizontally rkhege to i-m space bchegi
              dp[i] = dp[i - 1] + dp[i - m];
          }
      }
        System.out.println(dp[n]);
   }
}
