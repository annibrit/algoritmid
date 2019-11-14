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
}
