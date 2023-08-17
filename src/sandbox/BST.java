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
    public boolean isBST(){
        return isBST(this.root, this.min(), this.max());
    }
    private boolean isBST(Node<T> root, T min, T max){
        if(root==null) return true;
        if(root.data().compareTo(min)<0 || root.data().compareTo(max)>0) return false;
        return isBST(root.left(), min, root.data()) && isBST(root.right(), root.data(), max);
    }
    private T max(){
        if(root==null) return null;
        Node<T> ans = this.root;
        while(ans.right()!=null){
            ans = ans.right();
        }
        return ans.data();
    }
    private T min(){
        if(root==null) return null;
        Node<T> ans = this.root;
        while(ans.left()!=null){
            ans = ans.left();
        }
        return ans.data();
    }
    public void mirror(){
        mirror(root);
    }
    public void mirror(Node<T> root){
        if(root == null) return;
        swap(root);
        mirror(root.right());
        mirror(root.left());
    }
    private void swap(Node<T> root){
        Node<T> t = root.left();
        root.setLeft(root.right());
        root.setRight(t);
    }
    public Node<T> LCA(Node<T> a, Node<T> b){
        return LCA(this.root, a, b);
    }
    private Node<T> LCA(Node<T> node, Node<T> a, Node<T> b){
        if(node==null) return null;
        if(a.compare(node)<0 && b.compare(node)<0) return LCA(node.left(), a, b);
        if(a.compare(node)>0 && b.compare(node)>0) return LCA(node.left(), a, b);
        return node;
    }
}
