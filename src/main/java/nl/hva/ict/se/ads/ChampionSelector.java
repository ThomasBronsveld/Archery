package nl.hva.ict.se.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Given a list of Archer's this class can be used to sort the list using one of three sorting algorithms.
 */
public class ChampionSelector {
    /**
     * This method uses either selection sort or insertion sort for sorting the archers.
     */
    public static List<Archer> selInsSort(List<Archer> archers, Comparator<Archer> scoringScheme) {
        for (int i = 0; i < archers.size(); i++) {

            Archer temp = archers.get(i);
            int newIndex = 0;
            for (int j = i + 1; j < archers.size(); j++) {

                if (scoringScheme.compare(temp, archers.get(j)) > 0) {
                    temp = archers.get(j);
                    newIndex = j;
                }
            }
            if (newIndex != 0) {
                archers.set(newIndex, archers.get(i));
                archers.set(i, temp);
            }
        }
        return archers;
    }

    public static void quickSorter(List<Archer> archers, Comparator<Archer> scoringScheme, int low, int high) {
        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        Archer pivot = archers.get(middle);

        int i = low, j = high;

        while (i <= j) {

            while (scoringScheme.compare(archers.get(i), pivot) > 0) { //comparator = 1
                i++;
            }

            while (scoringScheme.compare(archers.get(j), pivot) < 0) { //comparator = -1
                j--;
            }

            if (i <= j) {
                //swap archer i en j
                Archer temp = archers.get(j); // temp = archer i
                archers.set(j, archers.get(i)); // zet archer right(j) naar left(i)
                archers.set(i, temp); // zet archer i naar j
                i++;
                j--;
            }

            if (low < j)
                quickSorter(archers, scoringScheme, low, j);

            if (high > i)
                quickSorter(archers, scoringScheme, i, high);
        }
    }

    public static List<Archer> quickSort(List<Archer> archers, Comparator<Archer> scoringScheme) {
        quickSorter(archers,scoringScheme,0, archers.size() - 1);
        Collections.reverse(archers);
        return archers;
    }


    /**
     * This method uses the Java collections sort algorithm for sorting the archers.
     */
    public static List<Archer> collectionSort(List<Archer> archers, Comparator<Archer> scoringScheme) {
        Collections.sort(archers, scoringScheme);
        return archers;
    }

    /**
     * This method uses quick sort for sorting the archers in such a way that it is able to cope with an Iterator.
     *
     * <b>THIS METHOD IS OPTIONAL</b>
     */
    public static Iterator<Archer> quickSort(Iterator<Archer> archers, Comparator<Archer> scoringScheme) {
        return null;
    }

}
