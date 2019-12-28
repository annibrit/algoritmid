package ee.ttu.algoritmid.dancers;

public class Node {

    Dancer dancer;
    Node left;
    Node right;

    public Node(Dancer dancer) {
        this.dancer = dancer;
        left = null;
        right = null;
    }
    void setLeft(Node left) {
        this.left = left;
    }
    Node getLeft() {
        return left;
    }

    void setRight(Node right) {
        this.right = right;
    }

    Node getRight() {
        return right;
    }

}





