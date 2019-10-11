package nl.hva.ict.se.ads;

import java.util.*;

/**
 * Given a list of Archer's this class can be used to sort the list using one of three sorting algorithms.
 */
public class ChampionSelector {
    /**
     * This method uses election sort for sorting the archers.
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

    /**
     * This method uses quick sort for sorting the archers.
     */
    public static int partition(List<Archer> archers, Comparator<Archer> scoringScheme, int low, int high) {
        Archer pivot = archers.get(high);
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (scoringScheme.compare(archers.get(j), pivot) > 0) {
                i++;

                // swap arr[i] and arr[j]
                Archer temp = archers.get(i);
                archers.set(i, archers.get(j));
                archers.set(j, temp);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        Archer temp = archers.get(i + 1);
        archers.set(i + 1, pivot);
        archers.set(high, temp);

        return i + 1;
    }

    public static void quickSorter(List<Archer> archers, Comparator<Archer> scoringScheme, int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(archers, scoringScheme, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSorter(archers, scoringScheme, low, pi - 1);
            quickSorter(archers, scoringScheme, pi + 1, high);
        }
    }

    public static List<Archer> quickSort(List<Archer> archers, Comparator<Archer> scoringScheme) {
        quickSorter(archers, scoringScheme, 0, archers.size() - 1);
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
