package _15_Strings;

public class _03_StringBuilderDemo {
    public static void main(String[] args) {
//        // Demonstration of StringBuilder methods
//        StringBuilder sb = new StringBuilder("hello");
//        System.out.println(sb); // hello
//
//        // Access character at index
//        char ch = sb.charAt(0); // h
//        System.out.println(ch); // h
//
//        // Insert character at index 2
//        sb.insert(2, 'y'); // heyllo
//        System.out.println(sb); // heyllo
//
//        // Delete character at index 2
//        sb.deleteCharAt(2); // hello
//        System.out.println(sb); // hello
//
//        // Append a character
//        sb.append('g'); // hellog
//        System.out.println(sb); // hellog
//
//        // Length of StringBuilder
//        System.out.println(sb.length()); // 6
//
//        // Set character at index 0
//        sb.setCharAt(0, 'd'); // dello
//        System.out.println(sb); // dellog
//
//        // Insert string at index 2
//        sb.insert(2, "y"); // deyllog
//        System.out.println(sb); // deyllog

        // Performance test using String... slowly work krega aur n square loop chlega aur 10000 pr me
        int n = 100000;
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < n; i++) {
            s += i;
        }
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println("Time with String: " + duration);

        // Performance test using StringBuilder
        n = 100000;
        start = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb2.append(i);
        }
        end = System.currentTimeMillis();
        duration = end - start;
        System.out.println("Time with StringBuilder: " + duration);
    }
}
