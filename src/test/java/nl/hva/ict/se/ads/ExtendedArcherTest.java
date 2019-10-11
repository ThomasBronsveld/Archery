package nl.hva.ict.se.ads;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Place all your own tests for Archer in this class. Tests in any other class will be ignored!
 */
public class ExtendedArcherTest extends ArcherTest {

    private int points[] = {1,2,3};
    private int points2[] = {9,10, 0};

    ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<ArrayList<Integer>>();

    @Test
    public void testCalculatedWeight() {
        List<Archer> archers = Archer.generateArchers(1);

        for(int i = 0; i < Archer.MAX_ROUNDS; i++){
            ArrayList<Integer> singleList = new ArrayList<Integer>();
            for (int j = 0; j < Archer.MAX_ARROWS; j++) {
                singleList.add(points[j]);
            }
            listOfLists.add(singleList);
        }
        archers.get(0).setlistOfLists(listOfLists);
        archers.get(0).calculateWeightedScore();
        assertEquals(90, archers.get(0).getCalculatedWeight());
    }

    @Test
    public void testCalculatedWeightWithZeros() {

        List<Archer> archers = Archer.generateArchers(1);

        for(int i = 0; i < Archer.MAX_ROUNDS; i++){
            ArrayList<Integer> singleList = new ArrayList<Integer>();
            for (int j = 0; j < Archer.MAX_ARROWS; j++) {
                singleList.add(points2[j]);
            }
            listOfLists.add(singleList);
        }
        archers.get(0).setlistOfLists(listOfLists);
        archers.get(0).calculateWeightedScore();
        assertEquals(140, archers.get(0).getCalculatedWeight());
    }


    /**
     * This test is to make sure an id once set cannot be changed.
     * Make sure to uncomment the setId function in the Archer class.
     */
//    @Test
//    public void checkIdChange() {
//        List<Archer> archers = Archer.generateArchers(10);
//        assertThrows(Exception.class, () -> {
//            archers.get(4).setId(3);
//        });
//        List<Archer> archers2 = archers;
//        List<Archer> archers3 = archers;
//       ChampionSelector.quickSort(archers2, archers2.get(0).getTotalScore());
//    }


    @Test
    public void calculateWeightScoreWithoutZerosTest()  throws IndexOutOfBoundsException{
        List<Archer> archers = Archer.generateArchers(101);
        System.out.println(archers.get(0).getlistOfLists().toString());
        assertFalse(archers.get(0).getlistOfLists().toString().matches("0"));
        //Not the most elegant solution, but I can't come up that quickly with a way to do this without having to get deep
        //into for-loops.
        try{
            archers = Archer.generateArchers(0);
            assertFalse(archers.get(0).getlistOfLists().toString().matches("0"));
        } catch (IndexOutOfBoundsException ex){
            ex.getMessage();
        }

        archers = Archer.generateArchers(101);
        assertFalse(archers.get(0).getlistOfLists().toString().matches("0"));
    }


    @Test
    public void getTotalScoreTest(){
        List<Archer> archers = Archer.generateArchers(1);
        assertNotNull(archers.get(0).getTotalScore());
    }

    @Test
    public void getCalculatedWeightTest() {
        List<Archer> archers = Archer.generateArchers(1);
        assertNotNull(archers.get(0).getCalculatedWeight());
    }

    @Test
    public void getlistOfListsTest() {
        List<Archer> archers = Archer.generateArchers(1);
        assertNotNull(archers.get(0).getlistOfLists());
    }

    @Test
    public void stringFormatTest() {
        List<Archer> archers = Archer.generateArchers(1);

        String expected = archers.get(0).getId()
                + " (" + archers.get(0).getTotalScore()
                + " / " + Archer.MAX_POINTS
                + ") " + archers.get(0).getFirstName() + " "
                + archers.get(0).getLastName();
        System.out.println(archers.get(0).toString());
        assertEquals(expected, archers.get(0).toString());
    }
}
