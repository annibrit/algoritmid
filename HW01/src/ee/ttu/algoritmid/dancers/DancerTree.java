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
        return this.root.match(new Node(d));
    }

    Node findClosestElement(Node n, int perfectH, Node m ){
        return this.root.findClosestElement(n,perfectH,m);
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
        deleteNodeIteratively (root, tn);
    }

    /*private Node delete(Node rootnode, Node targetnode) {

        // kindlasti mitterekursiivselt!!!

        if (rootnode == null) {
            return null;
        }

        if (rootnode == targetnode) {
            // n is the node to be removed
            if (rootnode.getLeft() == null && rootnode.getRight() == null) {
                return null;
            }
            if (rootnode.getLeft() == null) {
                return rootnode.getRight();
            }
            if (rootnode.getRight() == null) {
                return rootnode.getLeft();
            }

            // if we get here, then n has 2 children
            Node smallest = getLastOnTheLeft(rootnode.getRight());
            //n.setKey(smallest.getKey());
            rootnode.setRight(delete(rootnode.getRight(), smallest));
            return rootnode;
        }

        else if (targetnode.dancer.getHeight() < rootnode.dancer.getHeight()) {
            rootnode.setLeft( delete(rootnode.getLeft(), targetnode) );
            return rootnode;
        }

        else {
            rootnode.setRight( delete(rootnode.getRight(), targetnode) );
            return rootnode;
        }
    }

    private Node getLastOnTheLeft(Node start) {
        Node candidate = null;
        Node parent = null;
        Node node = start;

        while (node != null) {
            if ( node.getLeft() != null ) {
                parent = node;
                candidate = node.getLeft();
            }

            node = node.getLeft();
        }

        if (parent != null) {
            parent.setLeft(null);
        }

        return candidate;
    }
*/
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
    
    public static void deleteNodeIteratively(Node root, Node targetnode) {
        Node parent = null, current = root;
        boolean hasLeft = false;

        if (root == null)
            return;

        while (current != null) {
            if (current == targetnode) {
                break;
            }

            parent = current;
            if (targetnode.dancer.getHeight() < current.dancer.getHeight()) {
                hasLeft = true;
                current = current.left;
            } else {
                hasLeft = false;
                current = current.right;
            }
        }


        if (parent == null) {
            return;
        }

        if (hasLeft) {
            parent.left = deleteNodeIteratively(current);
        } else {
            parent.right = deleteNodeIteratively(current);
        }

        //return root;
    }

    private static Node deleteNodeIteratively(Node node) {

        if (node != null) {
            if (node.left == null && node.right == null) {
                return null;
            }

            if (node.left != null && node.right != null) {
                Node inOrderSuccessor = deleteInOrderSuccessorDuplicate(node);
                node.dancer = inOrderSuccessor.dancer;
            } else if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return node;
    }

    private static Node deleteInOrderSuccessorDuplicate(Node node) {
        Node parent = node;
        node = node.right;
        boolean rightChild = node.left == null;

        while (node.left != null) {
            parent = node;
            node = node.left;
        }

        if (rightChild) {
            parent.right = node.right;
        } else {
            parent.left = node.right;
        }

        node.right = null;
        return node;
    }


}


