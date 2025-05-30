package _14_DynamicProgramming;
import java.util.Scanner;
public class _18_PaintHouse {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int[][] arr = new int[n][3];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=scn.nextInt();
            }
        }
        long[][] dp = new long[n][3];
        // phle house ke phle koi house nhi hai,
        // isliye uske liye sirf wahi cost hogi jo input mein di gayi hai
        dp[0][0]=arr[0][0];
        dp[0][1]=arr[0][1];
        dp[0][2]=arr[0][2];
        for(int i=1;i<arr.length;i++){
            //red=0,blue=1,green=2
            //agr hum house i ko red se paint krege (j=0)toh uske phle wale house se green aur blue lege
            //same color allowed nhi hai ,isiliye hum previous house ke dusre 2 colors mein se minimum cost choose krege
            dp[i][0]=arr[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=arr[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2]=arr[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
        }
        //last house yani ki (n-1) pr phuchege to teeno colors mein jo minimum hoga usko print krdege
        long ans = Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
        System.out.println(ans);
    }
}
