package nl.hva.ict.se.ads;

import java.util.*;

/**
 * Holds the name, archer-id and the points scored for 30 arrows.
 * <p>
 * Archers MUST be created by using one of the generator methods. That is way the constructor is private and should stay
 * private. You are also not allowed to add any constructor with an access modifier other then private unless it is for
 * testing purposes in which case the reason why you need that constructor must be contained in a very clear manner
 * in your report.
 */
public class Archer {
    public static int MAX_ARROWS = 3;
    public static int MAX_ROUNDS = 10;
    private static Random randomizer = new Random();
    public static final int FIRST_ID = 135788;
    public static final int MAX_POINTS = 300;
    private final int id; // Once assigned a value is not allowed to change.
    private String firstName;
    private String lastName;
    private int score;

    private HashMap<Integer, HashMap<Integer, Integer>> hashy = new HashMap<>();
    ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<ArrayList<Integer>>();
    private int calculatedScore = 0;

    /**
     * Constructs a new instance of bowman and assigns a unique ID to the instance. The ID is not allowed to ever
     * change during the lifetime of the instance! For this you need to use the correct Java keyword.Each new instance
     * is a assigned a number that is 1 higher than the last one assigned. The first instance created should have
     * ID 135788;
     *
     * @param firstName the archers first name.
     * @param lastName  the archers surname.
     * @param id the archer id
     */
    private Archer(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.id = id;
        //Make sure we keep the requested format of the first letter a capital and the rest just lowercase.
        //For Example: SCHMIDTH to Schmidth
        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
    }


    /**
     * Registers the point for each of the three arrows that have been shot during a round. The <code>points</code>
     * parameter should hold the three points, one per arrow.
     *
     * @param round  the round for which to register the points.
     * @param points the points shot during the round.
     */
    public void registerScoreForRound(int round, int[] points) {
//        HashMap<Integer, Integer> inner = new HashMap<>();
        ArrayList<Integer> singleList = new ArrayList<Integer>();
        for (int i = 0; i < points.length; i++) {
            singleList.add(points[i]);
            score += points[i];
        }
        listOfLists.add(singleList);
    }

    public void calculateWeightedScore() {
        int count = 0;
        for (int i = 0; i < listOfLists.size(); i++) {
            for (int j = 0; j < listOfLists.get(i).size(); j++) {
                if (listOfLists.get(i).get(j) == 0) {
                    count++;
                    continue;
                }
                calculatedScore += listOfLists.get(i).get(j) + 1;
            }
        }
        if (count != 0) {
            calculatedScore -= (count * 7);
        }
    }


    public int getTotalScore() {
        return score;
    }

    public int getCalculatedWeight() {
        return calculatedScore;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * This methods creates a List of archers.
     *
     * @param nrOfArchers the number of archers in the list.
     * @return
     */
    public static List<Archer> generateArchers(int nrOfArchers) {
        List<Archer> archers = new ArrayList<>(nrOfArchers);

        for (int i = 0; i < nrOfArchers; i++) {
            Archer archer;
            if (archers.size() == 0) {
                archer = new Archer(Names.nextFirstName(), Names.nextSurname(), FIRST_ID);
            } else {
                archer = new Archer(Names.nextFirstName(), Names.nextSurname(), archers.get(archers.size() - 1).getId() + 1);

            }
            letArcherShoot(archer, nrOfArchers % 100 == 0);
            archer.calculateWeightedScore();
            archers.add(archer);
        }
        return archers;

    }

    /**
     * This methods creates a Iterator that can be used to generate all the required archers. If you implement this
     * method it is only allowed to create an instance of Archer inside the next() method!
     *
     * <b>THIS METHODS IS OPTIONAL</b>
     *
     * @param nrOfArchers the number of archers the Iterator will create.
     * @return
     */
    public static Iterator<Archer> generateArchers(long nrOfArchers) {
        return null;
    }

    public int getId() {
        return id;
    }

    private static void letArcherShoot(Archer archer, boolean isBeginner) {
        for (int round = 0; round < MAX_ROUNDS; round++) {
            archer.registerScoreForRound(round, shootArrows(isBeginner ? 0 : 1));
        }
    }

    private static int[] shootArrows(int min) {

        int[] points = new int[MAX_ARROWS];
        for (int arrow = 0; arrow < MAX_ARROWS; arrow++) {
            points[arrow] = shoot(min);
        }
        return points;
    }

    private static int shoot(int min) {
        return Math.max(min, randomizer.nextInt(11));
    }

    /**
     * Undo this function to see the error message that id cannot be changed.
     * @param id
     */
//    public void setId(int id)  {
//        this.id = id;
//    }


    public ArrayList<ArrayList<Integer>> getlistOfLists() {
        return listOfLists;
    }

    public void setlistOfLists(ArrayList<ArrayList<Integer>> listOfLists) {
        this.calculatedScore = 0;
        this.listOfLists = listOfLists;
    }

    /**
     * Test function
     * @return the hashmap containing the scores per round and arrow.
     */

    @Override
    public String toString() {
        StringBuilder archer = new StringBuilder();
        archer.append(this.id).append(" (").append(this.getTotalScore()).append(" / ").append(this.MAX_POINTS).append(") ")
                .append(this.firstName).append(" ").append(this.lastName);
        return archer.toString();
    }
}
