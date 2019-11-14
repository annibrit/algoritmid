package ee.ttu.algoritmid.dancers;

public class DancerImpl implements Dancer {

    String name;
    Gender gender;
    int height;

    public DancerImpl(String name, Gender gender, int height) {
        this.name = name;
        this.gender = gender;
        this.height = height;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
