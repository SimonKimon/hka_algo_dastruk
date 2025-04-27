package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Reverse;

public class ReverseArray<E extends Comparable<E>> implements Reverse<E> {
    @Override
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
