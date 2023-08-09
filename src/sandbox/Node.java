package sandbox;

public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> left, right;
    private int height;
    public Node(T d) {
        this.data = d;
        this.left = null;
        this.right = null;
    }
    public Node(T data, Node<T> left, Node<T> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public String toString(){
        return "data: "+data+" ";
    }
    public boolean isLeaf() {
        return left==null && right==null;
    }
    public Node<T> left(){
        return this.left;
    }
    public Node<T> right(){
        return this.right;
    }
    public T data() {
        return this.data;
    }
    public void setLeft(Node<T> node){
        this.left = node;
    }
    public void setRight(Node<T> node){
        this.right = node;
    }
    public void setData(T data){
        this.data = data;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int height(){
        return height;
    }
}