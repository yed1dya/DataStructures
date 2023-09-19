package week5;

import sandbox.AVL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Questions1 {
    public static void main(String[] args) {
        System.out.println(Q1_2(new String[]{"be", "be", "not", "or", "to", "to", "to"}));
        System.out.println(Q1_3(new int[]{1, 4, 9, 17, 23, -1, 14}));
        System.out.println(Q1_4(new int[]{1, 4, 9, 17, 23, -1, 14}));
        int[] a = new int[]{1, 4, 9, 17, 23, 0, 14};
        Q1_5(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Q1_6(new int[]{-11, -4, 0, 1, 2, 5, 14}));
    }
    // return kth element without sorting: O(n log n)
    public static int Q1_1(int[] a, int k){
        AVL<Integer> tree = new AVL<>();
        HashSet<Integer> set = new HashSet<>();
        for(int num : a){
            if(!set.contains(num)) {
                set.add(num);
                if (tree.size() <= k) {
                    tree.insert(num);
                } else {
                    int min = tree.min();
                    if (num > min) {
                        tree.remove(min);
                        tree.insert(num);
                    }
                }
            }
        }
        return tree.max();
    }

    // return word frequency
    public static ArrayList<Integer> Q1_2(String[] s){
        ArrayList<Integer> ans = new ArrayList<>();
        if(s==null || s.length==0) return ans;
        int c = 1;
        for(int i=0; i<s.length-1; i++){
            if(s[i].equals(s[i+1])) c++;
            else{
                ans.add(c);
                c = 1;
            }
        }
        ans.add(c);
        return ans;
    }

    // return two closest numbers
    public static String Q1_3(int[] a){
        if(a==null || a.length<2) return "too short";
        if(a.length==2) return a[0]+", "+a[1];
        Arrays.sort(a);
        int dif = a[1]-a[0], a1=a[0], a2=a[1];
        for(int i=0; i<a.length-1; i++){
            int newDif = a[i+1]-a[i];
            if(newDif<dif){
                a1=a[i+1];
                a2=a[i];
                dif = newDif;
            }
        }
        return a1+", "+a2;
    }

    // return farthest elements
    public static String Q1_4(int[] a){
        if(a==null || a.length<2) return "too short";
        Arrays.sort(a);
        return a[0]+", "+a[a.length-1];
    }

    // bounded sort 0-99
    public static void Q1_5(int[] a){
        int[] count = new int[100];
        for(int n : a) count[n]++;
        int index = 0;
        for(int i=0; i<100; i++){
            while (count[i]-->0) a[index++] = i;
        }
    }
    
    // 2 nums sum 0:
    public static boolean Q1_6(int[] a){
        if(a==null || a.length<2) return false;
        int small=0, big=a.length-1;
        while (small<big && a[small]<=0 && a[big]>=0){
            int n = a[small]+a[big];
            if(n==0) return true;
            if(n<0) small++;
            if(n>0) big--;
        }
        return false;
    }
}
