package _14_DynamicProgramming;

import java.util.Scanner;

public class _16_MaxSumNonAdjacentElements {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int inc = arr[0];//phle element ko include krte hai
        int exc =0;//phle element ko exclude mtlb lege hi nhi
        for(int i=1;i<arr.length;i++){
            int ninc = exc+arr[i];//new include ... purana exclude aur present element add krdege
            int nexc = Math.max(inc,exc);//new exclude mein puchle wale include aur exclude mein jo bda hoga usko lege
            //dono values ko update krdege
            inc = ninc;
            exc = nexc;
        }
        int ans = Math.max(inc,exc);//last answer jo max include and exclude hain unka max hoga
        System.out.println(ans);
    }
}
