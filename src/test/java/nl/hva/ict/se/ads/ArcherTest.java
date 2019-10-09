package nl.hva.ict.se.ads;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ArcherTest {

    @Test
    public void archerIdsIncreaseCorrectly() throws Exception {
        List<Archer> archers = Archer.generateArchers(3);
        assertTrue(archers.get(1).getId() == archers.get(0).getId()+ 1);
        System.out.println(archers.get(0).getCalculatedWeight());
        System.out.println(archers.get(0).getHashy());
        System.out.println(archers.get(1).getCalculatedWeight());
        System.out.println(archers.get(1).getHashy());
        System.out.println(archers.get(2).getCalculatedWeight());
        System.out.println(archers.get(2).getHashy());
        assertTrue(archers.get(2).getId() == archers.get(1).getId()+ 1);
    }

    @Test
    public void iteratorImplementedCorrectlyIfImplemented() throws Exception {
        long nrOfArchers = 10;
        Iterator<Archer> archerIterator = Archer.generateArchers(nrOfArchers);
        if (archerIterator != null) {
            Archer firstArcher = archerIterator.next();
            Archer secondArcher = Archer.generateArchers(1).get(0);
            Archer thirdArcher = archerIterator.next();

            assertTrue(secondArcher.getId() == firstArcher.getId() + 1);
            assertTrue(thirdArcher.getId() == secondArcher.getId() + 1);

            int remainder = 0;
            while (archerIterator.hasNext()) {
                archerIterator.next();
                remainder++;
            }
            assertEquals(8, remainder);
        }
    }

}