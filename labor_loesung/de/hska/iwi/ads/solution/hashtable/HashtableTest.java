package de.hska.iwi.ads.solution.hashtable;

import de.hska.iwi.ads.dictionary.AbstractDictionary;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashtableTest {

    @Test
    void testAddValue() {
        int capacity = 5;

        Hashtable<Integer, String> newHashtable = new Hashtable<>(capacity);
        newHashtable.put(1, "Hallo");
        assertEquals("Hallo", newHashtable.get(1));
    }

    @Test
    void testAddMultipleValue() {
        int capacity = 5;

        Hashtable<Integer, String> newHashtable = new Hashtable<>(capacity);
        newHashtable.put(1, "Hallo");
        newHashtable.put(2, "Test");
        newHashtable.put(3, "Informatik");
        newHashtable.put(4, "Studium");
        newHashtable.put(5, "Algorithmen");
        newHashtable.put(6, "Datenstrukturen");

        //System.out.println(newHashtable.get(1));
        assertNotEquals("Hallo", newHashtable.get(1));
        assertEquals("Datenstrukturen", newHashtable.get(1));
        //System.out.println(newHashtable.get(2));
        assertEquals("Test", newHashtable.get(2));
        //System.out.println(newHashtable.get(3));
        assertEquals("Informatik", newHashtable.get(3));
        //System.out.println(newHashtable.get(4));
        assertEquals("Studium", newHashtable.get(4));
        //System.out.println(newHashtable.get(5));
        assertEquals("Algorithmen", newHashtable.get(5));
    }

    @Test
    void testReplaceValue() {
        int capacity = 5;

        Hashtable<Integer, String> newHashtable = new Hashtable<>(capacity);
        newHashtable.put(1, "Hallo");
        newHashtable.put(1, "Wie geht's");
        assertEquals("Wie geht's", newHashtable.get(1));
    }

    @Test
    void testNullValue() {
        int capacity = 5;
        Hashtable<Integer, String> newHashtable = new Hashtable<>(capacity);

        // Test für null value
        try {
        assertNull(newHashtable.put(1, null));
        } catch (NullPointerException exception){
            System.out.println(exception.getMessage());
        }

        //System.out.println(newHashtable.get(1));
        assertNull(newHashtable.get(1));
    }

    @Test
    void testCollision() {
        int capacity = 3;
        Hashtable<String, Integer> newHashtable = new Hashtable<>(capacity);

        newHashtable.put("Aa", 1);// "Aa" und "BB" haben den gleichen Hashcode
        newHashtable.put("BB", 2);

        assertEquals(2, newHashtable.get("Aa"));
        assertEquals(2, newHashtable.get("BB"));
    }

    @Test
    void testCapacityLimit() {
        int capacity = 2;
        Hashtable<Integer, String> newHashtable = new Hashtable<>(capacity);

        // Mehr Elemente einfügen als Kapazität vorhanden
        newHashtable.put(1, "Eins");
        newHashtable.put(2, "Zwei");
        newHashtable.put(3, "Drei");

        // Prüfen ob die Werte korrekt überschrieben wurden
        assertNotEquals("Eins", newHashtable.get(1));
        assertEquals("Zwei", newHashtable.get(2));
        assertEquals("Drei", newHashtable.get(3));
    }
}
