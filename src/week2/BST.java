package week2;

import java.util.Comparator;

public class BST {

    BST left, right;
    int data, size;
    BST(int data){
        this.data = data;
        this.size = 0;
    }
    public void add(int data){
        this.size++;
        if(data<this.data){
            if(this.left==null) {
                this.setLeft(data);
            }
            else {
                this.left.add(data);
            }
        }
        else{
            if(this.right==null){
                this.setRight(data);
            }
            else {
                this.right.add(data);
            }
        }
    }
    public boolean remove(int data){
        return false;
    }
    private void setLeft(int data){
        this.left = new BST(data);
    }
    private void setRight(int data){
        this.right = new BST(data);
    }
    public boolean isLeaf(){
        return this.right==null && this.left==null;
    }

}
