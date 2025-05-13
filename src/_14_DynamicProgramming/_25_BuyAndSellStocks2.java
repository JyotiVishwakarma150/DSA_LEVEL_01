package _14_DynamicProgramming;

import java.util.Scanner;

public class _25_BuyAndSellStocks2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int bd=0;//buying date at starting
        int sd=0;//selling date at starting
        int profit=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>=arr[i-1]){//we will check ..kya aj ka rate ,kal ke rate se jada ya bda hai ya brabar h
                sd++;//agr increment hai to selling date ko bdhao
            }else{//rate gir rha h means arr[i] , 1 se kam horha hai
                profit += arr[sd]-arr[bd];//to old profit collect krlo
                bd=sd=i;//buy date ur sell date ko same krdo
            }
        }
        profit += arr[sd]-arr[bd];
        System.out.println(profit);
    }
}
