package _10_Recursion;

import java.util.Locale;
import java.util.Scanner;

public class _22_PrintKPC {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printKPC(str, "");
    }

    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

//    public static void printKPC(String str, String asf) {
//        if (str.length() == 0) {
//            System.out.println(asf);
//            return;
//        }
//        char ch = str.charAt(0);
//        String ros = str.substring(1);
//       printKPC(ros,asf+code[ch-'0']);
    //   printKPC(ros,asf+"");

 // }
    public static void printKPC(String ques,String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String roq =  ques.substring(1);
        String codeforch = codes[ch-'0'];
        for(int i=0;i<codeforch.length();i++){
            char cho= codeforch.charAt(i);
            printKPC(roq,ans+cho);
        }
    }
}
