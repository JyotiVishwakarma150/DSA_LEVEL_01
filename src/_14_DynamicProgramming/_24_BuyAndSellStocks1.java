package _14_DynamicProgramming;
import java.util.*;

public class _24_BuyAndSellStocks1 {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = scn.nextInt();
        }

        int lsf = Integer.MAX_VALUE;//least price so far
        int op = 0;//overall price
        int pist = 0;//profit if sold today

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lsf) {
                lsf = prices[i];
            }

            pist = prices[i] - lsf;
            if (pist > op) {
                op = pist;
            }
        }

        System.out.println(op);
    }
}
