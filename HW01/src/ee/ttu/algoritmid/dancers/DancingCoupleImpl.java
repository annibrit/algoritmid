package ee.ttu.algoritmid.dancers;

public class DancingCoupleImpl implements DancingCouple {

    Dancer femaleDancer;
    Dancer maleDancer;

    public DancingCoupleImpl(Dancer femaleDancer, Dancer maleDancer) {

        this.femaleDancer = femaleDancer;
        this.maleDancer = maleDancer;
    }

    @Override
    public Dancer getMaleDancer() {
        return maleDancer;
    }

    @Override
    public Dancer getFemaleDancer() {
        return femaleDancer;
    }
}
