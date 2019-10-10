package nl.hva.ict.se.ads;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Place all your own tests for ChampionSelector in this class. Tests in any other class will be ignored!
 */
public class ExtendedChampionSelectorTest extends ChampionSelectorTest {
    @Test
    public void quickSortAndCollectionSortResultInSameOrder() throws Exception {
        List<Archer> unsortedArchersForQuickSort = Archer.generateArchers(23);
        List<Archer> unsortedArchersForCollection = new ArrayList<>(unsortedArchersForQuickSort);

        List<Archer> sortedArchersQuick = ChampionSelector.quickSort(unsortedArchersForQuickSort, comparator);
        List<Archer> sortedArchersCollection = ChampionSelector.collectionSort(unsortedArchersForCollection, comparator);

        assertEquals(sortedArchersCollection, sortedArchersQuick);
    }
}
