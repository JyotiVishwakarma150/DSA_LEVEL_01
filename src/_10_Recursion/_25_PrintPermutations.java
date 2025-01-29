package _10_Recursion;

import java.util.Scanner;

public class _25_PrintPermutations {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printPermutations(str,"");
    }

    public static void printPermutations(String ques, String asf) {
        if (ques.length() == 0) {
            System.out.println(asf); // asf = answer so far
            return;
        }
        //my logic part
//       for(int i=0;i<ques.length();i++){
//           char ch = ques.charAt(i);
//           String roq = ques.substring(i+1);
//       }
        for(int i=0;i<ques.length();i++){
            char ch = ques.charAt(i);
            String qlpart = ques.substring(0,i); // qlpart = question left part
            String qrpart =  ques.substring(i+1); // qrpart = question right part
            String roq = qlpart+qrpart; // roq = rest of the question
            printPermutations(roq,asf+ch);
        }
    }
}
