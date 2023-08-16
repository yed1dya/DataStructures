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

        // variety of test cases:
        Node a = new Node(5);
        a.right = new Node(4);
        a.right.right = new Node(9);
        a.right.right.right = new Node(12);
        a.left = new Node(40);
        System.out.println();
        System.out.println(maxSumPath(new BinaryTree(a)));
        System.out.println();

        Node b = new Node(5);
        b.left = new Node(12);
        b.right = new Node(12);
        System.out.println(maxSumPath(new BinaryTree(b)));
        System.out.println();

        System.out.println(maxSumPath(null));
        System.out.println();
        System.out.println(maxSumPath(new BinaryTree(new Node(0))));
        System.out.println();

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
        System.out.println();

        Node d = new Node(1);
        d.left = new Node(2);
        d.right = new Node(4);
        d.left.left = new Node(20);
        d.left.right = new Node(12);
        d.left.right.left = new Node(3);
        d.left.right.right = new Node(0);
        System.out.println(maxSumPath(new BinaryTree(d)));
    }

    /**
     * uses helper functions:
     * update the max sum of each node O(n)
     * find the path to the largest sum O(n)
     * in addition, this required adding 'maxSum' field to 'Node' class.
     * @param tree tree to search
     * @return String representing the path that gives the max sum
     */
    public static String maxSumPath(BinaryTree tree){
        if (tree == null) return "Empty tree.\nmax sum path = \nmax sum =  ";
        updateMaxSums(tree.getRoot());
        return "max sum path = " + findMaxSum(tree.getRoot(), "") + "\nmax sum = " + tree.getRoot().maxSum();
    }

    /**
     * helper function to update the max sum of every node
     * @param n root node
     * @return max sum of the node
     */
    private static int updateMaxSums(Node n){
        if(n==null) return 0;
        int sum = n.getData()+Math.max(updateMaxSums(n.left), updateMaxSums(n.right));
        n.setMaxSum(sum);
        return sum;
    }

    /**
     * helper function to find the path to the max sum
     * @param n current node
     * @param s the current path
     * @return string representing the path to the max sum
     */
    private static String findMaxSum(Node n, String s){
        if(n==null || n.isLeaf()) return s;
        if(n.right==null || (n.left!=null && n.left.maxSum()>=n.right.maxSum())){
            return findMaxSum(n.left, s+"L");
        }
        return findMaxSum(n.right, s+"R");
    }
}

class Node{
    private int data, maxSum;
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
    public int maxSum(){
        return maxSum;
    }
    public void setMaxSum(int sum){
        this.maxSum = sum;
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