package _06_OOPs;

public class _01_OOPsBasic {
    public  static class Person{
        int age;
        String name;
        void saysHi(){
            System.out.println(name + "[" +age+"] says hii");
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age=10;
        p1.name="A";
        p1.saysHi();

        Person p2 = new Person();
        p2.age=20;
        p2.name="B";
        p2.saysHi();

        Person p3 = new Person();
        p3.age=30;
        p3.name="A";
        p3.saysHi();
        p1.saysHi();

    }
}
