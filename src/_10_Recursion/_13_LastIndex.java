package _10_Recursion;

import java.util.Scanner;

public class _13_LastIndex {
    //    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        int n = scn.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = scn.nextInt();
//        }
//        int x = scn.nextInt();
//        int nd = LastIndex(arr, arr.length-1,x);
//        System.out.println(nd);
//    }
//    public static int LastIndex(int[] arr,int idx,int x){
//        if(idx== 0){
//            return -1;
//        }
//        int liisa = LastIndex(arr,idx-1,x);
//        if(arr[idx] ==x){
//            return idx;
//        } else{
//            return liisa;
//        }
//    }
//}
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        int li = LastIndex(arr, 0, x);
        System.out.println(li);
    }

    public static int LastIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }
        int liisa = LastIndex(arr, idx + 1, x);
        if (liisa == -1) {
            if (arr[idx] == x) {
                return idx;
            } else {
                return -1;
            }
        } else {
            return liisa;
        }
    }
}
