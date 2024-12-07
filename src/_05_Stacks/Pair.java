package _05_Stacks;

public class Pair implements  Comparable<Pair>{
    int st;
    int et;
    Pair(int st,int et){
        this.st=st;
        this.et=et;
    }
    //this > other return +ve
    //this = other return 0
    //this <other return -ve
    public  int compareTo(Pair other){
        if(this.st!=other.st){
            return this.st- other.st;
        } else{
            return this.et-other.et;
        }
    }
}
