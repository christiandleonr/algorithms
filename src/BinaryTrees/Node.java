package BinaryTrees;

public class Node {
    private Node left;
    private Node right;
    private Object value;

    public Node() {

    }

    public Node(Object value) {
        this.value = value;
    }

    public Node(Node left, Node right, Object value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
