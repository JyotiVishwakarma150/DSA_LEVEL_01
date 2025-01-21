package _10_Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class _20_PrintSubsequence {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
       printSS(str,"");
    }

    public static void printSS(String ques, String ans) {
     if(ques.length()==0){
    System.out.println(ans);
    return;
}
     char ch = ques.charAt(0);
     String roq = ques.substring(1);//rest of the question
     printSS(roq,ans+ch);
     printSS(roq,ans + "");
    }

}
