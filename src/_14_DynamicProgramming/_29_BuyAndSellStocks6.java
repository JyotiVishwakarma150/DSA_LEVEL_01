package _14_DynamicProgramming;

import java.util.Scanner;

public class _29_BuyAndSellStocks6 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        // Normal Implementation
        int k = scn.nextInt();
        int[][] dp = new int[k + 1][n];

//                for(int t = 1; t <= k; t++) {
//                    for(int d = 1; d < n; d++) {
//                        int max = dp[t][d-1];
//                        for(int pd = 0; pd < d; pd++) {
//                            int profit = dp[t-1][pd] + (arr[d] - arr[pd]);
//                            if(profit > max) {
//                                max = profit;
//                            }
//                        }
//                        dp[t][d] = max;
//                    }
//                }
//
//                System.out.println(dp[k][n-1]);
//            }
//        }

        //}
//}
        //optimized part ...implementation
        for(int t = 1; t <= k; t++) {
            int max = Integer.MIN_VALUE;
            for(int d = 1; d < arr.length; d++) {
                if(dp[t-1][d-1] - arr[d-1] > max) {
                    //if pichle din ka transaction - uss din ka price ....agr ye humare max ko harata hai to max update krdege

                    max = dp[t-1][d-1] - arr[d-1];
                }
                if(max + arr[d] > dp[t][d-1]) {
                    //Agar max me jo ab tak best buying point hai + aaj ka price Ye profit jyada aa raha hai ya Pichle din (d-1) ka profit
                    // Agar max + arr[d] jyada hai to dp[t][d] me wohi store kar do
                    dp[t][d] = max + arr[d];
                } else {// Nahi to jo pichle din ka profit tha, wahi aaj bhi hai
                    dp[t][d] = dp[t][d-1];
                }
            }
        }

        System.out.println(dp[k][n-1]);
    }
}
