package _15_Strings;

import java.util.Scanner;
import java.util.*;
import java.io.*;
public class _01_StringIntro {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
//        String s1 = "Hello";
//        System.out.println(s1);
//        String s1 = scn.next();
//        String s1 = scn.nextLine();
//        System.out.println(s1);
//        String s =scn.nextLine();
//        System.out.println(s);
//        System.out.println(s.length());

//        String s = "abcd";
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 1; j <= s.length(); j++) {
//                System.out.println(s.substring(i, j));
//
//            }
//        }
        //String s1 = "hello";
//        s1+=' ';
//        s1+='w';
//        s1+=10;
//        System.out.println(s1);
//        String s2 = "World";
//        String s3 = s1 + " " +s2;
//        System.out.println(s3);
       // System.out.println(10+20+"hello");
        String s = "abc,def,ghi,jkl mno";
        String[] parts = s.split(",");
        for(int i=0;i<parts.length;i++){
            System.out.println(parts[i]);
        }
    }
}
