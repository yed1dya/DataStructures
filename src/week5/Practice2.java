package week5;

import week3.BST;
import week3.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class Practice2 {
    public static void main(String[] args) {

    }
    // sorted array to BST:
    public static BST Q1(int[] a){
        BST tree = new BST();
        if(a==null || a.length==0) return tree;
        tree.insert(Q1help(a, 0, a.length-1));
        return tree;
    }
    public static Node Q1help(int[] a, int start, int end){
        if(a==null || a.length==0 || start>end) return null;
        int mid = (end+start)/2;
        return new Node(a[mid], Q1help(a, start, mid-1), Q1help(a, mid+1, end));
    }

    // find max product is array:
    public static int Q2(int[] arr){
        if(arr==null || arr.length<2) return 0;
        if(arr.length==2) return arr[0]*arr[1];
        int smallest=0, secondSmallest=0, secondBiggest=0, biggest=0;
        for (int current : arr) {
            if (current <= smallest) {
                secondSmallest = smallest;
                smallest = current;
            } else if (current < secondSmallest) {
                secondSmallest = current;
            }
            if (current >= biggest) {
                secondBiggest = biggest;
                biggest = current;
            } else if (current > secondBiggest) {
                secondBiggest = current;
            }
        }
        return Math.max(smallest*secondSmallest, biggest*secondBiggest);
    }

    // return each word only once:
    public static ArrayList<String> Q4(String[] strings){
        HashMap<Integer, String> map = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();
        for (String s : strings){
            Integer place = s.hashCode();
            if(map.get(place) == null){
                ans.add(s);
                map.put(place, s);
            }
        }
        return ans;
    }

    // islands in 2D array of 0,1
    // assume not null, rectangle
//    public static int Q9(int[][] map){
//        int height = map.length, width = map[0].length;
//        UnionFind islands = new UnionFind(width*height);
//        for(int i=0; i<width; i++){
//            for(int j=0; j<height; j++){
//                if(map[i][j]==1) {
//                    int key =
//
//                }
//            }
//        }
//    }
    public static int rank(Node root, Node x){
        return rank(root, x, 0);
    }
    public static int rank(Node root, Node x, int total){
        if(root==null || x==null) return -1;
        if(root.data()==x.data()) return total+root.left().size();
        if(x.data() < root.data()) return rank(root.left(), x, total);
        return rank(root.right(), x, total+root.left().size()+1);
    }
}
