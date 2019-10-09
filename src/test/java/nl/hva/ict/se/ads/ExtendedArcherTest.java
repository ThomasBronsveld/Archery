package nl.hva.ict.se.ads;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Place all your own tests for Archer in this class. Tests in any other class will be ignored!
 */
public class ExtendedArcherTest extends ArcherTest {

    /**
     * This test is to make sure an id once set cannot be changed.
     */
    @Test
    public void checkIdChange() throws Exception {
        List<Archer> archers = Archer.generateArchers(5);
        assertThrows(Exception.class, () -> {
            archers.get(4).setId(3);
        });
        System.out.println(archers.get(1).getTotalScore());
        archers.get(1).calculateWeightedScore();
        System.out.println(archers.get(1).getCalculatedWeight());
//        List<Archer> test = ChampionSelector.collectionSort(archers, );
    }

    @Test
    public void stringFormatTest(){

    }
}
