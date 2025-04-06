package _12_HashmapsAndHeap;
import java.io.*;
import java.util.*;
public class _09_MedianPriorityQueue {
    public static class MedianPriorityQueue {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianPriorityQueue() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int val) {
            // write your code here

            if(right.size()>0 && val>right.peek()){//right mein phle se element pda hai aur hum uske peek se bde hai to add krke balancing manage krna hai
                right.add(val);
            }else{ // generally left mein add krege
                left.add(val);
            }
            //agr size mein 2 ka gap aaya hai to usko left aur right ke according balance krke manage krege
            if(left.size()-right.size() == 2){
                right.add(left.remove());
            }else if(right.size()-left.size()==2){
                left.add(right.remove());
            }
        }

        public int remove() {
            // write your code here ...same approach as peek()
            if(this.size()==0){
                System.out.println("underflow");
                return -1;
            }else if(left.size()>=right.size()){
                return left.remove();
            }else{
                return right.remove();
            }
        }

        public int peek() {
          //left aur right mein jiska size jade ho uski top dedege agr size equal hai to left mein se de dege
            if(this.size()==0){
                System.out.println("underflow");
                return -1;
            }else if(left.size()>=right.size()){
                return left.peek();
            }else{
                return right.peek();
            }
        }

        public int size() {
            // write your code here
            return left.size()+right.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MedianPriorityQueue qu = new MedianPriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}
