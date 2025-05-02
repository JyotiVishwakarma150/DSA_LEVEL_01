package _14_DynamicProgramming;

import java.util.Scanner;

public class _09_CoinChangePermutations {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        int[] dp = new int[tar + 1];
        dp[0] = 1;
//        for(int i=1;i<=tar;i++) {
//            for (int j = 0; j < coins.length; j++) {
//                if (i - arr[j] >= 0) {
//                    dp[i] += dp[i - arr[j]];
//                }
//            }
//        }
        // outer loop : Hum har amount (1 se tar tak) ke liye dp[amt] calculate kar rahe hain
        for(int amt=1;amt<=tar;amt++){
            // inner loop : Har coin ke liye check kar rahe ho:"Kya main is coin ko last mein use karke amount amt bana sakta hoon?"
            for(int coin : coins){
                if(coin <= amt){//Yeh ensure karta hai ki hum negative index pe na chale jaayein
                    int ramt = amt-coin;//ramt = remaining amount agar last mein coin lagaya
                    dp[amt] += dp[ramt];//Agar dp[ramt] ke X tareeke hain, to
                    // ab dp[amt] ke X tareeke aur badh gaye (kyunki humne coin last mein lagaya)
                    //permutation bn gya
                }
            }
        }
        System.out.println(dp[tar]);
    }
}
