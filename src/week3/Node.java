package week3;
public class Node{
	Integer data;
	Node left, right;
	int size;
	public Node(Integer newData) {
		data = newData;
		left = null;
		right = null;
	}
		public Node(Integer data, Node left, Node right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	public Node left(){
		return left;
	}
	public Node right(){
		return right;
	}
	public String toString(){
		return "data: "+data+" ";
	}
	public void setLeft(Node newNode){
		left = newNode;
	}
	public void setRight(Node newNode){
		right = newNode;
	}
	public boolean isLeaf() {
		return left==null && right==null;
	}
	public int data(){
		return data;
	}
	public int size(){
		return size;
	}
}
