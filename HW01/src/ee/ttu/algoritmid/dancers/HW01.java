package ee.ttu.algoritmid.dancers;

import java.util.ArrayList;
import java.util.List;

import static ee.ttu.algoritmid.dancers.Dancer.Gender.FEMALE;
public class HW01 implements Dancers {

    public DancerTree FemaleTree;
    public DancerTree MaleTree;
    public static Node root;

    @Override
    public DancingCouple findPartnerFor(Dancer candidate) throws IllegalArgumentException {

        if (candidate.getGender().equals(FEMALE)){

            //otsi sobivat partnerit MaleTree-s
            //MaleTree.findPartnerFor(candidate)???
            //kui ei leia, lisa FemaleTree-sse
            new DancingCoupleImpl(candidate, findClosest(candidate));
            FemaleTree.insert(candidate);
        }

        else
            //otsi sobivat partnerit FemaleTree-s
            //FemaleTree.findPartnerFor(candidate)????
            //kui ei leia, lisa MaleTree-sse
            new DancingCoupleImpl(findClosest(candidate), candidate);
            MaleTree.insert(candidate);
        return null;
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
    }

        @Override
    public List<Dancer> returnWaitingList() {

            List<Dancer> resultList = new ArrayList<>();
            if (FemaleTree != null) resultList.addAll(FemaleTree.getMembers());
            if (MaleTree != null) resultList.addAll(MaleTree.getMembers());

            return resultList;
    }
}