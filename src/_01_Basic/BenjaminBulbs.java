package _01_Basic;
import java.util.Scanner;
public class BenjaminBulbs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter no of bulbs : ");
        int n=scn.nextInt();

        for(int i=1;i*i<=n;i++){
            System.out.println("open bulbs are : "+i*i);
        }
    }
}

