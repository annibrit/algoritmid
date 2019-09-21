package ee.ttu.algoritmid.guessinggame;

import java.util.Arrays;
import java.util.List;

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

        List<City> cities = Arrays.asList(cityArray);
        cities.sort((city1, city2) -> city1.getPopulation() - city2.getPopulation());

        String correctCity = "";

        while (correctCity.length() == 0) {

            //int middleValue = (cities.size()/2) + (cities.size() % 2);
            int middleValue = ((cities.size()+1)/2)-1;

            String answer = this.oracle.isIt(cities.get(middleValue));
            if (answer == "correct!" || cities.size()==1) {
                correctCity = cities.get(middleValue).getName();
            } else if (answer == "higher population") {
                cities = cities.subList(middleValue, cities.size());
            } else if (answer == "lower population") {
                cities = cities.subList(0, middleValue);
            }
        }

        return correctCity;
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
        GuessingGame guessingGame = new GuessingGame(new Oracle(listOfCities[4])); //dehli
        System.out.println(guessingGame.play(listOfCities)); //dehli

    }
}