package week2;

import week1.MyRadixSortInts;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static java.util.Arrays.sort;

public class T4_SortMergeAndSearch {
    public static void main(String[] args) {
        int[] a={1,8,15}, b ={3,4, 10,11}, c={5, 7,9},
                d = {1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 15},
                e = {1, 2, 2, 3, 4, 5, 7, 8, 9, 10, 11, 15},
                f = {1,1,3,4,5},
                g = {1,2,3,4,5,6,7,8,10,10,11,12,13,13,15,20};
//        System.out.println(Arrays.toString(Q1(a, b, c)));
//        System.out.println(Arrays.toString(Q1opt(a, b, c)));
        System.out.println(Q2(d));
        System.out.println(Q2(e));
        System.out.println(Q2(f));
        System.out.println(Q2(g));
//        System.out.println(Q4(d, 2));
//        System.out.println(Q4(d, 9));
//        System.out.println(Q4(d, 19));
//        System.out.println(Arrays.toString(Q5(d, f)));
//        Point[] points = {new Point(0,5), new Point(5,0),
//                new Point(-5,0), new Point(0,-5),
//                new Point(4,-3), new Point(3,-4),
//                new Point(-4,3), new Point(-4,-3),
//                new Point(3,4)};
//        Q3(points);
    }
    public static int[] Q5(int[] a, int[] b){
        // radix sort - O(n)
        MyRadixSortInts.radixSort(b);
        ArrayList<Integer> ans = new ArrayList<>();
        // iterate - O(n)
        for(int i : a){
            // contains - O(log n)
            if(contains(b, i)) ans.add(i);
        }
        // O(n)
        return toArray(ans);
    }
    public static int[] toArray(ArrayList<Integer> arr){
        int[] ans = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            ans[i] = arr.get(i);
        }
        return ans;
    }
    public static boolean contains(int[] arr, int s){
        if(arr==null || arr.length==0) return false;
        int start = 0, end = arr.length-1;
        while (start<=end){
            int mid = (start+end)/2;
            int t = arr[mid];
            if(s==t) return true;
            if(s<t) end = mid-1;
            if(s>t) start = mid+1;
        }
        return false;
    }
    public static boolean Q4(int[] a, int k){
        int start = 0, end = a.length-1;
        while(start<end){
            int t = a[start]+a[end];
            if(t==k) return true;
            if(k<t) end--;
            if(k>t) start++;
        }
        return false;
    }
    // TODO Q3
    public static boolean Q3(Point[] points){
        Comparator<Point> c = (p1, p2) -> {
            // 1: p1 comes first
            double x1=p1.x, y1=p1.y, x2=p2.x, y2=p2.y;
            if(x1==x2 && y1==y2) return 0;
            if(y1<=0 && y2<=0){
                if(x1<x2) return -1;
                if(x1>x2) return 1;
            }
            if(y1>0 && y2>0){
                if(x1<x2) return -1;
                if(x1>x2) return 1;
            }
            if(y1>=0 && y2<=0){
                if(x1>0) return 1;
                if(x1<0) return -1;
            }
            if(y1<=0 && y2>=0){
                if(x2>0) return -1;
                if(x2<0) return 1;
            }
            return 0;
        };
        sort(points, c.reversed());
        System.out.println(Arrays.toString(points));
        return false;
    }
    public static boolean Q2(int[] a){
        if(a==null) return false;
        int mid = (a.length-1)/2;
        while(mid<a.length-1){
            if(a[mid]<=mid){
                System.out.println(mid);
                return true;
            }
            mid = (a.length+mid)/2;
        }
        return false;
    }
    public static int[] Q1(int[] a, int[] b, int[] c){
        int aLen=0, bLen=0, cLen=0;
        if(a!=null) aLen = a.length;
        if(b!=null) bLen = b.length;
        if(c!=null) cLen = c.length;
        int l = aLen+bLen+cLen;
        int[] ans = new int[l];
        int i=0, j=0, k=0, p=0;
        while (p<l){
            if(i<aLen && j<bLen && k<cLen){
                if(a[i]<=b[j]){
                    if(a[i]<=c[k]){
                        ans[p++] = a[i++];
                    }
                    else{
                        ans[p++] = c[k++];
                    }
                }
                else{
                    if(b[j]<=c[k]){
                        ans[p++] = b[j++];
                    }
                    else{
                        ans[p++] = c[k++];
                    }
                }
            }
            else if(i<aLen && j<bLen){
                if(a[i]<=b[j]){
                    ans[p++] = a[i++];
                }
                else{
                    ans[p++] = b[j++];
                }
            }
            else if(i<aLen && k<cLen){
                if(a[i]<=c[k]){
                    ans[p++] = a[i++];
                }
                else{
                    ans[p++] = c[k++];
                }
            }
            else if(j<bLen && k<cLen){
                if(b[j]<=b[j]){
                    ans[p++] = b[j++];
                }
                else{
                    ans[p++] = c[k++];
                }
            }
            else if(i<aLen){
                ans[p++] = a[i++];
            }
            else if(j<bLen){
                ans[p++] = b[j++];
            }
            else if(k<cLen){
                ans[p++] = c[k++];
            }
        }
        return ans;
    }
    public static int[] Q1opt(int[] a, int[] b, int[] c){
        int aLen=0, bLen=0, cLen=0;
        if(a!=null) aLen = a.length;
        if(b!=null) bLen = b.length;
        if(c!=null) cLen = c.length;
        int l = aLen+bLen+cLen;
        int[] ans = new int[l];
        int i=0, j=0, k=0, p=0;
        while (p<l){
            if(i<aLen && j<bLen && k<cLen){
                if(a[i]<=b[j]){
                    if(a[i]<=c[k]) ans[p++] = a[i++];
                    else ans[p++] = c[k++];
                }
                else{
                    if(b[j]<=c[k]) ans[p++] = b[j++];
                    else ans[p++] = c[k++];
                }
            }
            else if(i<aLen && j<bLen){
                if(a[i]<=b[j]) ans[p++] = a[i++];
                else ans[p++] = b[j++];
            }
            else if(i<aLen && k<cLen){
                if(a[i]<=c[k]) ans[p++] = a[i++];
                else ans[p++] = c[k++];
            }
            else if(j<bLen && k<cLen){
                if(b[j]<=b[j]) ans[p++] = b[j++];
                else ans[p++] = c[k++];
            }
            else if(i<aLen) ans[p++] = a[i++];
            else if(j<bLen) ans[p++] = b[j++];
            else if(k<cLen) ans[p++] = c[k++];
        }
        return ans;
    }
}
