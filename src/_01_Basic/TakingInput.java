package _01_Basic;
import  java.util.Scanner;
public class TakingInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        String name = input.nextLine();
//        System.out.println("Hello "+ name);
        int n= input.nextInt();
        for(int i=0;i<=n;i++){
            System.out.println(i);
        }
    }
}
