package _14_DynamicProgramming;
import java.io.*;
import java.util.*;

public class _17_PaintFence {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // number of fences
        int k = scn.nextInt(); // number of colors
        //phli do frnce ko same rkhne ke tareeka = k*1
        long same = k * 1;//phli wali ko k mein print krdiya ,dusri par wahi color repeat krdiya
        //phli do ko different rkhne ka way hai k*(k-1)
        long diff = k * (k - 1);//phli wali pr k options ,dusri wali pr usk0 chhorkr baaki k-1 options
        long total = same + diff;

        for (int i = 3; i <= n; i++) {// i=3 isiliye kuki n=1 aur n=2 ke liye hum already values calculate kr chuke hain
            same = diff * 1;
            diff = total * (k - 1);
            total = same + diff;
        }

        System.out.println(total);
    }

}
