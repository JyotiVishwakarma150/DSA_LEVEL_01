package _06_OOPs;
public class _04_SwapGame3 {
    public static class Person {
        int age;
        String name;

        void saysHi() {
            System.out.println(name + "[" + age + "] says hii");
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age = 10;
        p1.name = "A";

        Person p2 = new Person();
        p2.age = 20;
        p2.name = "B";

        p1.saysHi();
        p2.saysHi();
        swap(p1,p2);
        p1.saysHi();
        p2.saysHi();
    }
    public static void swap(Person psn1, Person psn2){
        psn1 = new Person();
        int age = psn1.age;
        psn1.age = psn2.age;
        psn2.age=age;

        psn2 = new Person();
        String name = psn1.name;
        psn1.name=psn2.name;
        psn2.name=name;
    }
}