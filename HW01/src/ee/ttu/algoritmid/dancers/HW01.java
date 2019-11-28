package ee.ttu.algoritmid.dancers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static ee.ttu.algoritmid.dancers.Dancer.Gender.FEMALE;
import static ee.ttu.algoritmid.dancers.Dancer.Gender.MALE;

public class HW01 implements Dancers {

    public DancerTree FemaleTree = new DancerTree();
    public DancerTree MaleTree = new DancerTree();



    /*public void createTree(Node n) {
        if (n.dancer.getGender().equals(Dancer.Gender.MALE)) {
            this.MaleTree = new DancerTree(n);
        } else {
            this.FemaleTree = new DancerTree(n);
        }
    }*/

    @Override
    public DancingCouple findPartnerFor(Dancer candidate) throws IllegalArgumentException {

        if (candidate == null) throw new IllegalArgumentException();
        if (candidate.getGender().equals(MALE)) {
            {
                // If no match, add to opposite tree
                Node match = this.FemaleTree.match(candidate);
                if (match != null) {
                    // Remove node from tree
                    this.FemaleTree.delete(match);
                    return new DancingCoupleImpl(match.dancer, candidate);
                } else {
                        this.MaleTree.insert(candidate);
                }

            }
        } else {
             {
                // If no match, add to opposite tree
                Node match = this.MaleTree.match(candidate);
                if (match != null) {
                    this.MaleTree.delete(match);
                    return new DancingCoupleImpl(candidate,match.dancer);
                } else {
                    {
                        this.FemaleTree.insert(candidate);
                    }
                }

            }
        }
        return null;
    }
        /*
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

        resultList.addAll(FemaleTree.getMembers());
        resultList.addAll(MaleTree.getMembers());

        resultList.sort(new Comparator<Dancer>() {
            @Override
            public int compare(Dancer o1, Dancer o2) {
                if (o1.getHeight() > o2.getHeight())
                    return 1;
                if (o1.getHeight() < o2.getHeight())
                    return -1;
                if (o1.getHeight() == o2.getHeight()) {
                    if (o1.getGender() == MALE && o2.getGender() == FEMALE) return -1;
                    else return 0;
                }
                return 0;
            }

        });

        return resultList;
    }
}