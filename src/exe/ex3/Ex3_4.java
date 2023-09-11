// 207404997, 325168870
package exe.ex3;

/**
 * @author 207404997, 325168870
 */
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
        System.out.println(treap.search(10));
        System.out.println(treap.search(0));
    }
}

class Treap {
    // variables:
    public TreapNode root;
    //constructor:
    public Treap(){
        root = null;
    }

    /**
     * Inserts a new node with a given key and priority into treap.
     * Complexity: O(log n) average case/O(n) worst case.
     * insert in BST is O(log n) in the average case, and O(n) in the worst case.
     * in addition, this function will possibly add a rotation in each step.
     * the rotation has no loops and no recursion, so each rotation is O(1).
     * uses helper function.
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
     * Search for a key in a given treap.
     * Complexity: same as standard search in BST.
     * O(log n) in the average case, O(n) in the worst case.
     * uses helper function.
     * @param key value to find
     * @return true if found
     */
    public boolean search(int key){
        return TreapNode.search(root, key);
    }

    /**
     * Preorder traverse plus(root->left->right).
     * Complexity: O(n) - visits every node once.
     * uses helper function.
     */
    public void preorderTraversePlus(){
        TreapNode.preOrder(root);
        System.out.println();
    }
}

class TreapNode {
    // variables:
    private int key, priority;
    TreapNode left;
    TreapNode right;
    //constructor:
    public TreapNode(int key, int priority) {
        this.key = key;
        this.priority = priority;
    }

    /**
     * Recursive helper function for insert.
     * Complexity: O(log n) or O(n), as explained above.
     * @param root root node
     * @param newNode node to insert
     * @return the updated root
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
     * Recursive helper function for search.
     * Complexity: O(log n) or O(n), as explained above.
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
     * Recursive helper function for preOrder traversal.
     * Complexity: O(n), as explained above.
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

    /**
     * Standard toString method.
     * Complexity: O(1).
     * @return String representing a node.
     */
    public String toString(){
        return "key: "+key+", priority: "+priority;
    }
}