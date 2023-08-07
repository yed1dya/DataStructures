package week3;

public class TestBST {
	public static void BST_Test_1(){
		BinarySearchTree tree1 = new BinarySearchTree();
		tree1.insert(3);
		tree1.insert(1);
		tree1.insert(10);
		tree1.insert(5);
		tree1.insert(14);
		tree1.insert(4);
		tree1.insert(7);
		tree1.insert(16);
		tree1.insert(15);
		tree1.insert(20);
		tree1.printPreorderPlus();
		System.out.println("height = "+tree1.height());
		///remove
		System.out.println("remove 3");
		tree1.remove(3);
		tree1.printPreorderPlus();
		System.out.println("remove 1");
		tree1.remove(1);
		tree1.printPreorderPlus();
		System.out.println("remove 10");
		tree1.remove(10);
		tree1.printPreorderPlus();
		System.out.println("height = "+tree1.height());
		System.out.println("remove 5");
		tree1.remove(5);
		tree1.printPreorderPlus();
		System.out.println("remove 15");
		tree1.remove(15);
		tree1.printPreorderPlus();
		System.out.println("remove 14");
		tree1.remove(14);
		tree1.printPreorderPlus();
		System.out.println("remove 16");
		tree1.remove(16);
		tree1.printPreorderPlus();
		System.out.println("remove 20");
		tree1.remove(20);
		tree1.printPreorderPlus();
		System.out.println("remove 4");
		tree1.remove(4);
		tree1.printPreorderPlus();
		System.out.println("remove 177");
		tree1.remove(177);
		tree1.printPreorderPlus();
		System.out.println("height = "+tree1.height());
		System.out.println("remove 7");
		tree1.remove(7);
		tree1.printPreorderPlus();
		System.out.println("remove 1");
		tree1.remove(1);
		tree1.printPreorderPlus();
		System.out.println("height = "+tree1.height());
	}
	public static void BST_Test_2() {
		BinarySearchTree tree1 = new BinarySearchTree();
		tree1.insert(20);
		tree1.insert(50);
		tree1.insert(30);
		tree1.insert(40);
		tree1.insert(70);
		tree1.printPreorderPlus();
		tree1.remove(50);
		System.out.println("after remove 50");
		tree1.printPreorderPlus();
	}
	public static void main(String[] args){
		BST_Test_2();
	}
}

