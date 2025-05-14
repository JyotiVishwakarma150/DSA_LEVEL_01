package _14_DynamicProgramming;

import java.util.Scanner;
//pending....
public class _26_BuyAndSellStocks3 { //  BuyAndSellStocks with transaction fee- infinite transactions allowed
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int fee = scn.nextInt();
        int obsp = -arr[0];//Old Bought State Profit- (Initially -arr[0]) → Pehle din stock kharid liya.
        int ossp = 0;// Pehle din kuch nahi kiya to profit 0
        for(int i=0;i<arr.length;i++){
            int nbsp=0;
            int nssp=0;
            if(ossp - arr[i]>obsp){
                nbsp = ossp-arr[i];
            }else{
                nbsp=obsp;
            }
            if(obsp + arr[i] - fee > ossp){
                nssp = obsp+arr[i]-fee;
            }else{
                nssp=ossp;
            }
            obsp=nbsp;
            ossp=nssp;
        }
        System.out.println(ossp);
    }
}
