package week5;

import week3.Node;

import java.util.LinkedList;
import java.util.Stack;

public class Practice {
    public static void main(String[] args) {
        // 0 1 2 3 4 5 6 7 8 9
        // 0 3 4 5 6 6 7 8 9 10
        // 0 2 3 4 5 6 7 8 9 10
        // 1 1 1 1 2 3 4 5 6 7
//        System.out.println(Q1(new int[]{1,2,3,4,5,6,7,8,9}));
//        System.out.println(Q1(new int[]{0,2,3,4,5,6,7,8,9,10}));
//        System.out.println(Q1(new int[]{2,3,4,5,6,6,7,8,9,9}));
//        System.out.println(Q1(new int[]{1,1,1,1,2,3,4,5,6,7}));
//        System.out.println(Q1(new int[]{0}));
//        System.out.println(Q1(new int[]{1}));
//        System.out.println(Q1(new int[]{1,2}));
//        System.out.println(Q1(new int[]{0,1}));
//        System.out.println(Q3("123.123"));
//        System.out.println(Q3("123.321"));
//        System.out.println(Q3("123.1233"));

//        Node node = new Node(1);
//        node.setLeft(new Node(2));
//        node.setRight(new Node(3));

        Node n = new Node(0,
                new Node(1,
                        new Node(2, new Node(3),new Node(4)),
                        new Node(5,new Node(6),new Node(7))),
                new Node(8,
                        new Node(9,new Node(10),new Node(11)),
                        new Node(12,new Node(13),new Node(14))));

//        Node n1 = new Node(-1, n, null);
//        Node n2 = new Node(-1, n, new Node(15));
//        preorder(n);
//        System.out.println(Q8(n));
//        System.out.println(Q7(n));
//        preorder(n1);
//        System.out.println(Q8(n1));
//        System.out.println(Q7(n1));
//        preorder(n2);
//        System.out.println(Q8(n2));
//        System.out.println(Q7(n2));
//        for(int i=0; i<100; i++){
//            System.out.println(Q10(i));
//        }
        System.out.println(Q13(n, 2));
        System.out.println(smallestDif(new int[]{1,100}, new int[]{4,8,12,15,102,150}));
        System.out.println(smallestDif(new int[]{1, 10, 15, 20}, new int[]{4, 8, 19, 20}));
        System.out.println(find(new int[]{-1},-1));
        System.out.println(find(new int[]{-2,1,100}, new int[]{4,8,12,15,102,150}, 99));
    }
    public static void preorder(Node root){
        preorderHelp(root);
        System.out.println();
    }
    private static void preorderHelp(Node node){
        if (node==null) return;
        System.out.print(node.data()+" ");
        preorderHelp(node.left());
        preorderHelp(node.right());
    }
    // find place of A[i]=i, complexity O(log n)
    public static int Q1(int[] a){
        if(a==null || a.length == 0) return -1;
        return Q1(a, 0, a.length-1);
    }
    private static int Q1(int[] a, int start, int end){
        if(start>end) return -1;
        int mid = (start+end)/2;
        if(a[mid] == mid) return mid;
        if(a[mid]>mid){
            return Math.max(Q1(a, start, mid-1), Q1(a, mid+1, end));
        }
        return Q1(a, start, mid);
    }
    /*
    return num of leaves in tree
    Complexity: method is similar to a standard preOrder, O(n)
     */
    public static int Q2(Node node){
        if(node==null) return 0;
        if(node.isLeaf()) return 1;
        return Q2(node.left()) + Q2(node.right());
    }
    // check if digits after dec point are in same order as before point
    public static boolean Q3(String s){
        if(s == null || !s.contains(".")) return true;
        Stack<Character> s1 = new Stack<>(), s2 = new Stack<>();
        int i = 0;
        while (s.charAt(i)!='.'){
            s1.push(s.charAt(i++));
        }
        i++;
        while (i<s.length()){
            s2.push(s.charAt(i++));
        }
        while (!s1.isEmpty() && !s2.isEmpty()){
            if(!s1.pop().equals(s2.pop())){
                return false;
            }
        }
        return (s1.isEmpty() && s2.isEmpty());
    }
    // merge 2 sorted linkedLists
    public static LinkedList<Integer> Q4(LinkedList<Integer> list1, LinkedList<Integer> list2){
        LinkedList<Integer> ans = new LinkedList<>();
        int i = 0, j = 0;
        while (i<list1.size() && j<list2.size()){
            if(list1.get(i)<=list2.get(j)) ans.add(list1.get(i++));
            else ans.add(list2.get(j++));
        }
        while (i<list1.size()){
            ans.add(list1.get(i++));
        }
        while (j<list2.size()){
            ans.add(list2.get(j++));
        }
        return ans;
    }
    // "sort" all items smaller/bigger than val
    public static int[] Q5(int[] a, int val){
        if(a==null || a.length==0) return a;
        int small = 0, big = a.length-1, length = big+1;
        int[] ans = new int[length];
        for(int i = 0; i < length; i++){
            int t = a[i];
            if(t > val){
                ans[small++] = t;
            }
            else{
                ans[big--] = t;
            }
        }
        return ans;
    }
    // num of nodes in BT
    public static int Q6(Node node){
        if(node==null) return 0;
        return 1+Q6(node.right())+Q6(node.left());
    }
    // check if is complete BT
    public static boolean Q7(Node node){
        if(node==null) return true;
        String s = Q7(node,0,"");
        int i=1;
        while(i<s.length()){
            if((s.charAt(i-1)!=s.charAt(i++))) return false;
        }
        return true;
    }
    private static String Q7(Node node, int height, String heights){
        if(node==null) return heights;
        if(node.isLeaf()) return heights+height;
        if(node.left()==null || node.right()==null) return "nope";
        return Q7(node.left(), height+1, heights)+Q7(node.right(), height+1, heights);
    }
    // num of leaves in BT
    public static int Q8(Node node){
        if(node==null) return 0;
        if(node.isLeaf()) return 1;
        return Q8(node.left()) + Q8(node.right());
    }
    // return rounded-down cube root
    // time O(log n) space O(1)
    public static String Q10(int n){
        return n + ": "+ Q10Help(n);
    }
    private static int Q10Help(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        double low = 0, high = n, m = (low+high)/2;
        while(Math.abs(m*m*m-n)>1){
            m = (low+high)/2;
            if(m*m*m < n) low = m;
            else high = m;
        }
        return (int)m;
    }
    // return kth element in tree
    // time O(log n)
    public static Node Q13(Node node, int k){
        if(node==null) return null;
        return Q13help(node, k);
    }
    private static Node Q13help(Node node, int k){
        if(node.size()<k) return null;
        int leftSize = 0;
        if(node.left()!=null){
            leftSize = node.left().size();
            if(node.left().size() >= k) return Q13help(node.left(), k);
            if(k==node.left().size()+1) return node;
        }
        if(node.right()!=null) return Q13help(node.right(), k-(node.size()-leftSize));
        return null;
    }

    public static int smallestDif(int[] a, int[] b){
        int i=0, j=0, ans = Math.abs(a[0]-b[0]);
        while (i < a.length && j < b.length){
            if(ans==0) return ans;
            int current = a[i] - b[j], currentAbs = Math.abs(current);
            if(currentAbs < ans) ans = currentAbs;
            if(current < 0) i++;
            else j++;
        }
        return ans;
    }

    public static int find(int[] a, int c){
        return find(a, c, 0, a.length-1);
    }
    public static int find(int[] a, int c, int start, int end){
        if(start>end) return -1;
        int j = (start+end)/2, m = a[j];
        if(m == c) return j;
        if(m < c) return find(a, c, j+1, end);
        return find(a, c, start, j-1);
    }

    public static String find(int[] a, int[] b, int s){
        int i=0, j=b.length-1,t;
        while(i<a.length && j>=0){
            t = a[i]+b[j];
            if(t==s) return i+", "+j;
            if(t<s) i++;
            if(t>s) j--;
        }
        return "not found";
    }
}
