package week3;
class NodeAVL {
	Integer key;
	int balance, height;
	NodeAVL left, right, parent;

	NodeAVL(Integer key, NodeAVL parent) {
		this.key = key;
		this.parent = parent;
		left = right = null;
		height = 0;
	}
	public String toString(){
		return "key: "+key;
	}
}

public class AVLtree2 {
	private NodeAVL root;
	public boolean insert(Integer key) {
		if (root == null){
			root = new NodeAVL(key, null);
		}
		else {
			NodeAVL n = root;
			NodeAVL parent;
			boolean flag = true;
			while (flag) {
				if (n.key == key){
					return false;
				}
				parent = n;
				boolean goLeft = n.key > key;
				n = goLeft ? n.left : n.right;
				if (n == null) {
					if (goLeft){
						parent.left = new NodeAVL(key, parent);
					} 
					else{
						parent.right = new NodeAVL(key, parent);
					}
					rebalance(parent);
					flag = false;;
				}
			}
		}
		return true;
	}
	public void delete(Integer delKey) {
		if (root == null)
			return;
		NodeAVL n = root;
		NodeAVL parent = root;
		NodeAVL delNodeAVL = null;
		NodeAVL child = root;

		while (child != null) {
			parent = n;
			n = child;
			child = delKey >= n.key ? n.right : n.left;
			if (delKey == n.key){
				delNodeAVL = n;
			}
		}

		if (delNodeAVL != null) {
			delNodeAVL.key = n.key;

			child = n.left != null ? n.left : n.right;

			if (root.key == delKey) {
				root = child;
			}
			else{
				if (parent.left == n) {
					parent.left = child;
				} 
				else {
					parent.right = child;
				}
				rebalance(parent);
			}
		}
	}

	private void rebalance(NodeAVL n) {
		setBalance(n);

		if (n.balance == -2) {
			if (height(n.left.left) >= height(n.left.right))
				n = rotateRight(n);
			else
				n = rotateLeftThenRight(n);

		} 
		else if (n.balance == 2) {
			if (height(n.right.right) >= height(n.right.left))
				n = rotateLeft(n);
			else
				n = rotateRightThenLeft(n);
		}

		if (n.parent != null) {
			rebalance(n.parent);
		} 
		else {
			root = n;
		}
	}

	private NodeAVL rotateLeft(NodeAVL a) {

		NodeAVL b = a.right;
		b.parent = a.parent;

		a.right = b.left;

		if (a.right != null)
			a.right.parent = a;

		b.left = a;
		a.parent = b;

		if (b.parent != null) {
			if (b.parent.right == a) {
				b.parent.right = b;
			} 
			else {
				b.parent.left = b;
			}
		}

		setBalance(a, b);

		return b;
	}

	private NodeAVL rotateRight(NodeAVL a) {

		NodeAVL b = a.left;
		b.parent = a.parent;

		a.left = b.right;

		if (a.left != null)
			a.left.parent = a;

		b.right = a;
		a.parent = b;

		if (b.parent != null) {
			if (b.parent.right == a) {
				b.parent.right = b;
			} 
			else {
				b.parent.left = b;
			}
		}

		setBalance(a, b);

		return b;
	}

	private NodeAVL rotateLeftThenRight(NodeAVL n) {
		n.left = rotateLeft(n.left);
		return rotateRight(n);
	}

	private NodeAVL rotateRightThenLeft(NodeAVL n) {
		n.right = rotateRight(n.right);
		return rotateLeft(n);
	}
	
	public int height(NodeAVL p){
		if (p == null) return -1;
		int hLeft = p.left != null ? p.left.height : -1;
		int hRight = p.right != null ? p.right.height : -1; 
		p.height = (hLeft > hRight ?  hLeft : hRight) + 1;
		return p.height;
	}
	public int height(){
		return height(root);
	}
	public int size(){
		return size(root);
	}
	public int size(NodeAVL n){
		int ans = 0;
		if (n != null){
			ans = size(n.left) + size(n.right) + 1;
		}
		return ans;
	}

	private void setBalance(NodeAVL... NodeAVLs) {
		for (NodeAVL n : NodeAVLs)
			n.balance = height(n.right) - height(n.left);
	}

