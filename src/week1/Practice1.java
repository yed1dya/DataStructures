package week1;

import java.util.Arrays;

public class Practice1 {
    public static void main(String[] args) {
        String[] w = {"be", "be", "not", "or", "to", "to", "to"};
        String[] h = {"be", "be", "be", "be","be", "be"};
        String[] a = {"be", "add"};
        String[] b = {"the", "tell", "be", "be", "be", "", "not", "or", "to", "toes", "to", "aqua", "car", "digging"};
        String[] c = {"the", "tell", "be", "be", "be", "", "not", "or", "to", "toes", "to", "aqua", "car", "digging"};
        Q2(a);
        Q2(h);
        Q2(w);
        Q3(b);
        Q4(c);
        System.out.println(Arrays.toString(c));
        int[] arr = {1, 8, -1, 4, 6, 32, 92};
        Q5(arr);
        Q6(arr);
        int[] q7 = {1, 8, 23, 43, 1, 4, 6, 32, 92};
        Q7(q7);
        System.out.println(Arrays.toString(q7));
        int[] q72 = {1, 8, 23, 43, 1, 4, 6, 32, 92};
        MyRadixSortInts.countingSort(q72, 1);
        MyRadixSortInts.countingSort(q72, 10);
        System.out.println(Arrays.toString(q72));
        int[] q8 = {-10,-5,-3,-1,0,2, 3,4,7,9,12};
        System.out.println(Q8(q8));
        System.out.println(Q9(q8, 15));
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
        // set first word to compare:
        String t = words[0];
        int[] tempArr = new int[words.length];
        int count=1, place = 0;
        for(int i=1; i<words.length; i++){
            // if current word is the same as the previous one:
            if(words[i].equals(t)){
                count++;
            }
            else{
                // add count to array in current place, and advance place by 1
                tempArr[place++] = count;
                // reset count
                count = 1;
            }
            // set current word:
            t = words[i];
        }
        // add count of last word:
        tempArr[place] = count;
        // make and fill ans array:
        int[] ans = new int[place+1];
        for(int i=0; i<=place; i++){
            ans[i] = tempArr[i];
        }
        System.out.println(Arrays.toString(ans));
    }

    public static void Q3(String[] words){
        RadixSortStrings.radixSort(words);
    }

    public static void Q4(String[] words){
        RadixSortStrings.radixSort(words);
        Q2(words);
    }

    public static void Q5(int[] arr){
        /*
        radix sort
        int dist = distance between 1st and 2nd
        check distance for every pair
        if smaller, update
         */
        if(arr==null || arr.length<2) return;
        int length = arr.length;;
        MyRadixSortInts.radixSort(arr);
        int a = arr[0], b = arr[1];
        int distance = Math.abs(a-b);
        for(int i=1; i<length; i++){
            if(Math.abs(arr[i]-arr[i-1])<distance){
                distance = Math.abs(arr[i]-arr[i-1]);
                a = arr[i];
                b = arr[i-1];
            }
        }
        System.out.println("a: " +a+", b: "+b);
    }

    public static void Q6(int[] arr){
        // same as Q5 but check if bigger
        if(arr==null || arr.length<2) return;
        int length = arr.length;;
        MyRadixSortInts.radixSort(arr);
        int a = arr[0], b = arr[1];
        int distance = Math.abs(a-b);
        for(int i=1; i<length; i++){
            if(Math.abs(arr[i]-arr[i-1])>distance){
                distance = Math.abs(arr[i]-arr[i-1]);
                a = arr[i];
                b = arr[i-1];
            }
        }
        System.out.println("a: " +a+", b: "+b);
    }

    public static void Q7(int[] arr){
        // radix sort twice:
        if(arr==null || arr.length<2) return;
        int length = arr.length;
        // counting sort by 1ns digit
        int[] indexArr = new int[10];
        int[] tempArr = new int[length];
        // iterate over arr, set indexArr by last digit of each number
        for(int number : arr){
            int index = number % 10;
            indexArr[index]++;
        }
        // make into addition series:
        for(int i=1; i<10; i++){
            indexArr[i] += indexArr[i-1];
        }
        // go backwards over arr, get the index - the smallest digit.
        // get the position - the value in indexArr at index place
        // put number in position
        // update number in indexArr
        for(int i=length-1; i>=0; i--){
            int number = arr[i];
            int index = number % 10;
            int position = indexArr[index]-1;
            indexArr[index]--;
            tempArr[position] = number;
        }
        // finished first sort. reset indexArr and do counting sort on tempArray by 10s digit
        indexArr = new int[10];
        for(int number : tempArr){
            int index = (number/10) % 10;
            indexArr[index]++;
        }
        for(int i=1; i<10; i++){
            indexArr[i] += indexArr[i-1];
        }
        // put numbers from tempArray back into arr:
        for(int i=length-1; i>=0; i--){
            int number = tempArr[i];
            int index = (number/10) % 10;
            int position = indexArr[index]-1;
            indexArr[index]--;
            arr[position] = number;
        }
    }

    public static boolean Q8(int[] arr){
        return Q9(arr, 0);
    }

    public static boolean Q9(int[] arr, int k){
        if(arr==null || arr.length<2) return false;
        // use 2-pointer approach:
        // look at first and last positions
        // if their sum is k, return.
        // else, if their sum is greater than k, we need to be smaller. so make right pointer smaller
        // if their sum is less than k, we need to be bigger, so make left pointer bigger.
        // continue while left<right. when left==right, they're both on the same index. so there is no possible pair.
        int left = 0, right = arr.length-1, sum;
        while(left<right){
            sum = arr[left]+arr[right];
            if(sum<k){
                left++;
            }
            else if(sum>k){
                right--;
            }
            else {
                System.out.println("true: " +arr[left]+", "+arr[right]);
                return true;
            }
        }
        return false;
    }

}
