package de.hska.iwi.ads.solution.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BinarySearchTreeTest {

    @Test
    void insertFirstNode() {
        BinarySearchTree<Integer, String> newTree = new BinarySearchTree<>();
        newTree.put(5, "Tier");
        assertEquals("Tier", newTree.get(5));
    }


    @Test
    void insertAscendingOrder() {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        tree.put(1, "One");
        tree.put(2, "Two");
        tree.put(3, "Three");
        assertEquals("One", tree.get(1));
        assertEquals("Two", tree.get(2));
        assertEquals("Three", tree.get(3));
    }

    @Test
    void insertDescendingOrder() {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        tree.put(3, "Three");
        tree.put(2, "Two");
        tree.put(1, "One");
        assertEquals("One", tree.get(1));
        assertEquals("Two", tree.get(2));
        assertEquals("Three", tree.get(3));
    }

    @Test
    void updateExistingNode() {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        tree.put(1, "Original");
        assertEquals("Original", tree.get(1));
        tree.put(1, "Updated");
        assertEquals("Updated", tree.get(1));
    }

    @Test
    void getNonExistentKey() {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        tree.put(1, "One");
        assertNull(tree.get(2));
    }

    @Test
    void insertNullKey() {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        assertNull(tree.put(null, "Value"));
        assertNull(tree.get(null));
    }

    @Test
    void insertNullValue() {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        assertNull(tree.put(1, null));
        assertNull(tree.get(1));
    }

    @Test
    void biggerTreeStructure() {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        tree.put(5, "Five");
        tree.put(3, "Three");
        tree.put(7, "Seven");
        tree.put(2, "Two");
        tree.put(4, "Four");
        assertEquals("Five", tree.get(5));
        assertEquals("Three", tree.get(3));
        assertEquals("Seven", tree.get(7));
        assertEquals("Two", tree.get(2));
        assertEquals("Four", tree.get(4));


        assertEquals("Four", tree.put(4, "replaceTest"));
        assertEquals("replaceTest", tree.get(4));
    }

}
