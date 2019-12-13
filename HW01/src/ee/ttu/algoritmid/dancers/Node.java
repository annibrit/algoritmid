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
/*
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
    } */

    Node match(Node node) {

        if (node.dancer.getGender().equals(Dancer.Gender.MALE)) {

            Dancer man = node.dancer;
            Dancer woman = dancer;
            int perfectH = man.getHeight() - 5;

            Node currentClosest = null;
            Node closestNode = findClosestElement(this, perfectH, currentClosest);

            return closestNode;


       // return closestValue(this, perfectH);

        }

        else{
            Dancer woman = node.dancer;
            Dancer man = dancer;
            int perfectH = woman.getHeight() + 5;

        //return closestValue(this, perfectH);

            Node currentClosest = null;
            Node closestNode = findClosestElement(this, perfectH, currentClosest);

            return closestNode;


    }

}
            /*

            vana matchi meetod, mis ei leidnud kõige lähedasema väärtusega pikkust, vaid esimese mis sobis


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

            }
            else {

                //mees on pikem kui vaja, mine vasakule
                if (left != null) return left.match(node);
                else return null;

            }
        }

        return node;
    }

public Node closestValue(Node root, double target) {
    double min=Double.MAX_VALUE;
    Node result = null;
    Node traversingNode = root;

    while(traversingNode!=null){

        if(target>traversingNode.dancer.getHeight()){

            double diff = Math.abs(traversingNode.dancer.getHeight()-target);
            if(diff<min){
                min = Math.min(min, diff);
                result = traversingNode;
            }
            traversingNode = traversingNode.right;

        }else if(target<traversingNode.dancer.getHeight()){

            double diff = Math.abs(traversingNode.dancer.getHeight()-target);
            if(diff<min){
                min = Math.min(min, diff);
                result = traversingNode;
            }
            traversingNode = traversingNode.left;

        }
    }

    return result;
}


            double min = Double.MAX_VALUE;
            Node foundNode;


    public Node closestValue(Node root, int target) {

            helper(root, target);
            return foundNode;
        }

        public void helper(Node root, int target){

            //Node foundNode = null;
            Node traversingNode = root;

            if(traversingNode==null)
                return;

            if(Math.abs(traversingNode.dancer.getHeight() - target) < min){
                min = Math.abs(traversingNode.dancer.getHeight()-target);
                foundNode = traversingNode;
            }

            if(target < traversingNode.dancer.getHeight()){
                helper(traversingNode.left, target);
            }else
                helper(traversingNode.right, target);
            }
        }*/


       Node findClosestElement(Node node, int target, Node currentClosest) {

           //kui puu node on tühi
           //if (node == null) return currentClosest;
           while(node!=null) {

           if (node.dancer.getGender()== Dancer.Gender.FEMALE){

               //otsides naispuust on ideaalne pikkus on target või lühem
               if(node.dancer.getHeight() == target) return node;

               if (node.dancer.getHeight()< target) {
                   if(currentClosest == null){
                   currentClosest = node;
               }
               int currentDiff = currentClosest.dancer.getHeight() - target;
               int traversingNodeDiff = node.dancer.getHeight() - target;

                if(
                        (currentClosest != null) &&
                        (traversingNodeDiff < currentDiff) &&
                        (currentDiff <= 0)&&
                        traversingNodeDiff <= 0) {
                    currentClosest = node;
                }

               }
                if(node.dancer.getHeight()>target) {
                    return findClosestElement(node.left, target, currentClosest);
                }
                else { //target > node.data
                    return findClosestElement(node.right, target, currentClosest);
                }
        }

        if (node.dancer.getGender() == Dancer.Gender.MALE){

            if (node.dancer.getHeight() == target) return node;

            if (node.dancer.getHeight()> target){

               // ideaalne pikkus on target või pikem
                    if(currentClosest == null){
                        currentClosest = node;
                    }

                    int currentDiff = currentClosest.dancer.getHeight() - target;
                    int traversingNodeDiff = node.dancer.getHeight() - target;

                    if(
                            (currentClosest != null) &&
                            (traversingNodeDiff < currentDiff) &&
                            (currentDiff >= 0)&&
                            traversingNodeDiff >= 0) {
                                currentClosest = node;
                            }
               }

            if (node.dancer.getHeight()< target){
                return findClosestElement(node.right, target, currentClosest);
            }

            else if(target < node.dancer.getHeight()) {
                return findClosestElement(node.left, target, currentClosest);
            }
        }}

           return currentClosest;
       }

    /*

    public Node findNode(Node root, int perfectH) {

        int min=Integer.MAX_VALUE;
        Node foundNode = null;
        Node traversingNode = root;

        if (traversingNode.dancer.getHeight()== perfectH) {
            foundNode = traversingNode;
            return foundNode;
        }

        if (perfectH < traversingNode.dancer.getHeight() && null != traversingNode.left) {

            findNode(traversingNode.left, perfectH);
        }

        else if (perfectH > traversingNode.dancer.getHeight() && null != traversingNode.right) {

            findNode(traversingNode, perfectH);
        }

        return foundNode;

    }*/

    }





