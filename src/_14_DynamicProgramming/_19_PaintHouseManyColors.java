package _14_DynamicProgramming;

import java.util.*;

public class _19_PaintHouseManyColors {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // Number of houses
        int c = scn.nextInt(); // Number of colors

        int[][] arr = new int[n][c];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt(); // Cost to paint house i with color j
            }
        }

        int[][] dp = new int[arr.length][arr[0].length];
        // least aur sleast mein abbi max value hi dalege
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;

        for (int j = 0; j < arr[0].length; j++) {
            dp[0][j] = arr[0][j]; // pehla ghar direct cost se bhar diya
             // Pehle row me least aur second least cost nikal li
            if (arr[0][j] <= least) {
                sleast = least;
                least = arr[0][j];
            } else if (arr[0][j] <= sleast) {
                sleast = arr[0][j];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            //Agr previous ghar ka same color hai jo least se aaya tha → to sleast lo
            //warna least use karo
            //Bcz consecutive ghar same color nahi ho sakte
            for (int j = 0; j < dp[0].length; j++) {
                if (least == dp[i - 1][j]) {
                    dp[i][j] = sleast + arr[i][j];
                } else {
                    dp[i][j] = least + arr[i][j];
                }
                //Ye current row ka least aur sleast nikal rahe hain (jaise pehle kiya tha)
                if (dp[i][j] <= nleast) {
                    nsleast = nleast;
                    nleast = dp[i][j];
                } else if (dp[i][j] <= nsleast) {
                    nsleast = dp[i][j];
                }
            }
            //naye least aur sleast update ho gaye
            least = nleast;
            sleast = nsleast;
        }

        System.out.println(least);
    }
}
