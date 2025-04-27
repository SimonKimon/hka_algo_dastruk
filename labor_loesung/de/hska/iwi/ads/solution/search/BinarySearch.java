package de.hska.iwi.ads.solution.search;
import de.hska.iwi.ads.search.Search;

public class BinarySearch<E extends Comparable<E>> implements Search<E> {

    @Override
    public int search(E[] a, E key, int left, int right) {

        int index = binarySearch(a, key, left, right);

        //noch Problem lösen, dass wenn das Array nur aus gleichen Zahlen besteht das erste Element ausgegeben wird. s.Test_2
        if (a[index] == key) {
            if (a[binarySearch(a, key, left, right - 1)] == key) {

            }
        }

        return index;
    }

    private int binarySearch(E[] a, E z, int left, int right) {
        if (right < left) {
            return left;
        }
        else {
            int middle = (left + right) / 2;

            if (z.compareTo(a[middle]) > 0) {
                return binarySearch(a, z, middle + 1, right);
            }
            else if (z.compareTo(a[middle]) < 0) {
                return binarySearch(a, z, left, middle - 1);
            }
            else {
                return middle;
            }
        }
    }
}
