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

    /*Node closestValue(Node n, int target) {
        return this.root.closestValue(n,target);
    }*/

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
        root = delete(root, tn);
    }





    private Node delete(Node rootnode, Node targetnode) {

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

/*
    public void delete(int id) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while (current.data != id) {
            parent = current;
            if (current.data > id) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        //if i am here that means we have found the node
        //Case 1: if node to be deleted has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        //Case 2 : if node to be deleted has only one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.left != null && current.right != null) {

            //now we have found the minimum element in the right sub tree
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public Node getChild(Node deleteNode) {
        Node child = null;
        Node childParent = null;
        Node current = deleteNode.right;
        while (current != null) {
            childParent = child;
            child = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
//		childParent
        if (child != deleteNode.right) {
            childParent.left = child.right;
        if (root != null) {
        child.right = deleteNode.right;
        }
        return child;
    }


    public static void main(String arg[]) {
        DancerTree b = new DancerTree();
        b.insert(3);
        b.insert(8);
        b.insert(1);
        b.insert(4);
        b.insert(6);
        b.insert(2);
        b.insert(10);
        b.insert(9);
        b.insert(20);
        b.insert(25);
        b.insert(15);
        b.insert(16);
        System.out.println("Original Tree : ");
        b.display(b.root);
        System.out.println("");
        System.out.println("Check whether Node with value 4 exists : " + b.find(4));
        System.out.println("Delete Node with no children (2) : " + b.delete(2));
        b.display(root);
        System.out.println("\n Delete Node with one child (4) : " + b.delete(4));
        b.display(root);
        System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));
        b.display(root);
    } */

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


