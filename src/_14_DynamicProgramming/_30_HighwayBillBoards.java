package _14_DynamicProgramming;
import java.util.Scanner;
import  java.util.*;
public class _30_HighwayBillBoards {
    //1st approach - order of n*n means
   // public static int solution(int m, int[] x, int[] rev, int t) {
//        int[] dp = new int[x.length];//dp array hr board tkk ka max revenue store krega
//        int ans = 0;
//
//        dp[0] = rev[0];// first board ka revenue directly assign krdiya
//
//        for (int i = 1; i < x.length; i++) {//Har board ke liye
//            int max = 0;
//            for (int j = i - 1; j >= 0; j--) {//Pichhle saare boards (j) check karo
    //Agar x[i] - x[j] > t, matlab distance valid hai → to uspe lagaye hue board ka revenue consider karo
//                int dist = x[i] - x[j];
    //Jo max revenue milega valid boards se, usme current board ka rev[i] add karo
//                if (dist > t) {
//                    max = Math.max(max, dp[j]);
//                }
//            }
//            dp[i] = max + rev[i];
//            ans = Math.max(ans, dp[i]);
//        }
//
//        return ans;
    //}
    //2nd approach  order of m (Miles)
        public static int solution(int m, int[] x, int[] rev, int t) {
            HashMap<Integer, Integer> map = new HashMap<>();//Ek map banaya: mile -> revenue
            // Socha jaa sake ki kaunse mile pe billboard lag sakta hai
            for (int i = 0; i < x.length; i++) {
                map.put(x[i], rev[i]);
            }

            int[] dp = new int[m + 1];
            dp[0] = 0;
            //Har mile i pe check kar rahe hain
            //Kya yahan billboard lag sakta hai? (i.e. map.containsKey(i))
            for (int i = 1; i <= m; i++) {
                if (map.containsKey(i)==false) {
                    dp[i] = dp[i - 1];
                } else {
                    //Do options:
                    //Yahan board mat lagao → last mile tak ka revenue le lo.
                    //Yahan board lagao → current board ka revenue le lo
                    int boardNotInstalled = dp[i - 1];
                    int boardInstalled = map.get(i);
                    //Agar t ka gap maintain kar sakte ho:
                    //Pichle valid point tak ka revenue add kar do
                    if (i >= t + 1) {
                        boardInstalled += dp[i - t - 1];
                    }
                    // Dono options ka max le lo
                    dp[i] = Math.max(boardNotInstalled, boardInstalled);
                }
            }

            return dp[m];
}


    public static void input(int[] arr, java.util.Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }

    public static void main(String[] args) {
        java.util.Scanner scn = new java.util.Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int[] x = new int[n];
        input(x, scn);

        int[] revenue = new int[n];
        input(revenue, scn);

        int t = scn.nextInt();
        System.out.println(solution(m, x, revenue, t));
        scn.close();
    }
}