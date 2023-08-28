package sandbox;

import java.util.LinkedList;
import java.util.Queue;

public class AVL<T extends Comparable<T>> {
    public static void main(String[] args) {
        AVL<Integer> tree = new AVL<>();
        tree.insert(5);
        tree.insert(8);
        tree.insert(2);
        tree.insert(7);
        tree.inOrder();
        tree.byLevel();
        tree.insert(6);
        tree.inOrder();
        tree.byLevel();
        tree.remove(6);
        tree.inOrder();
        tree.byLevel();
        tree.preOrder();
    }
    private Node<T> root;
    private StringBuilder str = new StringBuilder();
    public void insert(T data){
        root = insert(data, root);
    }
    private Node<T> insert(T data, Node<T> node){
        // if root is null, set new node here:
        if(node==null) return new Node<>(data);
        // if data is smaller than root:
        if(data.compareTo(node.data())<0) node.setLeft(insert(data, node.left()));
        // if data is bigger than root:
        else if(data.compareTo(node.data())>0) node.setRight(insert(data, node.right()));
        // if data is equal to root, it already exists.
        else return node;
        // update the node's height:
        updateHeight(node);
        // rotate the tree if needed:
        return rotate(node);
    }
    private Node<T> rotate(Node<T> node){
        // get balance:
        int balance = balance(node);
        if(balance > 1){
            // if the node's balance is >1 but the left node's balance is <0,
            // it's a left-right balance. Rotate the left subtree to the right:
            if(balance(node.left())<0) node.setLeft(rotateLeft(node.left()));
            // now it's a left-left balance. Rotate right.
            return rotateRight(node);
        }
        if(balance < -1){
            // right-left:
            if(balance(node.right())>0) node.setRight(rotateRight(node.right()));
            // right-right:
            return rotateLeft(node);
        }
        return node;
    }
    private Node<T> rotateRight(Node<T> node){
        // create temp nodes:
        Node<T> left = node.left();
        Node<T> center = left.right();
        // swap node and left. subtrees stay the same
        left.setRight(node);
        node.setLeft(center);
        updateHeight(node);
        updateHeight(left);
        return left;
    }
    private Node<T> rotateLeft(Node<T> node){
        Node<T> right = node.right();
        Node<T> center = right.left();
        right.setLeft(node);
        node.setRight(center);
        updateHeight(node);
        updateHeight(right);
        return right;
    }
    private int balance(Node<T> node) {
        return node!=null ? height(node.left())-height(node.right()) : 0;
    }

    private void updateHeight(Node<T> node){
        if(node==null) return;
        node.setHeight(1+Math.max(height(node.left()), height(node.right())));
    }
    private int height(Node<T> node){
        return node!=null ? node.height() : 0;
    }
    public void remove(T data){
        root = remove(data, root);
    }
    private Node<T> remove(T data, Node<T> node){
        if(node==null) return null;
        // find the node we want to remove:
        if(data.compareTo(node.data())<0) node.setLeft(remove(data, node.left()));
        else if(data.compareTo(node.data())>0) node.setRight(remove(data, node.right()));
        else{
            if(node.isLeaf()) node=null;
            // need to find successor:
            else if(node.right()!=null){
                node.setData(successor(node));
                node.setRight(remove(node.data(), node.right()));
            }
            // need to find predecessor
            else {
                node.setData(predecessor(node));
                node.setLeft(remove(node.data(), node.left()));
            }
        }
        updateHeight(node);
        return rotate(node);
    }
    private T predecessor(Node<T> node) {
        node = node.left();
        while(node.right()!=null) node = node.right();
        return node.data();
    }
    private T successor(Node<T> node) {
        node = node.right();
        while(node.left()!=null) node = node.left();
        return node.data();
    }
    public void inOrder(){
        System.out.println("inOrder:");
        inOrder(root);
        System.out.println(str.substring(0, str.length()-2));
        str = new StringBuilder();
    }
    private void inOrder(Node<T> root) {
        if(root!=null){
            inOrder(root.left());
            str.append(root.data()).append(", ");
            inOrder(root.right());
        }
    }
    public void preOrder(){
        System.out.println("preOrder:");
        preOrder(root);
        System.out.println(str.substring(0, str.length()-2));
        str = new StringBuilder();
    }
    private void preOrder(Node<T> root) {
        if(root!=null){
            str.append(root.data()).append(", ");
            preOrder(root.left());
            preOrder(root.right());
        }
    }
    public void byLevel(){
        System.out.println("byLevel:");
        byLevel(root);
        System.out.println(str.substring(0, str.length()-2));
        str = new StringBuilder();
    }
    private void byLevel(Node<T> root){
        if(root!=null) {
            Queue<Node<T>> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()){
                Node<T> temp = q.poll();
                str.append(temp.data()).append(", ");
                if (temp.left() != null) {
                    q.add(temp.left());
                }
                if (temp.right() != null) {
                    q.add(temp.right());
                }
            }
        }
    }
}
