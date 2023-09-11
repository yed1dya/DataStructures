// 207404997, 325168870
package exe.ex3;
import static exe.ex3.RBTree.*;

/**
 * @author 207404997, 325168870
 */
public class Ex3_3 {
    public static void main(String[] args) {
        // variety of test cases:

        // true:
        RBTree tree = new RBTree ();
        tree.root = new Node(15, BLACK);
        tree.root.left = new Node(10, RED);
        tree.root.right = new Node(20, RED);
        System.out.println("true");
        System.out.println("is RB tree? "+isValidRedBlackTree(tree));

        // false:
        tree.root = new Node(15, RED);
        tree.root.left = new Node(10, BLACK);
        tree.root.right = new Node(20, BLACK);
        System.out.println("false");
        System.out.println("is RB tree? "+isValidRedBlackTree(tree));

        // true:
        tree.root = new Node(15, BLACK);
        tree.root.left = new Node(10, BLACK);
        tree.root.right = new Node(20, BLACK);
        System.out.println("true");
        System.out.println("is RB tree? "+isValidRedBlackTree(tree));

        // true:
        tree.root = new Node(15, BLACK);
        tree.root.left = new Node(10, BLACK);
        tree.root.left.left = new Node(10, BLACK);
        tree.root.left.right = new Node(10, BLACK);
        tree.root.right = new Node(20, BLACK);
        tree.root.right.left = new Node(20, BLACK);
        tree.root.right.right = new Node(20, RED);
        tree.root.right.right.left = new Node(20, BLACK);
        tree.root.right.right.right = new Node(20, BLACK);
        System.out.println("true");
        System.out.println("is RB tree? "+isValidRedBlackTree(tree));

        // true:
        tree.root.right.right.right.right = new Node(20, RED);
        tree.root.right.right.right.left = new Node(20, RED);
        System.out.println("true");
        System.out.println("is RB tree? "+isValidRedBlackTree(tree));

        // false
        tree.root=new Node(15,BLACK);
        tree.root.left=new Node(10,RED);
        tree.root.right= new Node(20,RED);
        tree.root.right.right= new Node(27,RED);
        System.out.println("false");
        System.out.println("is RB tree? "+isValidRedBlackTree(tree));

        // true
        tree.root=new Node(15,BLACK);
        tree.root.left=new Node(10,RED);
        tree.root.left.left=new Node(8,BLACK);
        tree.root.left.right=new Node(11,BLACK);
        tree.root.right= new Node(20,RED);
        tree.root.right.right= new Node(27,BLACK);
        tree.root.right.left= new Node(19,BLACK);
        System.out.println("true");
        System.out.println("is RB tree? "+isValidRedBlackTree(tree));

        // false
        tree.root=new Node(15,BLACK);
        tree.root.left=new Node(10,RED);
        tree.root.left.left=new Node(8,BLACK);
        tree.root.left.right=new Node(11,BLACK);
        tree.root.right= new Node(20,RED);
        tree.root.right.right= new Node(27,RED);
        tree.root.right.left= new Node(19,BLACK);
        System.out.println("false");
        System.out.println("is RB tree? "+isValidRedBlackTree(tree));

        // null root - true
        tree.root = null;
        System.out.println("true");
        System.out.println("is RB tree? "+isValidRedBlackTree(tree));

        // null tree - true
        System.out.println("true");
        System.out.println("is RB tree? "+isValidRedBlackTree(null));

        tree.root=new Node(15,BLACK);
        tree.root.right = new Node(20, RED);
        tree.root.left = new Node(20, RED);
        tree.root.left.right = new Node(20, BLACK);
        tree.root.left.left = new Node(20, BLACK);
        System.out.println(RBTree.blackHeight(tree.root));
    }
}

class RBTree {
    public static final boolean RED = true, BLACK = false;
    public Node root; // root of the BST
    // constructor
    public RBTree() {
        root = null;
    }

    /**
     * Checks if a given BST is a RBT (assume the tree is BST).
     * @param tree RBT to check
     * @return true iff tree is a valid RBT
     */
    public static boolean isValidRedBlackTree(RBTree tree){
        // bas cases: null tree or null root
        if(tree==null || tree.root==null) return true;
        // if root is red, it's not a RBT:
        if(tree.root.color==RED) return false;
        // update black heights and red-red flags in tree:
        blackHeight(tree.root);
        // call helper function:
        return isRBT(tree.root);
    }

    /**
     * Recursive helper function for isValidRedBlackTree.
     * @param node root of a subtree
     * @return true iff node is the root of a valid RBT, otherwise false.
     */
    private static boolean isRBT(Node node){
        // base case:
        if(node==null) return true;
        // check black balance:
        if(node.redRed || !node.balanced) return false;
        // check left and right children, recursively:
        return isRBT(node.left) && isRBT(node.right);
    }

    /**
     * Recursive helper function for isValidRedBlackTree:
     * update the black height of each node in the subtree.
     * @param node root of subtree
     * @return the black height of "node"
     */
    public static int blackHeight(Node node){
        // null nodes are black by default:
        if(node==null) return 1;
        // check if node is a "red-red" situation; red node and red parent:
        if(node.color==RED && ((node.left!=null && node.left.color==RED) ||
                (node.right!=null && node.right.color==RED))) node.redRed = true;
        // recursively get black height of children:
        int LeftBH = blackHeight(node.left);
        int RightBH = blackHeight(node.right);
        // set "balanced" parameter:
        node.balanced = LeftBH==RightBH;
        // set black height:
        // max of right and left black height.
        node.blackHeight = Math.max(LeftBH, RightBH);
        // if node is black, add 1:
        if(node.color==BLACK) node.blackHeight++;
        return node.blackHeight;
    }
}

class Node {
    public final boolean RED = true, BLACK = false;
    final Integer key;
    final boolean color;
    public boolean balanced, redRed;
    Node left, right;
    public int blackHeight;
    // constructor
    public Node(Integer data, boolean color) {
        this.key = data;
        this.color = color;
        left = right = null;
        blackHeight = 0;
    }
    public String toString() {
        String c = "null";
        if(color == RED) c = "red";
        if(color == BLACK) c = "black";
        return "key: " + key + ", " + c;
    }
}