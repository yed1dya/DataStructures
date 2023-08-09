package sandbox;

import java.util.LinkedList;
import java.util.Queue;

public class BST<T extends Comparable<T>> {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(5);
        tree.byLevel();
        tree.insert(8);
        tree.byLevel();
        tree.insert(2);
        tree.byLevel();
        tree.insert(7);
        tree.display();
        tree.byLevel();
        tree.insert(6);
        tree.display();
        tree.byLevel();
        tree.remove(6);
        tree.display();
        tree.byLevel();
    }
    private Node<T> root;
    private StringBuilder str = new StringBuilder();
    public boolean search(T data){
        return search(root, data);
    }
    private boolean search(Node<T> root, T data){
        if(root==null) return false;
        if (root.data().equals(data)) return true;
        else if(root.data().compareTo(data)>0) return search(root.left(), data);
        else return search(root.right(), data);
    }
    public void insert(T data){
        if(isEmpty()) root = new Node<>(data);
        else insert(data, root);
    }
    private void insert(T data, Node<T> node){
        if(data.compareTo(node.data())<0){
            if(node.left()==null){
                node.setLeft(new Node<>(data));
            }
            else {
                insert(data, node.left());
            }
        }
        else if(data.compareTo(node.data())>0){
            if(node.right()==null){
                node.setRight(new Node<>(data));
            }
            else {
                insert(data, node.right());
            }
        }
    }
    public void remove(T data){
        if(search(data)){
            remove(data, root);
        }
        else System.out.println("not found");
    }
    private Node<T> remove(T data, Node<T> node){
        if(node==null) return null;
        if(data.compareTo(node.data())<0) node.setLeft(remove(data, node.left()));
        else if(data.compareTo(node.data())>0) node.setRight(remove(data, node.right()));
        else{
            if(node.isLeaf()){
                node=null;
            }
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
        return node;
    }
    private T predecessor(Node<T> node){
        node = node.left();
        while(node.right()!=null) node = node.right();
        return node.data();
    }
    private T successor(Node<T> node){
        node = node.right();
        while(node.left()!=null) node = node.left();
        return node.data();
    }
    public void display(){
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
    public void display2(){
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
    private boolean isEmpty() {
        return root==null;
    }
}
