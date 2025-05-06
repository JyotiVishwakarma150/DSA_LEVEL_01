package _14_DynamicProgramming;
import java.util.*;
public class _14_CountEncodings {
        public static void main(String[] args) throws Exception {
            Scanner scn = new Scanner(System.in);
            String str = scn.next();

            int[] dp = new int[str.length()];//DP array banaya with length equal to input string
            dp[0] = 1;// dp[0] = 1 ka matlab: Agar string ka first character valid hai (!= '0'), toh ek encoding possible hai
//Yeh loop 1 se start ho raha hai because hum pehle character ke pehle waala (i-1) access kar rahe hain
            for (int i = 1; i < dp.length; i++) {
                // Dono current aur previous character '0' hain — koi encoding nahi banegi → 0 ways
                if (str.charAt(i) == '0' && str.charAt(i - 1) == '0') {
                    dp[i] = 0;
                }
                // Previous '0' tha, lekin current valid hai → sirf current ko consider kar ke same as previous dp[i - 1].
                else if (str.charAt(i) != '0' && str.charAt(i - 1) == '0') {
                    dp[i] = dp[i - 1];
                }
                // Agar current '0' hai, toh check karo previous 1 ya 2 hai?
                else if (str.charAt(i) == '0' && str.charAt(i - 1) != '0') {
                    //Agar haan: "10" ya "20" valid hai → jump 2 chars back
                    if (str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 1);
                    } else {
                        dp[i] = 0;//Nahi: invalid → dp[i] = 0
                    }
                } else {//Jab dono characters valid hain, toh check karte hain
                    //"str.substring(i - 1, i + 1)" → ye 2 character ka number banata hai
                    if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {//Agar <= 26, toh:
                        //dp[i - 1] → current single char se
                        //dp[i - 2] → last 2 chars ko combine karke
                        dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                    } else {
                        dp[i] = dp[i - 1];//Else sirf dp[i - 1] lo.
                    }
                }
            }

            System.out.println(dp[str.length() - 1]);
        }
    }
