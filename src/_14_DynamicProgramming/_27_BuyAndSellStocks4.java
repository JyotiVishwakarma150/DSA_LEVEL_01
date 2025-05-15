package _14_DynamicProgramming;
import java.util.*;
public class _27_BuyAndSellStocks4 { //BuyAndSellStocks4 with cooldown infinite transaction allowed
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scn.nextInt();
            }

            int obsp = -arr[0];// (Old Buy State Profit)..Phle din pe agr kharida, toh profit negative hoga -arr[0]
            int ossp = 0;//(Old Sell State Profit)..Initially 0 kyuki kuch sell kiya nahi h
            int ocsp = 0;// (Old Cooldown State Profit)...Initially 0, kyuki abhi kuch bhi sell nahi kiya h

            for (int i = 1; i < arr.length; i++) {
                //naye din ke new buy state, new sell state, new cooldown state
                int nbsp = 0;
                int nssp = 0;
                int ncsp = 0;

                if (ocsp - arr[i] > obsp) {//hum cooldown state se naye buy kar rahe ho toh ocsp - arr[i]
                    nbsp = ocsp - arr[i];
                } else {//Nahi toh jo phle se buy state tha usi ko consider krlege
                    nbsp = obsp;
                }

                if (obsp + arr[i] > ossp) {//pichli buy ke upr aajj sell krdiya..agr wo better hai to nssp mein obsp + arr[i] bhr dge
                    nssp = obsp + arr[i];
                } else {//nhi better hai to purani ossp ko hi consider krege
                    nssp = ossp;
                }
                //Purana cooldown aur ossp (sell ke baad ka profit) me best select kar rhe h
                if(ossp>ocsp){//agr ossp > ocsp hai toh ossp ko cooldown maan lgee
                    ncsp=ossp;
                }else {
                    ncsp = ocsp;//Nahi toh ocsp ko hi lege
                }
                //values ko update krdiya humne
                obsp = nbsp;
                ossp = nssp;
                ocsp = ncsp;
            }

            System.out.println(ossp);
        }
    }

