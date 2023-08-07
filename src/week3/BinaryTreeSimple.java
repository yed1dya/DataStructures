package week3;

class NodeS{
    Object data;
    NodeS left, right;

    NodeS(Object data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public String toString(){return ""+data;}
}// Node

public class BinaryTreeSimple {
    NodeS root;
    public BinaryTreeSimple(){
        root = null;
    }
    public BinaryTreeSimple(NodeS root) {
        this.root = root;
    }
    public NodeS getRoot() {
        return root;
    }
    // print all tree nodes
    // PreOrder
    public void printPreOrder() {
        printPreOrder(root);
        System.out.println();
    }
    void printPreOrder(NodeS node) {//PreOrder
        if (node != null) {
            System.out.print(node.data+", ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }
    public void printPreorderPlus(){
        printPreorderPlus("", root);
    }
    public void printPreorderPlus(String Path, NodeS node){
        if (node != null){
            System.out.println(node.data + ": " + Path);
            printPreorderPlus(Path+"L", node.left);
            printPreorderPlus(Path+"R", node.right);
        }
    }
    // InOrder
    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }
    void printInOrder(NodeS node) {//PreOrder
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data+", ");
            printInOrder(node.right);
        }
    }
    // PostOrder
    public void printPostOrder() {
        printPostOrder(root);
        System.out.println();
    }
    void printPostOrder(NodeS node) {//PreOrder
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.data+", ");
        }
    }
    public boolean contains(Object data, NodeS node){
        boolean ans = false;
        if (node==null){
            ans = false;
        }
        else{
            ans = node.data.equals(data) || contains(data, node.left) || contains(data, node.right);
        }
        return ans;
    }
    /////////
    public boolean isEmpty(){
        return this.root == null;
    }
    //////////
    public int height(){
        return height(root) - 1;
    }
    public int height(NodeS node){
        int ans =  0;
        if (node != null) {
            int hLeft = height(node.left);
            int hRight = height(node.right);
            ans = (Math.max(hLeft, hRight)) + 1;
        }
        return ans;
    }
    public int  getNumLeaves() {
        return getNumLeaves(root);
    }
    public int getNumLeaves(NodeS tree) {
        if (tree == null) return 0;
        else if (tree.left==null && tree.right==null)
            return 1;
        else
            return getNumLeaves(tree.left) + getNumLeaves(tree.right);
    }

    public static void main(String[] args) {
        BinaryTreeSimple bt = new BinaryTreeSimple(new NodeS(6));
        NodeS root = bt.getRoot();
        root.left = new NodeS(3);
        root.left.left = new NodeS(2);
        root.left.right = new NodeS(4);
        root.right = new NodeS(9);
        root.right.right = new NodeS(11);
        root.right.left = new NodeS(7);
        root.right.left.left = new NodeS(27);
        bt.printPreorderPlus();
    }
}
