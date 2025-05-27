package de.hska.iwi.ads.solution.list;

import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;
import de.hska.iwi.ads.dictionary.MapTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import java.util.Map;


public class DoubleLinkedListTest {


    @Test
    void testEmptyList() {
        DoubleLinkedList<Integer, String> list = new DoubleLinkedList<>();
        assertNull(list.get(1));
    }
    
    @Test
    void testPutAndGetSingleElement() {
        DoubleLinkedList<Integer, String> list = new DoubleLinkedList<>();
        list.put(1, "eins");
        assertEquals("eins", list.get(1));
    }
    
    @Test
    void testMultipleElements() {
        DoubleLinkedList<Integer, String> list = new DoubleLinkedList<>();
        list.put(1, "eins");
        list.put(2, "zwei");
        list.put(3, "drei");
        
        assertEquals("eins", list.get(1));
        assertEquals("zwei", list.get(2));
        assertEquals("drei", list.get(3));
    }
    
    @Test
    void testOverwriteValue() {
        DoubleLinkedList<Integer, String> list = new DoubleLinkedList<>();
        list.put(1, "eins");
        String oldValue = list.put(1, "ONE");
        
        assertEquals("eins", oldValue);
        assertEquals("ONE", list.get(1));
    }
    
    @Test
    void testNonExistentKey() {
        DoubleLinkedList<Integer, String> list = new DoubleLinkedList<>();
        list.put(1, "eins");
        
        assertNull(list.get(2));
    }

    
    @Test
    void testNullValues() {
        DoubleLinkedList<Integer, String> list = new DoubleLinkedList<>();
        list.put(1, null);
        
        assertNull(list.get(1));
    }
}