package _01_Basic;
import  java.util.Scanner;
public class Prime0 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t= scn.nextInt();
        for(int i=0;i<t;i++){
            int n= scn.nextInt();
            int count =0;
            for(int div =1;div<=n;div++){
                if(n%div==0){
                    count++;
                }
            }
            if(count==2){
                System.out.println("prime");
            }else{
                System.out.println("not prime");
            }
        }
    }
}