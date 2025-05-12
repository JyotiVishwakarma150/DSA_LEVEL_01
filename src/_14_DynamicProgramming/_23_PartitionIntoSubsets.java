package _14_DynamicProgramming;
import java.io.*;
import java.util.*;

public class _23_PartitionIntoSubsets {

    public static long partitionKSubset(int n, int k) {
        // write your code here
        //base case n==0..mtlb agr log(people) hi nhi hai to 0 awys
        //k==0 ...mtlb team hi nhi h to 0 ways
        //n<k ..mtlb agr no of people ,no of team se km hai to 0 ways hain
        if(n==0 || k==0 || n<k){
            System.out.println(0);
            return 0;
        }
        long[][] dp=new long[k+1][n+1];
        for(int t=1;t<=k;t++){
            for(int p=1;p<=n;p++){
                if(p<t){
                    dp[t][p]=0;
                }else if(p==t){//team aur peoples agr barabar hain to sirf ek hi way hai
                    dp[t][p]=1;
                }else{// nhi ... to formula use krege
                    dp[t][p]=dp[t-1][p-1]+dp[t][p-1]*t;
                }
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        long res = partitionKSubset(n, k);
        System.out.println(res);
    }
}
