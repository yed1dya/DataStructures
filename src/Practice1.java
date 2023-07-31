import java.util.ArrayList;
import java.util.Arrays;

public class Practice1 {
    public static void main(String[] args) {
        String[] w = {"be", "be", "not", "or", "to", "to", "to"};
        String[] h = {"be", "be", "be", "be","be", "be"};
        String[] a = {"be", "add"};
        Q2(a);
        Q2(h);
        Q2(w);
        int[] arr = {1, 8, 3, 6, 2, 9};
        //System.out.println(gcd2(136, 42));
        //fun(10000);
    }

    public static long gcd2(long x, long y) {
        while (x != y) {
            System.out.print("gcd(" + x + "," + y + ")=");
            if(x > y) {x=x-y;}
            else {y=y-x;}
        }
        return y;
    }

    public static double nth(int n, double[] arr){
        for(int i=0; i< arr.length; i++){
            int count=0;
            double x=arr[i];
            for(int j=i; j< arr.length; j++){
                if(arr[j]>x) count++;
            }
            if(count==n) return x;
        }
        /*
        consider 1st
        compare to rest
        count how many bigger
        if equal to n, return
        else, consider next.
        complexity: O(n^2)
         */
        return 0;
    }

    public static void Q2(String[] words){
        if(words==null || words.length==0){ System.out.println("[0]"); return; }
        if(words.length==1){ System.out.println("[1]"); return; }
        String t = words[0];
        int[] tempArr = new int[words.length];
        int count=1, place = 0;
        for(int i=1; i<words.length; i++){
            if(words[i].equals(t)) count++;
            else{
                tempArr[place] = count;
                count = 1;
                place++;
            }
            t = words[i];
        }
        tempArr[place] = count;
        int[] ans = new int[place+1];
        for(int i=0; i<=place; i++){
            ans[i] = tempArr[i];
        }
        System.out.println(Arrays.toString(ans));
    }

    public static void Q3(String[] words){
        /*
        find the longest word
        sort by first letter
        ...
        sort by last letter
         */
    }

    public static void Q4(String[] words){

    }

}
