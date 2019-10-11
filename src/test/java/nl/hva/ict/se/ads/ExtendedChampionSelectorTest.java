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
    public void quickSortAndCollectionSortResultInSameOrder() {
        List<Archer> unsortedArchersForQuickSort = Archer.generateArchers(32);
        List<Archer> unsortedArchersForCollection = new ArrayList<>(unsortedArchersForQuickSort);

        List<Archer> sortedArchersQuick = ChampionSelector.quickSort(unsortedArchersForQuickSort, comparator);
        List<Archer> sortedArchersCollection = ChampionSelector.collectionSort(unsortedArchersForCollection, comparator);

        assertEquals(sortedArchersCollection, sortedArchersQuick);
    }

    @Test
    public void sortBenchmark() {
        for (int i = 100; i <= 102400; i *= 2) {
            List<Archer> unsortedArchersForQuickSort = Archer.generateArchers(i);
            List<Archer> unsortedArchersForCollection = new ArrayList<>(unsortedArchersForQuickSort);
            List<Archer> unsortedArchersForSelection = new ArrayList<>(unsortedArchersForCollection);

            System.out.println("=========SelectionSort=======");
            long startSelection = System.currentTimeMillis();
            List<Archer> SelectionSort = ChampionSelector.selInsSort(unsortedArchersForSelection, comparator);
            System.out.println(i + " archers, sorted in " + (System.currentTimeMillis() - startSelection) + "ms");

            System.out.println("=========QuickSort=======");
            long startQuick = System.currentTimeMillis();
            List<Archer> QuickSort = ChampionSelector.quickSort(unsortedArchersForQuickSort, comparator);
            System.out.println(i + " archers, sorted in " + (System.currentTimeMillis() - startQuick) + "ms");

            System.out.println("=========CollectionSort=======");
            long startCollection = System.currentTimeMillis();
            List<Archer> CollectionSort = ChampionSelector.collectionSort(unsortedArchersForCollection, comparator);
            System.out.println(i + " archers, sorted in " + (System.currentTimeMillis() - startCollection) + "ms");
            System.out.println("\n");

            assertEquals(CollectionSort, QuickSort);
        }
    }
}
