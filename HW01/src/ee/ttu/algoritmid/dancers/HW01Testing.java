package ee.ttu.algoritmid.dancers;

import java.util.ArrayList;
import java.util.List;

import static ee.ttu.algoritmid.dancers.Dancer.Gender.MALE;
import static ee.ttu.algoritmid.dancers.Dancer.Gender.FEMALE;


public class HW01Testing {

    public static void main(String[] args) {
        //testFemaleTreeEndToEndPublic();
        testMaleTreeEndToEndPublic();
    }

    public static void testMaleTreeEndToEndPublic() {
        List<Dancer> requests = new ArrayList<>();
        List<Integer> responds = new ArrayList<>();

        requests.add(new DancerImplementation("M", MALE, 150));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 130));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 135));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 149));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 200));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 170));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 160));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 133));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 125));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 190));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 140));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 195));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 148));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 210));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 138));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 205));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 165));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 163));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 168));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 145));
        responds.add(150);

        requests.add(new DancerImplementation("F-tahaks 140 saada", FEMALE, 134));
        responds.add(140);

        requests.add(new DancerImplementation("F-tahaks 165 saada", FEMALE, 159));
        responds.add(165);

        requests.add(new DancerImplementation("F-tahaks 148 saada", FEMALE, 140));
        responds.add(148);

        requests.add(new DancerImplementation("F-tahaks 163 saada", FEMALE, 156));
        responds.add(163);

        requests.add(new DancerImplementation("M", MALE, 169));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 139));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 180));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 134));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 164));
        responds.add(169);

        requests.add(new DancerImplementation("F", FEMALE, 134));
        responds.add(139);

        requests.add(new DancerImplementation("F", FEMALE, 129));
        responds.add(134);

        requests.add(new DancerImplementation("F", FEMALE, 175));
        responds.add(180);

        testTreeEndToEnd(requests, responds);


/*
        requests.add(new DancerImplementation("M", MALE, 169));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 139));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 180));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 134));
        responds.add(null);


        requests.add(new DancerImplementation("F", FEMALE, 164));
        responds.add(169);

        requests.add(new DancerImplementation("F", FEMALE, 134));
        responds.add(139);

        requests.add(new DancerImplementation("F", FEMALE, 129));
        responds.add(134);

        requests.add(new DancerImplementation("F", FEMALE, 175));
        responds.add(180);

        requests.add(new DancerImplementation("F", FEMALE, 129));
        responds.add(134); */

        testTreeEndToEnd(requests, responds);/*
    }
        public static void testFemaleTreeEndToEndPublic() {
        List<Dancer> requests = new ArrayList<>();
        List<Integer> responds = new ArrayList<>();

        requests.add(new DancerImplementation("F", FEMALE, 110));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 90));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 95));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 109));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 160));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 130));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 120));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 93));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 85));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 150));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 100));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 155));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 108));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 170));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 98));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 165));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 125));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 123));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 128));
        responds.add(null);


        requests.add(new DancerImplementation("M", MALE, 115));
        responds.add(110);

        requests.add(new DancerImplementation("M", MALE, 107));
        responds.add(100);

        requests.add(new DancerImplementation("M", MALE, 132));
        responds.add(125);

        requests.add(new DancerImplementation("M", MALE, 113));
        responds.add(108);

        requests.add(new DancerImplementation("M", MALE, 130));
        responds.add(123);

        requests.add(new DancerImplementation("F", FEMALE, 129));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 99));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 140));
        responds.add(null);

        requests.add(new DancerImplementation("F", FEMALE, 94));
        responds.add(null);

        requests.add(new DancerImplementation("M", MALE, 134));
        responds.add(129);

        requests.add(new DancerImplementation("M", MALE, 106));
        responds.add(99);

        requests.add(new DancerImplementation("M", MALE, 99));
        responds.add(94);

        requests.add(new DancerImplementation("M", MALE, 147));
        responds.add(140);

        testTreeEndToEnd(requests, responds);*/
    }
    private static void testTreeEndToEnd(List<Dancer> requests, List<Integer> responds) {
        HW01 solution = new HW01();

        for (int i = 0; i < requests.size(); i++) {
            testRequestResponse(solution, requests.get(i), responds.get(i));
        }

        System.out.println(solution.returnWaitingList());
    }


    private static void testRequestResponse(HW01 solution, Dancer dancer, Integer expectedPartnerHeight) {

        DancingCouple couple = solution.findPartnerFor(dancer);

        System.out.println("This is the printed out couple:"+couple);

        System.out.println("This is the printed out waiting list:"+solution.returnWaitingList());

        if (couple == null) {
            if (expectedPartnerHeight != null) {
                fail("Partner wasn't found, but should have", null, expectedPartnerHeight);
            }
        } else {
            Dancer partner = dancer.getGender() == MALE ? couple.getFemaleDancer() : couple.getMaleDancer();

            if (expectedPartnerHeight == null) {
                fail("Partner was found, but shouldn't have", partner.getHeight(), null);
            } else {

                if (partner.getHeight() != expectedPartnerHeight) {
                    fail("Partner of wrong height found", partner.getHeight(), expectedPartnerHeight);
                }
            }
        }
    }

    private static void fail(String errorMessage, Integer foundPartnerHeight, Integer expectedPartnerHeight) {
        System.err.println(errorMessage + ": found partner height=" + foundPartnerHeight + " expected partner height=" + expectedPartnerHeight);
    }

    //kustuta juurtipp
    //pane sisse juur ja laps, proovi ikka juurtippu kustutada
    //pane sisse veel lapsi jne

    //testi nii et juurtipp on 75
    // nii et vasak laps on parima pikkusega
    // nii et parem laps on parima pikkusega

}
