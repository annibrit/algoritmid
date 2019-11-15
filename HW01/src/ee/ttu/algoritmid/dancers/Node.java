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

    void insert(Node node) {
        if (node.dancer.getHeight() < this.dancer.getHeight()) {
            if (left != null) {
                left.insert(node);
            } else {
                this.setLeft(node);
            }
        } else {
            if (right != null) {
                this.getRight().insert(node);
            } else {
                this.setRight(node);
            }
        }
    }

    Node match(Node node) {
        if (node.dancer.getGender().equals(Dancer.Gender.MALE)) {
            // Found partner, return dancer
            if(node.dancer.getHeight() - dancer.getHeight() >= 5){
                return this;
            }
            if (dancer.getHeight() < node.dancer.getHeight()) {
                //naine on lühem kui vaja, mine paremale
                if (right != null) return right.match(node);
                else return null;
            } else {
                //naine on pikem kui vaja, mine vasakule
                if (left != null) return left.match(node);
                else return null;
            }
        } if (node.dancer.getGender().equals(Dancer.Gender.FEMALE)) {
            Dancer woman = node.dancer;
            Dancer man = dancer;
            if(woman.getHeight() - man.getHeight() <= - 5){
                return this;
            }
            if (man.getHeight() < woman.getHeight()) {
                //mees on lühem kui vaja, mine paremale
                if (right != null) return right.match(node);
                else return null;
            } else {
                //mees on pikem kui vaja, mine vasakule
                if (left != null) return left.match(node);
                else return null;
            }
        }

        return node;
    }


}
