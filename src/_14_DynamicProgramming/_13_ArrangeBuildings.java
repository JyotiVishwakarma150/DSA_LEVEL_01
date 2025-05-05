package _14_DynamicProgramming;

import java.util.Scanner;

public class _13_ArrangeBuildings {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        long n = scn.nextInt();
//        int[] dp0 = new int[n+1];
//        int[] dp1 = new int[n+1];
//        dp0[1]=1;
//        dp1[1]=1;
//        for(int i=2;i<=n;i++){
//            dp1[i]=dp1[i-1]+dp0[i-1];
//            dp0[i]=dp1[i-1];
//        }
//        int tc = dp1[n]+dp0[n];
//        System.out.println(tc*tc);
        //long int mein lena pdega kyuki int ki range kam pad jarhi hai
        long ob=1;//old building
        long os=1;// old space
        for(int i=2;i<=n;i++) {
            long nb = os;//new building
            long ns = os+ob;//new space
            os=ns;
            ob=nb;
        }
        long total = os+ob;
        total=total*total;//total dono sides ka combination
        System.out.println(total);
    }

}
