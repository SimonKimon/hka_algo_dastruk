package de.hska.iwi.ads.solution.list;

import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;

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
        if (head != null) {
            System.out.println("Der Key existiert nicht in der Liste!");
        }
        else {
            System.out.println("Die Liste ist leer!");
        }
        return null;
    }



    public V put(K key, V value) {
        if (value != null) {
            ListElement current = head;

            //Falls Key existiert wird Value ausgetauscht
            while (current != null) {
                if (current.entry.getKey().compareTo(key) == 0) {
                    V oldValue = current.entry.getValue();
                    ListElement safedPreviousReference = current.previous;
                    ListElement safedNextReference = current.next;

                    ListElement newListElement = new ListElement(Map.entry(key, value), safedPreviousReference, safedNextReference);

                    //Wenn Objekt mitten in der Liste liegt
                    if (current.previous != null && current.next != null) {
                        current.previous.next = newListElement;
                        current.previous = null;
                        current.next.previous = newListElement;
                        current.next = null;
                    }
                    //Wenn Objekt ganz vorne in der Liste liegt
                    else if (current.previous == null && current.next != null) {
                        head = newListElement;
                        current.next.previous = newListElement;
                        current.next = null;
                    }
                    //Wenn Objekt ganz hinten in der Liste liegt
                    else if (current.previous != null && current.next == null) {
                        current.previous.next = newListElement;
                        current.previous = null;
                    }
                    //Wenn Objekt als einziges Objekt in der Liste ist
                    else if (current.previous == null && current.next == null) {
                        head = newListElement;
                    }

                    return oldValue;
                }

                current = current.next;
            }


            //Falls Key nicht existiert wird das Objekt ganz vorne in die Liste eingefügt
            ListElement newListElement = new ListElement(Map.entry(key, value), null, head);
            if (head != null) {
                head.previous = newListElement;
            }
            head = newListElement;

            return null;
        }
        else {
            System.out.println("kein Null-Value möglich!");
            return null;
        }
    }
}
