package _15_Strings;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class _08_ArraylistDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();//declaration of Arraylist
        System.out.println(list +" -> "+list.size());
        //add
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list +" -> "+list.size());
        list.add(1,1000);
        System.out.println(list +" -> "+list.size());
        int val = list.get(1);
        System.out.println(val);
        list.remove(1);
        System.out.println(list +" -> "+list.size());
        //Arraylist of string
        ArrayList<String> l2 = new ArrayList<>();
        l2.add("Hello");
        l2.add("Bello");
        l2.add("Cello");
        System.out.println(l2 +" -> "+l2.size());
        //loop working
        for(int i=0;i<list.size();i++){
            int val1 = list.get(i);
            System.out.println(val1);
        }
        //for each
        for(int val1:list){
            System.out.println(val1);
        }
        //if we only want to print content of the arraylist
        System.out.println(list);
    }
}
