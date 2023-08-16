package sandbox;

public class RBT<T extends Comparable<T>> {
    private Node<T> root;
    private T data;
    private final boolean RED = true, BLACK = false;
    public RBT<T> insert(T data){
        Node<T> node = new Node<>(data);
        root = insert(root, node);
        fix(node);
        return this;
    }
    private Node<T> insert(Node<T> root, Node<T> node){
        if(root==null) return node;
        if(node.data().compareTo(root.data())<0){
            root.setLeft(insert(root.left(), node));
            root.left().setParent(root);
        }
        else if(node.data().compareTo(root.data())>0){
            root.setRight(insert(root.right(), node));
            root.right().setParent(root);
        }
        return root;
    }
    private void fix(Node<T> node) {
        Node<T> parent = node.parent();
        // if parent is black, tree is still ok because we didn't change the black depth.
        // move up until we reach the root:
        if(node!=root && parent.color()==RED){
            Node<T> grandParent = node.parent().parent();
            Node<T> uncle = parent.isLeft() ? grandParent.right() : grandParent.left();
            if(uncle!=null && uncle.color()==RED){
                // need to recolor
                recolor(parent, uncle, grandParent);
            }
            else if(parent.isLeft()){
                // need to re-balance (left-left or left-right)
                fixLeft(node, parent, grandParent);
            }
            else if(!parent.isLeft()){
                // right-right or right-left
                fixRight(node, parent, grandParent);
            }
        }
        root.setColor(BLACK);
    }
    private void recolor(Node<T> parent, Node<T> uncle, Node<T> grandParent){
        uncle.flip();
        parent.flip();
        grandParent.flip();
        fix(grandParent);
    }
    private void fixLeft(Node<T> node, Node<T> parent, Node<T> grandParent){
        if(!node.isLeft()){
            rotateLeft(parent);
        }
        parent.flip();
        grandParent.flip();
        rotateRight(grandParent);
        fix(node.isLeft() ? parent : grandParent);
    }
    private void rotateRight(Node<T> node) {
        Node<T> left = node.left();
        node.setLeft(left.right());
        if(node.left()!=null) node.left().setParent(node);
        left.setRight(node);
        left.setParent(node.parent());
        update(node, left);
        node.setParent(left);
    }
    private void rotateLeft(Node<T> node) {
        Node<T> right = node.right();
        node.setRight(right.left());
        if(node.right()!=null) node.right().setParent(node);
        right.setLeft(node);
        right.setParent(node.parent());
        update(node, right);
        node.setParent(right);
    }
    private void update(Node<T> node, Node<T> temp){
        if(node.parent()==null) root = temp;
        else if(node.isLeft()) node.parent().setLeft(temp);
        else node.parent().setRight(temp);
    }
    private void fixRight(Node<T> node, Node<T> parent, Node<T> grandParent){
        if(node.isLeft()){
            rotateRight(parent);
        }
        parent.flip();
        grandParent.flip();
        rotateLeft(grandParent);
        fix(node.isLeft() ? grandParent : parent);
    }
}
