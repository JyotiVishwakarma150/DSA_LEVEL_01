package _06_OOPs;

public class _05_ConstructorAndThis {
    public static class Person {
        int age;
        String name;

        void saysHi() {
            System.out.println(name + "[" + age + "] says hii");
        }
// if we forget ,java provides our class a default constructor
        Person(){
            //constructor
        }
        Person(int age,String name){
            this.age=age;
            this.name=name;
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age=10;
        p1.name="A";
        p1.saysHi();

        Person p2 = new Person(20,"B");
        p2.saysHi();

    }
}
