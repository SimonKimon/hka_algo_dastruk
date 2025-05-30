package de.hska.iwi.ads.solution.tree;

import de.hska.iwi.ads.dictionary.AbstractBinaryTree;

import java.util.AbstractMap;


public class BinarySearchTree<K extends Comparable<K>, V> extends AbstractBinaryTree<K, V> {

    public BinarySearchTree() {
        super();
    }


    public V get(Object o) {
        K key = (K) o;
        if (key == null) {return null;}

        Node current = root;
        int keyComparison;

        while (current != null) {
            keyComparison = key.compareTo(current.entry.getKey());
            //Abbruch wenn key gefunden wurde
            if (keyComparison == 0) {
                return current.entry.getValue();
            }
            //Fortfahren im linken Teilbaum
            else if (keyComparison < 0) {
                //System.out.println("ich gehe in den linken Teilbaum rein");
                current = current.left;
            }
            //Fortfahren im rechten Teilbaum
            else {
                //System.out.println("ich gehe in den rechten Teilbaum rein");
                current = current.right;
            }
        }
        //System.out.println("Der Baum hat keine Elemente");
        return null;
    }





    public V put(K key, V value) {
        if(key == null) {return null;}
        if(value == null) {return null;}

        //erstes Objekt im Baum hinzufügen
        if (root == null) {
            root = new Node(key, value);
            return null;
        }

        Node current = root;
        int keyComparison;

        while (current != null) {
            keyComparison = key.compareTo(current.entry.getKey());
            //gleicher Schlüssel gefunden ... Value wird ausgetauscht und der alte Value wird zurückgegeben.
            if (keyComparison == 0) {
                V oldValue = current.entry.getValue();
                current.entry = new AbstractMap.SimpleEntry<>(key, value);
                return oldValue;
            }
            //ist der Key kleiner wird in den linken Teilbaum gesprungen.
            else if (keyComparison < 0) {
                //einfügen des neuen Objektes, wenn ein Blatt erreicht wurde.
                if (current.left == null) {
                    current.left = new Node(key, value);
                    return null;
                }
                //ansonsten wird weiter in den linken Teilbaum gegangen.
                current = current.left;
            }
            //ist der Key größer wird in den rechten Teilbaum gesprungen.
            else {
                //einfügen des neuen Objektes, wenn ein Blatt erreicht wurde.
                if (current.right == null) {
                    current.right = new Node(key, value);
                    return null;
                }
                //ansonsten wird auch hier weiter in den rechten Teilbaum gegangen.
                current = current.right;
            }
        }
        return null;
    }
}
