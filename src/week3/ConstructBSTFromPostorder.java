package week3;
/* A binary tree node has data, pointer to left child
 and a pointer to right child */
class CNode {
    int data;
    CNode left, right;
    CNode(int data) {
        this.data = data;
        left = right = null;
    }
}
// Class containing variable that keeps a track of overall
// calculated postIndex
class Index {
    int postIndex = 0;
}

public class ConstructBSTFromPostorder {
    /* A O(n) program for construction of BST from
        postorder traversal */
       // A recursive function to construct BST from post[].
        // postIndex is used to keep track of index in post[].
        CNode constructTreeUtil(int post[], Index postIndex,
                               int key, int min, int max, int size) {
            // Base case
            if (postIndex.postIndex < 0)
                return null;
            CNode root = null;
            // If current element of post[] is in range, then
            // only it is part of current subtree
            if (key > min && key < max) {
                // Allocate memory for root of this subtree and decrement
                // *postIndex
                root = new CNode(key);
                postIndex.postIndex = postIndex.postIndex - 1;
                if (postIndex.postIndex >= 0) {
                    // All nodes which are in range {key..max} will go in
                    // right subtree, and first such node will be root of right
                    // subtree
                    root.right = constructTreeUtil(post, postIndex,
                            post[postIndex.postIndex],key, max, size);
                    // Construct the subtree under root
                    // All nodes which are in range {min .. key} will go in left
                    // subtree, and first such node will be root of left subtree.
                    root.left = constructTreeUtil(post, postIndex,
                            post[postIndex.postIndex],min, key, size);
                }
            }
            return root;
        }

        // The main function to construct BST from given postorder
        // traversal. This function mainly uses constructTreeUtil()
        CNode constructTree(int post[], int size) {
            Index index = new Index();
            index.postIndex = size - 1;
            return constructTreeUtil(post, index, post[index.postIndex],
                    Integer.MIN_VALUE, Integer.MAX_VALUE, size);
        }

        // A utility function to print inorder traversal of a Binary Tree
        void printInorder(CNode node) {
            if (node == null)
                return;
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }

        // Driver program to test above functions
        public static void main(String[] args) {
            ConstructBSTFromPostorder tree = new ConstructBSTFromPostorder();
            int []post = new int[]{1, 7, 5, 50, 40, 10};
            int size = post.length;

            CNode root = tree.constructTree(post, size);

            System.out.println("Inorder traversal of the constructed tree:");
            tree.printInorder(root);
        }
    }

// This code has been contributed by Mayank Jaiswal


