package week3;

public class BinaryTreeTest {

	public static void main(String[] args){
		BinaryTreeCode2 tree = new BinaryTreeCode2();
		tree.root = new BTNode(1);
		tree.root.left = new BTNode(2);
		tree.root.right = new BTNode(3);
		tree.root.left.left = new BTNode(4);
		tree.printPreorderPlus();
		System.out.println("height = "+tree.height());
		System.out.println("numOfNodes = "+tree.numOfNodes());
	}

}
