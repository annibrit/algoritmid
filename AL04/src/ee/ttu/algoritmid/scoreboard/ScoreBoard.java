package ee.ttu.algoritmid.scoreboard;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class ScoreBoard {

    Participant participant;

    public ScoreBoard(Participant participant) {
        this.participant = participant;
    }
        /**
     * Adds a participant's time to the checkpoint scoreboard
     */
    public void add(Participant participant) {
    }

    TreeSet<Participant> participants = new TreeSet<Participant>(new Comparator<Participant>() {
        @Override
        public int compare(Participant o1, Participant o2) {
            if (new Integer(o1.getTime()).compareTo(new Integer(o2.getTime())) < 0)

                return -1;

            else if (new Integer(o1.getTime()).compareTo(new Integer(o2.getTime())) > 0)

                return 1;

            else return 0;
        }

    });


    //TreeSet t = new TreeSet(Comparator comp);
    //TreeSet<Participant> participantsDesc = (TreeSet<Participant>)participants.descendingSet(participant.getTime());


    /**
     * Returns top n number of participants in the checkpoint to be displayed on the scoreboard
     * This method will be queried by the tests every time a new participant is added
     */
    public List<Participant> get(int n) {
        return null;
    }
}
