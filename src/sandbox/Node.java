package sandbox;

public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> left, right, parent;
    private boolean color;
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
    public boolean isLeft(){
        return this==this.parent.left;
    }
    public void flip(){
        this.color = !this.color;
    }
    public boolean color(){
        return this.color;
    }
    public void setColor(boolean color){
        this.color = color;
    }
    public void setParent(Node<T> parent){
        this.parent = parent;
    }
    public Node<T> parent(){
        return this.parent;
    }
    public int compare(Node<T> other){
        return this.data.compareTo(other.data());
    }
    public int updateNodeHeight(Node<T> root) {
        if (root == null) return -1;
        return root.height = 1 + Math.max(updateNodeHeight(root.left), updateNodeHeight(root.right));
    }
}