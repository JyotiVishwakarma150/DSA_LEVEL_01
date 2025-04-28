package _14_DynamicProgramming;

import java.util.Scanner;

public class _05_MinCostMazeTraversal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        int[][] dp = new int[n][m];//Ye batayega ki kisi cell se destination tak minimum cost kitni lagegi
        //Loop start kiya bottom-right se (last cell se) left aur up ki taraf
        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1;j>=0;j--){
                //Agar hum destination (last cell) pe hain, toh cost wahi hogi jo uss cell ka cost hai.
                if(i==dp.length-1 && j==dp[0].length-1){
                    dp[i][j] = arr[i][j];
                }
                //Agar hum last row me hain:
                //Sirf right ja sakte hain
                //Cost = current cell ka cost + right wale cell ki minimum cost.
                else if(i==dp.length-1){
                    dp[i][j] = dp[i][j+1] + arr[i][j];
                }
                //Agar hum last column me hain:
                //Sirf down ja sakte hain.
                //Cost = current cell ka cost + neeche wale cell ki minimum cost.
                else if(j==dp[0].length-1){
                    dp[i][j]=dp[i+1][j] + arr[i][j];
                }
                //Baaki ke cases:
                //Ya toh right ja sakte hain ya down.
                //Jo minimum cost hoga un dono mein, usme apne cell ka cost add karenge.
                else{
                    dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])+arr[i][j];
                }
            }
        }

        System.out.println(dp[0][0]);
    }
}
