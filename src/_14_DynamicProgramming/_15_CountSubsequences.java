package _14_DynamicProgramming;

import java.util.Scanner;

public class _15_CountSubsequences { //count a+b+c+ subsequences
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        //starting mein jab kuch hai nhi apne pass to subsequence bhi koi nhi h aone pass
        int a=0;//a in tha sense a+
        int ab=0;//ab in the sense a+b+
        int abc=0;//abc in the sense a+b+c+
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='a'){
                a=2*a+1; //a ko double kro aur ek aur add krdege mtkb khud ko abhi add krega kuki khud bhi to ek subsequence start krega n
            }else if(ch=='b'){
                ab=2*ab+a;// ab ko double krdege aur usme a wale sare add krdo
            }else if(ch=='c'){
                abc=2*abc+ab;//abc ko double krdege aur usme ab add krdege
            }
        }
        System.out.println(abc);
    }

}
