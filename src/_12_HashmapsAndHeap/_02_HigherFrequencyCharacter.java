package _12_HashmapsAndHeap;

import java.util.HashMap;
import java.util.Scanner;

public class _02_HigherFrequencyCharacter {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<str.length();i++){ //Loop chala rahe hain poori string par, har ek character ka count increase kar rahe hain.
            char ch = str.charAt(i);
            if(hm.containsKey(ch)){
                int of = hm.get(ch); // of = old frequency
                int nf = of+1; // nf=new frequency.... Agar character pehle se hai, toh uski frequency 1 se badha dete hain
                hm.put(ch,nf);
            }else{ //Agar character pehli baar aaya hai, toh 1 set kar dete hain
                hm.put(ch,1);
            }
        }
        //mfc variable banaya jo sabse zyada repeat hone wale character ko store karega.
        char mfc = str.charAt(0); // mfc = max frequency character
        for(Character key : hm.keySet()){//Loop chalaya har ek character ke liye jo hashmap me hai.
            if(hm.get(key)>hm.get(mfc)){//Jo bhi character ki frequency maximum hai, usko update kar diya
                mfc = key;
            }
        }
        System.out.println(mfc);
    }
}
