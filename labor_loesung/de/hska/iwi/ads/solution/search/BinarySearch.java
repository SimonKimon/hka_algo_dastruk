package de.hska.iwi.ads.solution.search;
import de.hska.iwi.ads.search.Search;

public class BinarySearch<E extends Comparable<E>> implements Search<E> {

    @Override
    public int search(E[] a, E key, int left, int right) {

        int index = binarySearch(a, key, left, right);

        //noch Problem lösen, dass wenn das Array nur aus gleichen Zahlen besteht das erste Element ausgegeben wird. s.Test_2
        if (key.compareTo(a[left]) < 0) {
            index = left - 1;
        }
        if (key.compareTo(a[right]) > 0) {
            index = right + 1;
        }
        //Der 3.Fall wird schon von der Methode binarySearch abgehandelt, dadurch dass man left zurückgibt.
        /*if (a[left].compareTo(key) <= 0 && key.compareTo(a[right]) <= 0) {

        }*/

        return index;
    }

    //binarySearch wie in der Vorlesung besprochen
    /*
    private int binarySearch(E[] a, E z, int left, int right) {
        if (right < left) {
            return left;
        }
        else {
            int middle = (left + right) / 2;

            if (z.compareTo(a[middle]) < 0) {
                return binarySearch(a, z, left, middle - 1);
            }
            else if (z.compareTo(a[middle]) > 0) {
                return binarySearch(a, z, middle + 1, right);
            }
            else {
                return middle;
            }
        }
    }
     */

    //iteratives binarySearch mit Fix, dass bei gefundenem Element, der Index des ersten/vordersten Duplikat zurückgegeben wird.
    private int binarySearch(E[] a, E z, int left, int right) {
        int result = -1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (z.compareTo(a[middle]) < 0) {
                right = middle - 1;
            }
            else if (z.compareTo(a[middle]) > 0) {
                left = middle + 1;
            }
            else {
                result = middle;
                right = middle - 1;
            }
        }
        //Bedingung ? Return bei true : Return bei false;
        return result != -1 ? result : left;
    }
}
