package de.hska.iwi.ads.solution.sorting;

import static org.junit.jupiter.api.Assertions.*;

import de.hska.iwi.ads.sorting.AbstractMergesort;
import org.junit.jupiter.api.Test;

public class SortTest {

    @Test
    void Test1() {
        AbstractMergesort<Integer> mergesort = new Mergesort<>();
        Integer[] a = {12, 47, 3, 29, 8, 34, 18, 1, 45, 22, 5, 31, 14, 48, 6, 24, 19, 0, 41, 36, 10, 17, 39, 7, 30, 49, 27, 2, 15, 44, 9, 20, 33, 43, 28, 13, 25, 46, 11, 37, 4, 26, 42, 21, 16, 38, 32, 23, 35, 50, 40};

        mergesort.sort(a);
    }
}
