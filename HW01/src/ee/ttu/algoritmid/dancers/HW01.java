package ee.ttu.algoritmid.dancers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static ee.ttu.algoritmid.dancers.Dancer.Gender.FEMALE;

public class HW01 implements Dancers {

    public DancerTree FemaleTree;
    public DancerTree MaleTree;


    public void createTree(Node n) {
        if (n.dancer.getGender().equals(Dancer.Gender.MALE)) {
            this.MaleTree = new DancerTree(n);
        } else {
            this.FemaleTree = new DancerTree(n);
        }
    }

    @Override
    public DancingCouple findPartnerFor(Dancer candidate) throws IllegalArgumentException {

        if (candidate == null) throw new IllegalArgumentException();
        if (candidate.getGender().equals(Dancer.Gender.MALE)) {
            if (this.FemaleTree != null) {
                // If no match, add to opposite tree
                Node match = this.FemaleTree.match(candidate);
                if (match != null) {
                    // Remove node from tree
                    //this.FemaleTree.delete(match);
                    return new DancingCoupleImpl(match.dancer, candidate);
                } else {
                    if (this.MaleTree != null) {
                        this.MaleTree.getRoot().insert(new Node(candidate));
                    } else {
                        this.createTree(new Node(candidate));
                    }
                }
            } else {
                if (this.MaleTree != null) {
                    this.MaleTree.getRoot().insert(new Node(candidate));
                } else {
                    this.createTree(new Node(candidate));
                }
            }
        } else {
            if (this.MaleTree != null) {
                // If no match, add to opposite tree
                Node match = this.MaleTree.match(candidate);
                if (match != null) {
                    //this.MaleTree.delete(match);
                    return new DancingCoupleImpl(candidate, match.dancer);
                } else {
                    if (this.FemaleTree != null) {
                        this.FemaleTree.getRoot().insert(new Node(candidate));
                    } else {
                        this.createTree(new Node(candidate));
                    }
                }
            } else {
                if (this.FemaleTree != null) {
                    this.FemaleTree.getRoot().insert(new Node(candidate));
                } else {
                    this.createTree(new Node(candidate));
                }
            }
        }
        return null;
    }
        /*if (candidate.getGender().equals(FEMALE)){

            //otsi sobivat partnerit MaleTree-s
            //MaleTree.findPartnerFor(candidate)???
            //kui ei leia, lisa FemaleTree-sse
            if (findClosest(candidate) == null) {
                FemaleTree.insert(candidate);
            }
            return new DancingCoupleImpl(candidate, findClosest(candidate));

        }

        else
            //otsi sobivat partnerit FemaleTree-s
            //FemaleTree.findPartnerFor(candidate)????
            //kui ei leia, lisa MaleTree-sse
            if (findClosest(candidate) == null) {
                MaleTree.insert(candidate);
            }
            return new DancingCoupleImpl(findClosest(candidate), candidate);
        }

  public Dancer findClosest(Dancer dancer) {

        if (dancer.getGender().equals(FEMALE)) {

            Node current = MaleTree.root;

            int perfectH = dancer.getHeight() + 5;

            if (root == null) return null;

            int currentValue = current.dancer.getHeight();

            if (currentValue == perfectH) return current.dancer;

            if (currentValue > perfectH) {
                if (current.left == null) return current.dancer;

                //Find closest on left subtree
                int closest = findClosest(current.left.dancer).getHeight();
                if (Math.abs(closest - perfectH) > Math.abs(currentValue - perfectH)) {
                    return current.dancer;
                }
                return current.left.dancer;

            } else {
                if (current.right == null) return current.dancer;

                //Find closest on right subtree
                int closest = findClosest(current.right.dancer).getHeight();
                if (Math.abs(closest - perfectH) > Math.abs(currentValue - perfectH)) {
                    return current.dancer;
                }
                return current.left.dancer;
            }

        }

        else
        {
            Node current = FemaleTree.root;

            int perfectH = dancer.getHeight() - 5;

            if (root == null) return null;

            int currentValue = current.dancer.getHeight();

            if (currentValue == perfectH) return current.dancer;

            if (currentValue > perfectH) {
                if (current.left == null) return current.dancer;

                //Find closest on left subtree
                int closest = findClosest(current.left.dancer).getHeight();
                if (Math.abs(closest - perfectH) > Math.abs(currentValue - perfectH)) {
                    return current.dancer;
                }
                return current.left.dancer;

            } else {
                if (current.right == null) return current.dancer;

                //Find closest on right subtree
                int closest = findClosest(current.right.dancer).getHeight();
                if (Math.abs(closest - perfectH) > Math.abs(currentValue - perfectH)) {
                    return current.dancer;
                }
                return current.left.dancer;
            }
        }
    }

    public static int Min_Diff(DancerTree t, int v){

        Node current = root;
        if(t==null){
            return Integer.MAX_VALUE;
        }

        if (current.dancer.getHeight()<v){
            return smallDiff(current.dancer.getHeight()-v, Min_Diff(t.right, v));
        }
        else return smallDiff(current.dancer.getHeight()-v, Min_Diff(t.left, v));
    }

    private static int smallDiff(int a, int b){
        if(Math.abs(a)>Math.abs(b)){
            return b;
        }
        return a;
    }*/


    @Override
    public List<Dancer> returnWaitingList() {

        List<Dancer> resultList = new ArrayList<>();
        List<Dancer> maleList = new ArrayList<>();
        //List<Dancer> femaleList = new ArrayList<>();

        //if (FemaleTree != null) femaleList.addAll(FemaleTree.getMembers());
        if (MaleTree != null) maleList.addAll(MaleTree.getMembers());

        resultList.addAll(maleList);
        //resultList.addAll(femaleList);

        resultList.sort(new Comparator<Dancer>() {
            @Override
            public int compare(Dancer o1, Dancer o2) {
                if (o1.getHeight() > o2.getHeight())
                    return 1;
                if (o1.getHeight() < o2.getHeight())
                    return -1;
                if (o1.getHeight() == o2.getHeight()) {
                    if (o1.getGender() == FEMALE) return 0;
                    else return 1;
                }
                return 0;
            }

        });

        return resultList;
    }
}