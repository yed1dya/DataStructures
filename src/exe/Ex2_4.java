// 207404997
package exe;

public class Ex2_4 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(new Node(6));
        Node root = bt.getRoot();
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(9);
        root.right.right = new Node(11);
        root.right.left = new Node(7);
        root.right.left.left = new Node(13);
        System.out.println(maxSumPath(bt));
        System.out.println(maxSumPath2(bt));
        System.out.println();

        Node r = new Node(1);
        r.left = new Node(Integer.MAX_VALUE);
        r.right = new Node(0);
        BinaryTree bt1 = new BinaryTree(r);
        System.out.println(maxSumPath(bt1));
        System.out.println(maxSumPath2(bt1));
        System.out.println();

        Node a = new Node(5);
        a.right = new Node(4);
        a.right.right = new Node(9);
        a.right.right.right = new Node(12);
        a.left = new Node(40);
        System.out.println(maxSumPath(new BinaryTree(a)));
        System.out.println(maxSumPath2(new BinaryTree(a)));
        System.out.println();

        Node b = new Node(5);
        b.left = new Node(12);
        b.right = new Node(12);
        System.out.println(maxSumPath(new BinaryTree(b)));
        System.out.println(maxSumPath2(new BinaryTree(b)));
        System.out.println();

        System.out.println(maxSumPath(null));
        System.out.println(maxSumPath2(null));
        System.out.println(maxSumPath(new BinaryTree(new Node(0))));
        System.out.println(maxSumPath2(new BinaryTree(new Node(0))));

        Node c = new Node(2);
        c.left = new Node(100);
        c.left.right = new Node(8);
        c.left.right.right = new Node(61);
        c.left.left = new Node(0);
        c.left.left.left = new Node(83);
        c.left.left.right = new Node(-126);
        c.left.left.right.left = new Node(18);
        c.right = new Node(12);
        c.right.right = new Node(-91);
        c.right.right.left = new Node(3);
        c.right.right.left.left = new Node(11);
        c.right.right.right = new Node(84);
        System.out.println(maxSumPath(new BinaryTree(c)));
        System.out.println(maxSumPath2(new BinaryTree(c)));
    }

    /**
     * uses helper function
     * @param tree BinaryTree to search
     * @return String representing the path that gives the max sum
     */
    public static String maxSumPath(BinaryTree tree) {
        if (tree == null) return "empty tree";
        return "max sum path = " + maxSumPath(tree.getRoot(), new info(0, "")).path + "\nmax sum = " + maxSum(tree);
    }
    public static String maxSumPath2(BinaryTree tree) {
        if (tree == null) return "empty tree";
        return "max sum path = " + maxSumPath(tree.getRoot(), "") + "\nmax sum = "+maxSum(tree);
    }
    private static String maxSumPath(Node n, String s){
        // base cases:
        if(n==null || n.isLeaf()) return s;
        // check which subtree has the greater sum:
        int leftSum = maxSum(n.left), rightSum = maxSum(n.right);
        // call maxSumPath recursively and add the direction to path:
        if(leftSum>=rightSum) return maxSumPath(n.left, s+"L");
        return maxSumPath(n.right, s+"R");
    }
    private static info maxSumPath(Node n, info i){
        // base cases:
        if(n==null) return i;
        if(n.isLeaf()) return new info(i.sum+ n.getData(), i.path);
        // check which subtree has the greater sum:
        info left = maxSumPath(n.left, i);
        info right = maxSumPath(n.right, i);
        //System.out.println("left: "+left.sum+", right: "+right.sum);
        // if left side has a greater sum:
        if(left.sum>=right.sum) return new info(left.sum+n.getData(), "L"+left.path);
        // if right side has a greater sum:
        return  new info(right.sum+n.getData(), "R"+right.path);
    }
    /**
     * uses helper function
     * @param tree BinaryTree to search
     * @return the largest possible sum from a single path
     */
    public static int maxSum(BinaryTree tree){
        return maxSum(tree.getRoot());
    }
    /**
     * helper function for maxSum(BinaryTree tree)
     * @param n current node
     * @return the largest possible sum from a single path in the subtree
     */
    private static int maxSum(Node n){
        // base case:
        if(n==null) return 0;
        // recursive call on left and right subtrees:
        return n.getData()+Math.max(maxSum(n.left), maxSum(n.right));
    }
}

class info{
    public int sum;
    public String path;
    public info(int sum, String path){
        this.sum = sum;
        this.path = path;
    }
    public info(info i){
        this.path = i.path;
        this.sum = i.sum;
    }
}

class Node{
    private int data;
    protected Node left, right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public String toString(){return data+", ";}
    public Integer getData() {return data;}
    public Node getLeft() {return left;}
    public Node getRight() {return right;}
    public boolean isLeaf() {
        return left==null && right==null;
    }
}
class BinaryTree {
    private final Node root;
    BinaryTree(Node root) {
        this.root = root;
    }
    public Node getRoot() {
        return root;
    }
}