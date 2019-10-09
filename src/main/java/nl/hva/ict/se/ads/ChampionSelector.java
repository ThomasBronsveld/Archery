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
        for(int i = 0; i < archers.size(); i++){

            Archer temp = archers.get(i);
            int newIndex = 0;
            for(int j = i+ 1; j < archers.size(); j++){

                if(scoringScheme.compare(temp, archers.get(j)) > 0){
                    temp = archers.get(j);
                    newIndex = j;
                }
            }
            if(newIndex != 0){
                archers.set(newIndex, archers.get(i));
                archers.set(i, temp);
            }
        }
        System.out.println(archers);
        return archers;
    }

    /**
     * This method uses quick sort for sorting the archers.
     */
    public static List<Archer> quickSort(List<Archer> archers, Comparator<Archer> scoringScheme) {

        int index = archers.size()/2;
        Archer pivot = archers.get(index);
        System.out.println(index);
        System.out.println(pivot);
        scoringScheme.compare(pivot, archers.get(1));
        return archers;
    }

    /**
     * This method uses the Java collections sort algorithm for sorting the archers.
     */
    public static List<Archer> collectionSort(List<Archer> archers, Comparator<Archer> scoringScheme) {
        Collections.sort(archers, scoringScheme);
        System.out.println(archers);
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
