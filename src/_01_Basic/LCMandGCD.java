package _01_Basic;
import  java.util.Scanner;
public class LCMandGCD {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int on1 = n1;
        int on2 = n2;
        while(n1%n2 != 0){
            int rem = n1%n2;
            n1=n2;
            n2=rem;
        }
        int gcd= n2;
        int lcm= (on1*on2)/gcd;
        System.out.println("GCD of "+on1 + " and " +on2 +" is : "+gcd);
        System.out.println("LCM of "+on1 + " and " +on2 +" is : "+lcm);
    }
}
