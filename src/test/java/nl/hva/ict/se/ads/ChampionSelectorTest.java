package nl.hva.ict.se.ads;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChampionSelectorTest {
    protected Comparator<Archer> comparator;

    @BeforeEach
    public void createComparator() {
        // Instantiate your own comparator here...
        // comparator = new .....();
        comparator = new Comparator<>() {
            @Override
            public int compare(Archer o1, Archer o2) {
                if (o1.getTotalScore() == o2.getTotalScore()) {
                    if (o1.getCalculatedWeight() == o2.getCalculatedWeight()) {
                        if (o1.getId() == o2.getId()) {
                            return 0;
                        } else if (o1.getId() > o2.getId()) {
                            return 1;
                        } else {
                            return -1;
                        }
                    } else if (o1.getCalculatedWeight() > o2.getCalculatedWeight()) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else if (o1.getTotalScore() > o2.getTotalScore()) {
                    return -1;
                } else //o1 < o2
                    return 1;
            }
        };
    }

    @Test
    public void selInsSortAndCollectionSortResultInSameOrder() throws Exception {
        List<Archer> unsortedArchersForSelIns = Archer.generateArchers(23);
        List<Archer> unsortedArchersForCollection = new ArrayList<>(unsortedArchersForSelIns);

        List<Archer> sortedArchersSelIns = ChampionSelector.selInsSort(unsortedArchersForSelIns, comparator);
        List<Archer> sortedArchersCollection = ChampionSelector.collectionSort(unsortedArchersForCollection, comparator);

        assertEquals(sortedArchersCollection, sortedArchersSelIns);
    }

}