package ee.ttu.algoritmid.dancers;

import java.util.ArrayList;
import java.util.List;

public class DancerTree  {

    private Node root;
    //private List<Dancer> members = new ArrayList<>();

    public DancerTree() {
        this.root = null;
    }

    DancerTree(Node node) {
        this.root = node;
    }

    Node getRoot() {
        return root;
    }


    Node match(Dancer d) {
        if (root == null) {
            return null;
        }
        Node currentNode = root, matchNode = null;
        int minimumValue = d.getHeight() + 5;
        while (currentNode != null) {
            if (currentNode.dancer.getHeight() < minimumValue) {
                currentNode = currentNode.getRight();
            } else if (currentNode.dancer.getHeight() == minimumValue) {
                matchNode = currentNode;
                break;
            } else {
               matchNode = currentNode;
               currentNode = currentNode.getLeft();
            }
        }
        return matchNode;
    }

    Node invertMatch(Dancer d) {
        if (root == null) {
            return null;
        }
        Node currentNode = root, matchedNode = null;
        int maximumValue = d.getHeight() - 5;
        while (currentNode != null) {
            if (currentNode.dancer.getHeight() > maximumValue) {
                currentNode = currentNode.getLeft();
            } else if (currentNode.dancer.getHeight() == maximumValue) {
                matchedNode = currentNode;
                break;
            } else {
                matchedNode = currentNode;
                currentNode = currentNode.getRight();
            }
        }
        return matchedNode;
    }

    public void insert(Dancer dancer) {

        Node newNode = new Node(dancer);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;

        while (true) {
            parent = current;
            if (dancer.getHeight() < current.dancer.getHeight()) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    void delete(Node tn) {
        root = deleteRecursively(root, tn);
    }

    private Node deleteRecursively(Node currentNode, Node target) {
        if (currentNode == null) {
            return null;
        } else if (currentNode == target){
            if (currentNode.getLeft() != null && currentNode.getRight() != null) {
                Node successorNode = getMinimumNode(currentNode.getRight());
                currentNode.dancer = successorNode.dancer;
                deleteRecursively(currentNode.getRight(), successorNode);
            } else if(currentNode.getLeft() != null) {
                currentNode = currentNode.getLeft();
            } else if (currentNode.getRight() != null) {
                currentNode = currentNode.getRight();
            } else {
                currentNode = null;
            }
        } else if (currentNode.dancer.getHeight() > target.dancer.getHeight()) {
            currentNode.left = deleteRecursively(currentNode.getLeft(), target);
        } else if(currentNode.dancer.getHeight() <= target.dancer.getHeight()) {
            currentNode.right = deleteRecursively(currentNode.getRight(), target);
        }
        return currentNode;
    }

    private Node getMinimumNode(Node node) {
        Node currentNode = node;
        while (currentNode.getLeft() != null) {
            currentNode = currentNode.getLeft();
        }
        return currentNode;
    }

    List<Dancer> getMembers() {
        List<Dancer> members = new ArrayList<>();
        preOrderTraversal(root, members);
        return members;
    }

    private void preOrderTraversal(Node root, List<Dancer> members){
        if (root == null) {
            return;
        }
        members.add(root.dancer);
        preOrderTraversal(root.left, members);
        preOrderTraversal(root.right, members);
    }
}


