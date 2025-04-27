package _14_DynamicProgramming;

import java.util.Scanner;

public class _04_ClimbingStairsWithMinimumMoves {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        Integer[] dp = new Integer[n+1];
        dp[n]=0; // Base case: Destination stair pe pahunch gaye to 0 moves lagenge
        for(int i=n-1;i>=0;i--){// Last se pehle stair se reverse mein iterate karenge
            if(arr[i]>0){
                int min = Integer.MAX_VALUE;// Minimum moves find karne ke liye initially max value set ki
                for(int j=1;j<=arr[i]&&i+j<dp.length;j++){
                    //Ab hum jitne steps tak jump kar sakte hain, utne ke liye check karenge
                    //j = 1, 2, ..., maximum allowed jump tak
                    //Saath me ye bhi check karenge ki jump karke array ke bahar na chale jaaye (i+j < dp.length).
                    if(dp[i+j] != null){
                        // Kya i+j wale stair pe jaane ka valid way exist karta hai?
                        // Agar dp[i+j] null nahi hai → matlab waha se destination tak pahuch sakte hain
                        min=Math.min(min,dp[i+j]);
                    }
                }
                if(min != Integer.MAX_VALUE){
                    dp[i]=min+1;//Agar koi valid jump mila to apne aapko update karenge
                }
            }
        }
        System.out.println(dp[0]);
        // Final answer: 0th stair se destination tak minimum moves
    }
}
