package week3;
public class Node{
	Integer data;
	Node left, right;
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
	public String toString(){
		return "data: "+data+" ";
	}

}
