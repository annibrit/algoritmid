package ee.ttu.algoritmid.fibonacci.guessinggame;

public class GuessingGame {

    Oracle oracle;

    public GuessingGame(Oracle oracle) {
        this.oracle = oracle;
    }

    /**
     * @param cityArray - All the possible cities.
     * @return the name of the city.
     */
    public String play(City[] cityArray) {
        // TODO
        return "";
    }
    public static void main(String[] args) {

        //Madrid, Berlin, Yokohama, Giza, Hong Kong, New York, Tokyo, Dehli

        City[] listOfCities = new City[]{
                new City("Dehli", 16787941),
                new City("Berlin", 3671000),
                new City("Madrid", 3207247),
                new City("Hong Kong", 7298600),
                new City("New York", 8537673),
                new City("Tokyo", 13513734),
                new City("Giza", 4239988),
                new City("Yokohama", 3726167)
        };

        GuessingGame guessingGame = new GuessingGame(new Oracle(listOfCities[0])); //dehli
        System.out.println(guessingGame.play(listOfCities)); //dehli

    }
}