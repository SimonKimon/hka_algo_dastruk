package de.hska.iwi.ads.solution.hashtable;

import de.hska.iwi.ads.dictionary.AbstractDictionary;
import de.hska.iwi.ads.dictionary.AbstractHashMap;

import java.security.KeyException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Hashtable<K extends Comparable<K>, V> extends AbstractHashMap<K,V> {
    public Hashtable(int capacity) {
        super(capacity);
    }
    
    
    
    
    
    
    
    


    public V get(Object o) {
        if (o == null) {
            throw new NullPointerException("No Null Values allowed!");
        }

        //keySet ist eine Liste mit allen keys aus dem Hashtable.
        //deren Hashcode wird mit hashCode() abgerufen/berechnet sozusag. der eigentliche Schlüssel, um auf den Wert dahinter zuzugreifen.
        //int hash = keySet().hashCode();

        /*
        1. **Hintergrundinformation zur Hashtabelle:**
            - Eine Hashtabelle ist eine Datenstruktur für schnelle Suche (O(1))
            - Der Hashwert wird verwendet, um die Position eines Elements zu berechnen
            - Die nachfolgende Modulo-Operation () verteilt die Elemente auf die verfügbare Array-Größe `% hashtable.length`

        2. **Warum der Hashwert wichtig ist:**
            - Er wandelt den Schlüssel in einen numerischen Wert um
            - Ermöglicht direkten Zugriff auf die Speicherposition
            - Gleiche Schlüssel erzeugen immer den gleichen Hashwert
         */

        //Das ist das gleiche Resultat, jedoch wird nicht der Hashcode der ganzen KeyListe abgerufen sondern nur der Hashcode von dem Objekt o.
        int hash = o.hashCode();


        //nun wird der Index des Elementes herausgefunden, um auf das Element mit O(1) Laufzeit darauf zuzugreifen.
        int pos = Math.abs(hash % hashtable.length);


        //prüfen ob die Position überhaupt einen Wert hat
        //**UND**
        //nachschauen, ob der berechnete hashwert wirklich von dem richtigen key kommt.
        //(durch die Modulo-Rechnung können zwei unterschiedliche Keys den gleichen Hashwert berechnen, das nennt man auch Kollision.)
        if (hashtable[pos] != null) {
            //"&& hashtable[pos].getKey().equals(o)" noch in if-Statement einfügen, wenn man exakt den gleichen Key benötigt, um auf Wert zuzugreifen.
            return hashtable[pos].getValue();
        }

        return null;
    }
    
    
    
    
    
    
    
    
    


    public V put(K key, V value) {
        if (value == null) {
            throw new NullPointerException("No Null Values allowed!");
        }
        if (key == null) {
            throw new NullPointerException("No Null Keys allowed!");
        }
        if (size > hashtable.length) {
            throw new DictionaryFullException();
        }


        int hash = key.hashCode();
        int pos = Math.abs(hash % hashtable.length);

        if(hashtable[pos] != null) {
            // Wenn der gleiche Key, nur Wert überschreiben
            V oldValue = hashtable[pos].getValue();
            hashtable[pos].setValue(value);
            return oldValue;
        }
        else {
            //setValue funktioniert hier nicht weil die Position = Null ist.
            hashtable[pos] = new AbstractMap.SimpleEntry<>(key, value);
        }
        return null;
    }


}