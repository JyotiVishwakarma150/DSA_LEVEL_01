package _14_DynamicProgramming;

import java.util.Scanner;

public class _07_TargetSumSubsets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        int tar = scn.nextInt();
        boolean[][] dp = new boolean[n+1][tar+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++) {
                //Jab array empty hai (i=0) aur target bhi 0 hai → empty subset ka sum 0 hota hai → true
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                }
                //Agar array empty hai aur target >0 hai → not possible → false
                else if (i == 0) {
                    dp[i][j] = false;
                }
                //Agar target 0 hai → empty subset se possible → true
                else if (j == 0) {
                    dp[i][j] = true;
                }
                //Exclude current element → Agar previous row me same target possible tha, toh ab bhi hoga
                else {
                    if (dp[i - 1][j] == true) {
                        dp[i][j] = true;
                    }
                    //Include current element:
                    //Agar target >= arr[i-1] (current element)
                    //Aur dp[i-1][j - val] == true hai → toh current element include karke target bana sakte ho
                    else {
                        int val = arr[i - 1];
                        if (j >= val) {
                            if (dp[i - 1][j - val] == true) {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(dp[arr.length][tar]);
    }
}
