package _12_HashmapsAndHeap;
import java.io.*;
import java.util.*;
public class _11_WritePriorityQueueUsingHeap {
    public static class PriorityQueue {
        ArrayList<Integer> data;

        public PriorityQueue() {//Jab queue create hoti hai, to empty ArrayList ban jati hai.
            data = new ArrayList<>();
        }

        public void add(int val) {
            // write your code here
            data.add(val);//Value ko list ke end mein daal diya.
            upheapify(data.size()-1);//Fir upheapify call kiya, jisse value ko correct position pe laaya ja sake heap ke rules ke according
        }
        private void upheapify(int i){
            if(i==0){
                return;
            }
            int pi=(i-1)/2;//Har child ka parent i-1/2 hota hai.
            if(data.get(i)<data.get(pi)){//Agar child < parent, to swap kar do.
                swap(i,pi);
                upheapify(pi);//Yeh recursively hota hai jab tak root node ya correct position nahi mil jata.
            }
        }
        private void swap(int i,int j){
            int ith = data.get(i);
            int jth = data.get(j);
            data.set(i,jth);
            data.set(j,ith);
        }

        public int remove() {
            // write your code here
            if(this.size()==0){
                System.out.println("Underflow");
                return -1;
            }
            swap(0,data.size()-1);//Root (minimum element) ko last element ke saath swap kar diya
            int val=data.remove(data.size()-1);//Ab last element (jo actual root tha) ko remove kar diya.
            downheapify(0);//Ab jo element root pe aaya hai (last se utha ke), usko sahi position pe bhejna padega
            return val;
        }
        private void downheapify(int pi){
            int mini = pi; // assume current is smallest
            int li = 2*pi+1;// left child index
            if(li<data.size()&&data.get(li)<data.get(mini)){
                mini=li;
            }
            int ri=2*pi+2; // right child index
            if(ri<data.size()&&data.get(ri)<data.get(mini)){
                mini=ri;
            }
            if(mini != pi){
                swap(pi,mini);//Agar koi child parent se chhota hai to uske saath swap karo
                downheapify(mini);//Fir jis child se swap kiya, uske liye bhi downheapify() call karo (recursion)
            }
        }

        public int peek() {
            // write your code here
            if(this.size()==0){
                System.out.println("Underflow");
                return -1;
            }
            return data.get(0);
        }

        public int size() {
            // write your code here
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();

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
