package nl.hva.ict.se.ads;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Place all your own tests for Archer in this class. Tests in any other class will be ignored!
 */
public class ExtendedArcherTest extends ArcherTest {

    private int points[] = {1,2,3};
    private int points2[] = {9,10, 0};

    private HashMap<Integer, HashMap<Integer, Integer>> hashy = new HashMap<>();

    @Test
    public void testCalculatedWeight() {
        List<Archer> archers = Archer.generateArchers(1);

        for(int i = 0; i < Archer.MAX_ROUNDS; i++){
            HashMap<Integer, Integer> inner = new HashMap<>();
            for (int j = 0; j < Archer.MAX_ARROWS; j++) {
                inner.put(j, points[j]);
            }
            hashy.put(i, inner);
        }
        archers.get(0).setHashy(hashy);
        archers.get(0).calculateWeightedScore();
        assertEquals(90, archers.get(0).getCalculatedWeight());


    }
    @Test
    public void testCalculatedWeightWithZeros() {

        List<Archer> archers = Archer.generateArchers(1);

        for(int i = 0; i < Archer.MAX_ROUNDS; i++){
            HashMap<Integer, Integer> inner = new HashMap<>();
            for (int j = 0; j < Archer.MAX_ARROWS; j++) {
                inner.put(j, points2[j]);
            }
            hashy.put(i, inner);
        }
        archers.get(0).setHashy(hashy);
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
    public void calculateWeightScoreWithZerosTest()  {
        List<Archer> archers = Archer.generateArchers(100);
        //Not the most elegant solution, but I can't come up that quickly with a way to do this without having to get deep
        //into for-loops.
        assertTrue(archers.get(0).getHashy().values().toString().contains("=0"));
    }
    @Test
    public void calculateWeightScoreWithoutZerosTest()  throws IndexOutOfBoundsException{
        List<Archer> archers = Archer.generateArchers(101);
        assertFalse(archers.get(0).getHashy().values().toString().contains("=0"));
        //Not the most elegant solution, but I can't come up that quickly with a way to do this without having to get deep
        //into for-loops.
        try{
            archers = Archer.generateArchers(0);
            assertFalse(archers.get(0).getHashy().values().toString().contains("=0"));
        } catch (IndexOutOfBoundsException ex){
            ex.getMessage();
        }

        archers = Archer.generateArchers(101);
        assertFalse(archers.get(0).getHashy().values().toString().contains("=0"));
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
    public void getHashyTest() {
        List<Archer> archers = Archer.generateArchers(1);
        assertNotNull(archers.get(0).getHashy());
    }

    @Test
    public void stringFormatTest() {
        List<Archer> archers = Archer.generateArchers(1);

        String expected = archers.get(0).getId()
                + " (" + archers.get(0).getTotalScore()
                + "/" + Archer.MAX_POINTS
                + ") " + archers.get(0).getFirstName() + " "
                + archers.get(0).getLastName();

        assertEquals(expected, archers.get(0).toString());
    }
}
