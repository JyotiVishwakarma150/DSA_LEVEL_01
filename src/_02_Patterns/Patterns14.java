package _02_Patterns;
import java.util.Scanner;
public class Patterns14 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int prod = 1;
        for(int i=1;i<=10;i++) {
                prod = n * i;
                System.out.println(n + "*" + i + "=" + prod);
            }
        }
}
