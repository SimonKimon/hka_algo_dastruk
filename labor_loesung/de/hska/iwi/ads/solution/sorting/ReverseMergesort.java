package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.AbstractMergesort;
import de.hska.iwi.ads.sorting.Reverse;

public class ReverseMergesort<E extends Comparable<E>> extends AbstractMergesort<E> implements Reverse<E> {

    public void reverseMergesort(E[] a) {
        b = a.clone();
        mergesort(a, 0, a.length - 1);
        reverse(a, (a.length) / 2, a.length - 1);
    }

    protected void mergesort(E[] a, int left, int right) {
        if (left < right) {
            int m = (left + right) / 2;
            mergesort(a, left, m);
            mergesort(a, m + 1, right);
            merge(a, super.b, left, m, right);
        }
    }

    private void merge(E[] a, E[] b, int left, int m, int right) {
        int l = left;
        int r = m + 1;
        for (int i = left; i <= right; i++) {
            if ((a[l].compareTo(a[r]) <= 0)) {
                b[i] = a[l];
                l++;
            }
            else {
                b[i] = a[r];
                r++;
            }
        }
        for (int i = left; i <= right; i++) {
            a[i] = b[i];
        }
    }

    public void reverse(E[] a, int from, int to) {
        int middle = (to + from) / 2;
        E puffer;

        int j = 0;
        for (int i = from; i <= middle; i++) {
            puffer = a[i];
            a[i] = a[to - j];
            a[to - j] = puffer;
            j++;
        }
    }
}
