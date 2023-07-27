public class Practice1 {
    public static void main(String[] args) {
        String[] w = {"be", "be", "not", "or", "to", "to", "to"};
        Q2(w);
        int[] arr = {1, 8, 3, 6, 2, 9};
        System.out.println(gcd2(136, 42));
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
        if(words.length==0) return;
        if(words.length==1) System.out.println("1");;
        String t = words[0];
        String ans = "";
        int count=1;
        for(int i=1; i<words.length; i++){
            if(words[i].equals(t)) count++;
            else{
                ans += count + " ";
                count = 1;
            }
            t = words[i];
        }
        ans += count;
        System.out.println(ans);
    }

    public static void Q3(String[] words){
        /*
        find longest word
        sort by first letter
        ...
        sort by last letter
         */
    }
}
