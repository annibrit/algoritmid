package ee.ttu.algoritmid.dancers;

//NB! ei tohi muuta

/**
 * API specification for the objects representing various dancers.
 */
public interface Dancer {
    public enum Gender {
        MALE, FEMALE
    }

    public String getName();

    public Gender getGender();

    public int getHeight();
}