// 207404997
package exe.ex3;

public class Ex3_4 {
    public static void main(String[] args) {
        // test cases:
        Treap treap = new Treap();
        treap.insert(50, 15);
        treap.insert(70, 10);
        treap.insert(30, 5);
        treap.insert(20, 2);
        treap.insert(40, 4);
        treap.preorderTraversePlus();
        treap.insert(10, 1);
        treap.insert(45, 20);
        treap.preorderTraversePlus();
    }
}

class Treap {
    // variables:
    private TreapNode root;
    //constructor:
    public Treap(){
        root = null;
    }

    /**
     * Complexity: O(log n). insert in BST is O(log n), possible rotation in each step - O(1).
     * uses helper function: insert new node with a given key and priority into treap:
     * @param data key for new node
     * @param priority for new node
     * @return the new node
     */
    public TreapNode insert(int data, int priority){
        // create node to insert:
        TreapNode newNode = new TreapNode(data, priority);
        // use helper function:
        root = TreapNode.insert(root, newNode);
        return newNode;
    }

    /**
     * Complexity: O(log n) - search in BST
     * search for a key in a given treap
     * uses helper function
     * @param key value to find
     * @return true if found
     */
    public boolean search(int key){
        return TreapNode.search(root, key);
    }

    /**
     * Complexity: O(n) - visits every node once
     * preorder traverse plus(root->left->right)
     * uses helper function
     */
    public void preorderTraversePlus(){
        TreapNode.preOrder(root);
        System.out.println();
    }
}

class TreapNode {
    // variables:
    private int key, priority;
    private TreapNode left, right;
    //constructor:
    public TreapNode(int key, int priority) {
        this.key = key;
        this.priority = priority;
    }

    /**
     * recursive helper function for insert.
     * @param root root node
     * @param newNode node to insert
     * @return root that had the new node inserted after it
     */
    public static TreapNode insert(TreapNode root, TreapNode newNode){
        // base case:
        if(root==null) return newNode;
        // insert as BST, left-leaning:
        if(newNode.key<=root.key){
            // insert left:
            root.left = insert(root.left, newNode);
            // check heap property and rotate if necessary
            if(root.left.priority>root.priority){
                // save middle subtree:
                TreapNode temp = root.left.right;
                TreapNode newRoot = root.left;
                // swap nodes:
                newRoot.right = root;
                root.left = temp;
                // set new root:
                root = newRoot;
            }
        }
        else{
            // insert right:
            root.right = insert(root.right, newNode);
            // check heap property and rotate if necessary
            if(root.right.priority>root.priority){
                // save middle subtree:
                TreapNode temp = root.right.left;
                TreapNode newRoot = root.right;
                // swap nodes:
                newRoot.left = root;
                root.right = temp;
                // set new root:
                root = newRoot;
            }
        }
        return root;
    }

    /**
     * Complexity: O(log n) - search in BST
     * helper function for search
     * @param node root
     * @param key value to find
     * @return true if found
     */
    public static boolean search(TreapNode node, int key){
        // base case:
        if(node==null) return false;
        // if found:
        if(key==node.key) return true;
        // search in left subtree:
        if(key<node.key) return search(node.left, key);
        // search in right subtree:
        return search(node.right, key);
    }

    /**
     * helper function for preOrder traversal
     * @param node root
     */
    public static void preOrder(TreapNode node){
        // base case:
        if(node==null) return;
        // print root:
        System.out.println(node);
        // recursive call left:
        preOrder(node.left);
        // recursive call right:
        preOrder(node.right);
    }
    public String toString(){
        return "key: "+key+", priority: "+priority;
    }
}