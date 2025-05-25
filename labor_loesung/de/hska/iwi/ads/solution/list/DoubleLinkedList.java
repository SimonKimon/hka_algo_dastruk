package de.hska.iwi.ads.solution.list;

import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;

import java.util.AbstractMap;
import java.util.Map;

public class DoubleLinkedList<K extends Comparable<K>,V> extends AbstractDoubleLinkedList<K,V> {
    public V get(Object o) {
        ListElement current = head;

        while (current != null) {
            if (current.entry.getKey().compareTo((K) o) == 0) {
                return current.entry.getValue();
            }
            current = current.next;
        }
        return null;
    }



    public V put(K key, V value) {
        ListElement current = head;

        while (current != null) {
            if (current.entry.getKey().compareTo(key) == 0) {
                V oldValue = current.entry.getValue();
                current.entry.setValue(value);
                return oldValue;
            }
            current = current.next;
        }

        current = head;
        ListElement newListElement = new ListElement(Map.entry(key, value), head, current.next);
        return null;
    }
}
