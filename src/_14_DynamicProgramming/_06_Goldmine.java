package _14_DynamicProgramming;

import java.util.Scanner;

public class _06_Goldmine {
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
        int[][] dp = new int[n][m];
        //Right to left column-wise traversal ho raha hai. Because moves right, right-up, right-down hote hain
        for(int j=arr[0].length-1;j>=0;j--){
            //Har column ke liye, rows ko bottom to top traverse kar rahe hain.
            for(int i= arr.length-1;i>=0;i--){
                //Agar last column pe ho, toh sirf wahi gold milega. No future moves
                if(j==arr[0].length-1){
                    dp[i][j] = arr[i][j];
                }else if(i==0){ // Top Row (upar se neeche jaa nahi sakte)
                    dp[i][j]=arr[i][j]+Math.max(dp[i][j+1],dp[i+1][j+1]);
                }else if(i==arr.length-1){//Bottom Row (neeche se upar jaa nahi sakte)
                    dp[i][j]=arr[i][j]+Math.max(dp[i][j+1],dp[i-1][j+1]);
                }else{// Middle Rows:Tino directions try kar sakte ho (→, ↗, ↘)
                    dp[i][j]=arr[i][j]+Math.max(dp[i][j+1],Math.max(dp[i+1][j+1],dp[i-1][j+1]));
                }
            }
        }
        //First column ke har row se start karne pe max gold collect kitna ho sakta hai – uska max nikala
        int max=dp[0][0];
        for(int i=1;i<dp.length;i++){
            if(dp[i][0]>max){
                max=dp[i][0];
            }
        }
        System.out.println(max);
    }
}
