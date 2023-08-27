package exe.ex3;

import static exe.ex3.RBTree.*;

public class Ex3_3 {
    public static void main(String[] args) {
        RBTree tree = new RBTree ();
        tree.root = new Node(15, BLACK);
        tree.root.left = new Node(10, RED);
        tree.root.right = new Node(20, RED);
        System.out.println("is RB tree? "+isValidRedBlackTree(tree));

        tree.root = new Node(15, RED);
        tree.root.left = new Node(10, BLACK);
        tree.root.right = new Node(20, BLACK);
        System.out.println("is RB tree? "+isValidRedBlackTree(tree));

        tree.root = new Node(15, RED);
        tree.root.left = new Node(10, RED);
        tree.root.right = new Node(20, BLACK);
        System.out.println("is RB tree? "+isValidRedBlackTree(tree));

        tree.root = new Node(15, BLACK);
        tree.root.left = new Node(10, BLACK);
        tree.root.right = new Node(20, BLACK);
        System.out.println("is RB tree? "+isValidRedBlackTree(tree));

        tree.root = new Node(15, BLACK);
        tree.root.left = new Node(10, BLACK);
        tree.root.left.left = new Node(10, BLACK);
        tree.root.left.right = new Node(10, BLACK);
        tree.root.right = new Node(20, BLACK);
        tree.root.right.left = new Node(20, BLACK);
        tree.root.right.right = new Node(20, RED);
        tree.root.right.right.left = new Node(20, BLACK);
        tree.root.right.right.right = new Node(20, BLACK);
        System.out.println("is RB tree? "+isValidRedBlackTree(tree));
    }
}

class RBTree {
    public static final boolean RED = true, BLACK = false;
    public Node root; // root of the BST
    // constructor
    public RBTree() {
        root = null;
    }
    public static boolean isValidRedBlackTree(RBTree tree){
        if(tree.root.color==RED) return false;
        blackHeight(tree.root);
        return isRBT(tree.root);
    }
    private static boolean isRBT(Node node){
        if(node==null) return true;
        if(node.redRed || !node.balanced) return false;
        return isRBT(node.left) && isRBT(node.right);
    }
    private static int blackHeight(Node node){
        if(node==null) return 1;
        if(node.color && ((node.left!=null && node.left.color) ||
                (node.right!=null && node.right.color))) node.redRed = true;
        if(node.color==BLACK){
            int LBH = blackHeight(node.left), RBH = blackHeight(node.right);
            node.balanced = LBH==RBH;
            node.blackHeight = 1+Math.max(LBH, RBH);
            return node.blackHeight;
        }
        int LBH = blackHeight(node.left), RBH = blackHeight(node.right);
        node.balanced = LBH==RBH;
        node.blackHeight = Math.max(LBH, RBH);
        return node.blackHeight;
    }
}

class Node {
    public final boolean RED = true, BLACK = false;
    final Integer key; // associated data
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
        String c = "red";
        if (color == BLACK) c = "black";
        return "key: " + key + ", " + c;
    }
}