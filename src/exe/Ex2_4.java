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
        String path = maxSumPath(bt);
        System.out.println("max sum: "+maxSum(bt)+"\nmax sum path = "+path);
    }

    /**
     * uses helper function
     * @param tree BinaryTree to search
     * @return String representing the path that gives the max sum
     */
    public static String maxSumPath(BinaryTree tree) {
        return maxSumPath(tree.getRoot(), "");
    }

    /**
     * helper function for maxSumPath(BinaryTree tree)
     * @param n current node
     * @param s current path
     * @return String representing the path that gives the max sum
     */
    private static String maxSumPath(Node n, String s){
        // base cases:
        if(n==null || n.isLeaf()) return s;
        // check which subtree has the greater sum:
        int leftSum = maxSum(n.left), rightSum = maxSum(n.right);
        // call maxSumPath recursively and add the direction to path:
        if(leftSum>=rightSum) return maxSumPath(n.left, s+"L");
        return maxSumPath(n.right, s+"R");
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
        // base cases:
        if(n==null) return 0;
        if(n.isLeaf()) return n.getData();
        // recursive call on left and right subtrees:
        return n.getData()+Math.max(maxSum(n.left), maxSum(n.right));
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
    public String toString(){return data +", ";}
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