	public void printBalance() {
		printBalance(root);
		System.out.println();
	}

	private void printBalance(NodeAVL n) {
		if (n != null) {
			printBalance(n.left);
			System.out.printf("%d ", n.balance);
			printBalance(n.right);
		}
	}
	public void printPreorderPlus(){
		printPreorderPlus("", root);
	}
	public void printPreorderPlus(String Path, NodeAVL NodeAVL){
		if (NodeAVL != null){
			System.out.println(NodeAVL.key + ": " + Path);
			printPreorderPlus(Path+"L", NodeAVL.left);
			printPreorderPlus(Path+"R", NodeAVL.right);
		}
	}
	public static void testAVL(){
		AVLtree2 tree = new AVLtree2();

		//Integer[] a = {1,6,13,24,21,16,11,12};
		Integer[] a = {1,2,3,4};
		//Integer[] a = {1,2,3,4,5,6,7,8,9};
		//Integer[] a = {10,5,20,15,40,80,30};
		System.out.println("Inserting values");
		for (int i = 0; i < a.length; i++){
			tree.insert(a[i]);
		}
		tree.printPreorderPlus();
		System.out.println();
		
		System.out.println("size = "+tree.size());
		System.out.print("Printing balance: ");
		tree.printBalance();
		System.out.println("tree height: "+tree.height());
		System.out.println("delete 4");
		tree.delete(4);
		tree.printBalance();
		tree.printPreorderPlus();  
		System.out.println("delete 1");
		tree.delete(1);
		tree.printBalance();
		tree.printPreorderPlus();  
		System.out.println("delete 2");
		tree.delete(2);
		tree.printBalance();
		tree.printPreorderPlus();  
		System.out.println("delete 3");
		tree.delete(3);
		tree.printBalance();
		tree.printPreorderPlus();  
		System.out.println("delete 4");
		tree.delete(4);
		tree.printBalance();
		tree.printPreorderPlus();  
	}
	public static void testExam_2016SbMAa(){
		AVLtree2 tree = new AVLtree2();
		Integer[] a = {10,5,20,15,40,80,30};
		System.out.println("Inserting values");
		for (int i = 0; i < a.length; i++)
			tree.insert(a[i]);
		System.out.print("Printing balance: ");
		tree.printBalance();
		tree.printPreorderPlus();
		System.out.println("\ndelete 20");
		tree.delete(20);
		tree.printPreorderPlus();
		System.out.println("\ndelete 10");
		tree.delete(10);
		tree.printPreorderPlus();
		System.out.println("\ndelete 15");
		tree.delete(15);
		tree.printPreorderPlus();
		System.out.println("\ndelete 10");
		tree.delete(10);
		tree.printPreorderPlus();
		System.out.println("\ndelete 40");
		tree.delete(40);
		tree.printPreorderPlus();
		System.out.println("\ndelete 20");
		tree.delete(20);
		tree.printPreorderPlus();
		System.out.println("\ndelete 80");
		tree.delete(80);
		System.out.println("size = "+tree.size());
		tree.printPreorderPlus();
		System.out.println("\ndelete 30");
		tree.delete(30);
		System.out.println("size = "+tree.size());
		tree.printPreorderPlus();
		System.out.println("\ndelete 5");
		tree.delete(5);
		System.out.println("size = "+tree.size());
		tree.printPreorderPlus();
		System.out.println("\ndelete 5");
		tree.delete(5);
		System.out.println("size = "+tree.size());
		tree.printPreorderPlus();
	}
	public static void main(String[] args) {
		testExam_2016SbMAa();
		//testAVL();
	}
}
/* 
Inserting values
Printing balance: 0 0 0 0 0 0 0 
20: 
10: L
5: LL
15: LR
40: R
30: RL
80: RR

delete 20
30: 
10: L
5: LL
15: LR
40: R
80: RR

delete 10
30: 
15: L
5: LL
40: R
80: RR

delete 15
30: 
5: L
40: R
80: RR

delete 10
30: 
5: L
40: R
80: RR

delete 40
30: 
5: L
80: R

delete 20
30: 
5: L
80: R

delete 80
size = 2
30: 
5: L

delete 30
size = 1
5: 

delete 5
size = 0

delete 5
size = 0
*/