package _12_HashmapsAndHeap;

import java.util.HashMap;
import java.util.Scanner;

public class _05_LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
        HashMap<Integer,Boolean> map = new HashMap<>();//Boolean represents that ... sequence yha se start hota hai ya nhi
        // Pehle sabhi elements ko map mein true ke saath daal dete hain.
        //Matlab: initially har element ko sequence ka start point assume kar rahe hain
        for(int val:arr){
            map.put(val,true);
        }
        //Ab check karte hain har element ke liye:
        for(int val:arr){
            if(map.containsKey(val-1)){//Agar usse 1 chhota element (val - 1) bhi present hai, to yeh val sequence ka starting point nahi ho sakta.
                map.put(val,false);    //Isliye uska boolean false kar dete hain.
            }
        }
        int msp =0; //max start point
        int ml = 0;//max length
        for(int val:arr){
            if(map.get(val)==true){// Ab har start point (true wale) se sequence bana ke dekhte hain
                int tl=1; //tl = temporary length
                int tsp = val;//tsp=temporary start point
                //Jab tak val+1, val+2, ... map mein milte jaate hain → length badhate jaao
                while(map.containsKey(tsp+tl)){
                    tl++;
                }
                //Agar current sequence ka length ml se zyada hua, to msp aur ml update karo
                if(tl>ml){
                    msp=tsp;
                    ml=tl;
                }
            }
        }
        // Final sequence print kar di jaati hai — msp se ml tak.
        for(int i=0;i<ml;i++){
            System.out.println(msp+i);
        }
    }
}
