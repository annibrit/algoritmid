package ee.ttu.algoritmid.popularity;

import java.awt.*;
import java.util.Collections;
import java.util.HashMap;

public class Popularity {

    public Popularity(int maxCoordinates) {
    }

    HashMap<Integer,Point> h = new HashMap<Integer,Point>();
    private int sequence = 0;
    /**
     * @param x, y - coordinates
     */
    void addPoint(Integer x, Integer y) {

        Point coordinates = new Point(x, y);
        h.put(sequence,coordinates);
        sequence++;
    }

    /**
     * @param x, y - coordinates
     * @return the number of occurrences of the point
     */
    int pointPopularity(Integer x,Integer y) {

        Point coordinatesInQuestion = new Point(x, y);
        //int count = Collections.frequency(new ArrayList<Point>(h.values()), coordinatesInQuestion);

        int count = 0;

        for(Point value: h.values()) {
            if (value.equals(coordinatesInQuestion)) {
                count++;
            }
        }

        return count;

    }

    /**
     * @return the number of occurrennces of the most popular point
     */


    int maxPopularity() {

        //tee array kõikidest pointidest nende countidega

    //int mostPopularpoint = Collections.max((paned siia selle array sisse));
    //return mostPopularpoint;


        HashMap<Point, Integer> counts = new HashMap<Point, Integer>();
        for (Point c : h.values()) {
            int value = counts.get(c) == null ? 0 : counts.get(c);
            counts.put(c, value + 1);
        }

        return Collections.max(counts.values());
    }

}