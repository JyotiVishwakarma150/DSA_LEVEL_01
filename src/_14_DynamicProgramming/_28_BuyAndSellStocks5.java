package _14_DynamicProgramming;

import java.util.Scanner;

public class _28_BuyAndSellStocks5{ // two transaction allowed only
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int mpist =0;// max. profit if sold today..(transaction 1)
        int leastsf = arr[0]; // least so far (sabse kam price ab tak ka)
        int[] dpl = new int[arr.length]; // left pass ke liye (pehla transaction)
        // Ye loop ensure karta hai ki har index tak ka best possible profit store ho jaye first transaction ke liye.
        for(int i=1;i<arr.length;i++){
            if(arr[i]<leastsf){// agar naye price pehle se kam hai
                leastsf=arr[i];  //least ko update  krdege
            }
            mpist=arr[i]-leastsf;// current profit agar aaj bechein to
            if(mpist>dpl[i-1]){ // agar profit pichhle max se zyada hai
                dpl[i]=mpist; // update karo dpl[i]
            }else{
                dpl[i]=dpl[i-1]; // warna pichhla hi consider kr lege
            }
        }

        int mpibt = 0;// max. profit if bought today..(transaction 1)
        int maxat=arr[arr.length-1];//max. after today ..sabse zyada price ab tak ka from right
        int[] dpr = new int[arr.length];// right pass ke liye (dusra transaction)
        //Ye loop ensure karta hai ki har index se end tak ka best possible profit store ho jaye second transaction ke liye
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>maxat){// agar naye price pehle se zyada hai
                maxat=arr[i]; // update maxat
            }
            mpibt=maxat-arr[i]; // current profit agar aaj kharidein to
            if(mpibt>dpr[i+1]){// agar profit next max se zyada hai
                dpr[i]=mpibt;// update karo dpr[i]
            }else{
                dpr[i]=dpr[i+1];// warna agla hi le lo
            }
        }
        int op=0;
        //dpl[i] + dpr[i] har index pe calculate kiya, and jo max nikla wo answer h
        for(int i=0;i<arr.length;i++){
            if(dpl[i]+dpr[i]>op){
                op=dpl[i]+dpr[i];
            }
        }
        System.out.println(op);
    }
}
