package lib.models;

public class Node {

    private Integer weight;
    private Node left;
    private Node right;

    public Node(Integer weight, Node left, Node right) {
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    public Node(Integer weight) {
        this(weight, null, null);
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
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
}
