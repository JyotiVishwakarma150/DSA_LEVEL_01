package _02_Patterns;
import java.util.Scanner;
public class Patterns11 {
    public static void main(String[] args) {
      /*1
        2 3
        4 5 6
        7 8 9 10*/

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int val=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(val + "\t");
                val++;
            }
            System.out.println();
        }
    }
}
