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
        List<Archer> archers = Archer.generateArchers(10);
        assertThrows(Exception.class, () -> {
            archers.get(4).setId(3);
        });
        List<Archer> archers2 = archers;
        List<Archer> archers3 = archers;

//        ChampionSelector.quickSort(archers2, archers2.get(0).getTotalScore());
    }

    @Test
    public void stringFormatTest(){

    }
}
