package _01_Basic;

public class Bodmas {
    public static void main(String[] args) {
        int x = 15;
        int y=10;
        int sum=x+y;
        System.out.println("sum of "+ x + " and "+y+" is "+sum);
        //xy
        int prd = x*y;
        System.out.println("Product of "+x+" and "+y+" is "+prd);
        // x/y, y/x , x%y
        int v1 = x/y;
        int v2 = y/x;
        int v3 = x%y;
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        //exp
        int exp = (x*y)/(x+y);
        System.out.println(exp);
    }
}
