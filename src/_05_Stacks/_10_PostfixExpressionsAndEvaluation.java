package _05_Stacks;
import java.io.*;
import java.util.Stack;

public class _10_PostfixExpressionsAndEvaluation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack<Integer> vs = new Stack<>();
        Stack<String> is = new Stack<>();
        Stack<String> ps = new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                int v2 = vs.pop();
                int v1= vs.pop();
                int val = operation(v1,v2,ch);
                vs.push(val);

                String iv2 = is.pop();
                String iv1 = is.pop();
                String ival ="(" + iv1+ ch+iv2+")";
                is.push(ival);

                String pv2 = ps.pop();
                String pv1=ps.pop();
                String pval = ch+pv1+pv2;
                ps.push(pval);
            } else{
                vs.push(ch-'0');
                is.push(ch +"");
                ps.push(ch +"");
            }
        }
        System.out.println("Evaluation : "+vs.pop());
        System.out.println("infix conversion : "+is.pop());
        System.out.println("prefix conversion : "+ps.pop());
    }
    public static  int operation(int v1 ,int v2,char op){
        if(op=='+'){
            return v1+v2;
        } else if(op=='-'){
            return v1-v2;
        } else if(op=='*'){
            return v1*v2;
        } else{
            return v1/v2;
        }
    }
}