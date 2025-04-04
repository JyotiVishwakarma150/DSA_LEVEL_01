package _12_HashmapsAndHeap;

import java.util.HashMap;
import java.util.*;
public class _01_HashmapIntro {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India",135);
        hm.put("China",200);
        hm.put("Pak",30);
        hm.put("US",20);
        hm.put("UK",10);
        System.out.println(hm);
        hm.put("Nigeria",5);
        hm.put("US",25);
        System.out.println(hm);
        System.out.println(hm.get("India"));
        System.out.println(hm.get("Utopia"));
        System.out.println(hm.containsKey("India"));
        Set<String> keys = hm.keySet();
        System.out.println(keys);
        for(String key : hm.keySet()){
            Integer val = hm.get(key);
            System.out.println(key + " " + val);
        }
    }
}
