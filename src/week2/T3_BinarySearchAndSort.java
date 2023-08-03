package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class T3_BinarySearchAndSort {
    public static void main(String[] args) {
        int[] arr = {-23, -11, -4, 1, 2, 3, 4, 6, 7, 12, 14, 54, 324, 3333, 4312};
        int[] arr2 = {-23, -11, -4, 1, 1, 1, 1, 1, 1, 1, 12, 54, 324, 3333, 4312};
        int[] arr3 = {-23, -11, -4, 1, 1, 1, 1, 1, 1, 1, 1, 12, 324, 3333, 4312};
        System.out.println(binarySearch(arr, 6));
        String[] a = {"green", "hello", "me", "try"};
        String[] b = {"green", "me", "System"};
        String[] c = {"also", "boaz","green", "me"};
        System.out.println(Arrays.toString(same(a, b, c)));
        System.out.println(Q4(arr));
        game();
        Q5(arr);
        Q5(arr2);
        Q5(arr3);
    }
    public static void Q5(int[] arr){
        if(arr==null||arr.length==0) return;
        if(arr.length==1){
            System.out.println(arr[0]);
            return;
        }
        int start=0, end=arr.length/2;
        while(end<arr.length-1){
            if (arr[start]==arr[end]){
                System.out.println(arr[start]);
                return;
            }
            start++;
            end++;
        }
        System.out.println("not found");
    }
    public static boolean Q4(int[] arr){
        if(arr==null) return false;
        int start=0, end=arr.length-1;
        while (start<=end){
            int sum = arr[start]+arr[end];
            if (sum==0){
                System.out.printf("[%d,%d]%n", start, end);
                return true;
            }
            if(sum>0) end--;
            if(sum<0) start++;
        }
        return false;
    }
    public static int binarySearch(int[] arr, int value){
        if(arr==null||arr.length==0) return -1;
        int len = arr.length;
        int start = 0, end = len-1;
        while (start<=end){
            int mid = (end+start)/2;
            int temp = arr[mid];
            if(value==temp) return mid;
            if(value<temp) end = mid-1;
            if(value>temp) start = mid+1;
        }
        return -1;
    }

    public static void game(){
        System.out.println("think of a number");
        Scanner in = new Scanner(System.in);
        int start = 0, end = 1000, mid = 500, count = 0;
        boolean quit = false;
        while(start<=end){
            mid = (start+end)/2;
            System.out.println("count: "+count++ + "\nis " + mid + " your number?\n1- smaller, 2- yes, 3- bigger");
            String input = in.next();
            if(input.equals("q")){
                quit=true;
                System.out.println("bye!");
                break;
            }
            while (!(input.equals("1")||input.equals("2")||input.equals("3"))){
                System.out.println("enter only 1-3");
                input = in.next();
            }
            int num = Integer.parseInt(input);
            if(num==2) break;
            if(num==1) end=mid-1;
            else start=mid+1;
        }
        if(!quit) {
            System.out.println("your number is " + mid + ".\ntook " + count + " guesses");
        }
    }

    public static String[] same(String[] a, String[] b, String[] c){
        ArrayList<String> ans = new ArrayList<>();
        int aSize = a.length, bSize = b.length, cSize = c.length;
        if(aSize==0 || bSize==0 || cSize==0) return toArray(ans);
        for(String s : a){
            if(contains(b, s) && contains(c, s)){
                ans.add(s);
            }
        }
        return toArray(ans);
    }

    public static boolean contains(String[] arr, String s){
        if(arr==null || arr.length==0) return false;
        int start = 0, end = arr.length-1;
        while (start<=end){
            int mid = (start+end)/2;
            String t = arr[mid];
            if(s.equals(t)) return true;
            int comp = s.compareTo(t);
            if(comp<0){
                end = mid-1;
            }
            if(comp>0){
                start = mid+1;
            }
        }
        return false;
    }

    public static String[] toArray(ArrayList<String> arr){
        String[] ans = new String[arr.size()];
        for(int i=0; i<arr.size(); i++){
            ans[i] = arr.get(i);
        }
        return ans;
    }
}
