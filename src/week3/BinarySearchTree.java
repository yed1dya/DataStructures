package week3;

public class BinarySearchTree{
	private Node root;
	public BinarySearchTree(){
		root = null;
	}
	// copy constructor
	public BinarySearchTree(BinarySearchTree bst){
		this.root = clone(bst.root);
	}
	Node clone(final Node source){
		if (source == null) return null;
		else
			return  new Node(source.data, clone(source.left), clone(source.right));
	}
	// insert new element 
	public void insert(Integer elem) {
		Node newNode = new Node(elem);
		if (root == null){
			root = newNode;
		}
		else{
			Node n = root;
			boolean flag = true;
			while (flag){
				if (elem.compareTo(n.data) > 0){
					if (n.right != null) n = n.right;
					else{
						n.right = newNode;
						flag = false;
					}
				}
				else{
					if (n.left != null) n = n.left;
					else{
						n.left = newNode;
						flag = false;;
					}
				}
			}
		}
	}

	//remove the element from the tree
	public void remove(Integer elem) {
		root = remove(root, elem);
	}
	public static Node remove(Node node, Integer elem){
		if(node != null){
			if(elem.compareTo(node.data) > 0){
				node.right = remove(node.right,elem);
			}
			else if(elem.compareTo(node.data) < 0){
				node.left = remove(node.left,elem);
			}
			else{//the node that should be deleted is found
				if(node.left == null && node.right == null){
					node = null;
				}
				else if(node.left != null && node.right == null){//the node has only one child (left)
					node = node.left;
				}
				else if(node.right != null && node.left == null){//the node has only one child (right)
					node = node.right;
				}
				else{//node "tree" has two children
					if(node.right.left == null){// his right node has only one child (right)
						node.right.left = node.left;
						node = node.right;
					}
					else{// remove the smallest element
						Node p = node.right;
						while(p.left.left != null)
							p = p.left;
						node.data = p.left.data;
						p.left = p.left.right;
					}
				}
			}
		}
		return node;
	}
	// find element, returns true if the element is found
	public boolean search(Integer elem) {
		boolean ans = false;
		Node n = root;
		while(n != null) {
			if(elem == n.data)  ans = true; 
			else if (elem < n.data) n = n.left;
			else n = n.right;
		}
		return ans;
	}
//preorder tracerse (root->left->right)	
	public void printPreorderPlus(){
		printPreorderPlus("", root);
	}
	public void printPreorderPlus(String Path, Node node){
		if (node != null){
			System.out.println(node.data + ": " + Path);
			printPreorderPlus(Path+"L", node.left);
			printPreorderPlus(Path+"R", node.right);
		}
	}
	// if the tree is empty returns true
	public boolean isEmpty(){
		return this.root == null;
	}
	// the height of the tree
	public int height() {
		return height(root) - 1;
	}
	public int height(Node tree) {
		if (tree == null) return 0;
		return 1 + Math.max(height(tree.left), height(tree.right));
	}

}
