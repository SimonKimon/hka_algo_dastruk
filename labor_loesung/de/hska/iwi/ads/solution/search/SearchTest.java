package de.hska.iwi.ads.solution.search;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class SearchTest {

    @Test
    void test_1() {
        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        Integer[] array = {1,2,4,5,6,7,8};

        int result = binarySearch.search(array, 3, 0, array.length - 1);
        assertEquals(2, result);
    }

    @Test
    void test_2() {
        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        Integer[] array = {1,2,3,4,5,6,7,8};

        int result = binarySearch.search(array, 1, 2, array.length - 1);
        assertEquals(1, result);
    }

    @Test
    void test_3() {
        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        Integer[] array = {2,3,4,5,6,7,8};

        int result = binarySearch.search(array, 9, 0, array.length - 1);
        assertEquals(7, result);
    }

    @Test
    void test_4() {
        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        Integer[] array = {1};

        int result = binarySearch.search(array, -2, 0, array.length - 1);
        assertEquals(-1, result);
    }

    @Test
    void test_5() {
        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        Integer[] array = {1,2,5,5,5,5,5,6,7,8};

        int result = binarySearch.search(array, 5, 0, array.length - 1);
        assertEquals(2, result);
    }

    @Test
    void test_6() {
        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        Integer[] array = {1,2,5,5,5,5,5,7,8};

        int result = binarySearch.search(array, 6, 0, array.length - 1);
        assertEquals(7, result);
    }
}