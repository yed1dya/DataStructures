package week3;

public class BST {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(new Node(5));
        tree.insert(new Node(1));
        tree.insert(new Node(9));
        tree.insert(new Node(2));
        tree.insert(new Node(7));
        tree.insert(new Node(3));
        tree.insert(new Node(6));
        tree.insert(new Node(4));
        tree.insert(new Node(8));
        tree.display();
        System.out.println(tree.search(0));
        System.out.println(tree.search(1));
        tree.remove(0);
        tree.remove(5);
        tree.display();
    }
    Node root;
    StringBuilder str = new StringBuilder();
    public void insert(Node node){
        root = insert(root, node);
    }
    private Node insert(Node root, Node node){
        int data = node.data;
        if(root==null){
            root=node;
            return root;
        } else if (data<root.data) {
            root.left = insert(root.left, node);
        }else {
            root.right = insert(root.right, node);
        }
        return root;
    }
    public void display(){
        display(root);
        System.out.println(str.substring(0, str.length()-2));
        str = new StringBuilder();
    }
    private void display(Node root){
        if(root!=null){
            display(root.left);
            str.append(root.data).append(", ");
            display(root.right);
        }
    }
    public boolean search(int data){
        return search(root, data);
    }
    private boolean search(Node root, int data){
        if(root==null) return false;
        else if (root.data==data) return true;
        else if(root.data>data) return search(root.left, data);
        else return search(root.right, data);
    }
    public void remove(int data){
        if(search(data)){
            remove(root, data);
        }
        else System.out.println("not found");
    }
    private Node remove(Node root, int data){
        if(root==null) return root;
        else if(data<root.data) root.left = remove(root.left, data);
        else if(data>root.data) root.right = remove(root.right, data);
        else {
            if(root.isLeaf()){
                root=null;
            }
            // need to find successor:
            else if(root.right!=null){
                root.data = successor(root);
                root.right = remove(root.right, root.data);
            }
            // need to find predecessor
            else {
                root.data = predecessor(root);
                root.left = remove(root.left, root.data);
            }
        }
        return root;
    }

    /**
     * find the smallest larger offspring
     * @param root
     * @return
     */
    private int successor(Node root){
        root = root.right;
        while (root.left!=null) root = root.left;
        return root.data;
    }

    /**
     * find greatest smaller offspring
     * @param root
     * @return
     */
    private int predecessor(Node root){
        root = root.left;
        while(root.right!=null) root = root.right;
        return root.data;
    }
}
