package ua.ithillel.jcf.map;

import java.lang.reflect.Array;

public class MyHashMap<K, V> implements MyMap<K, V> {
    public static final int INIT_CAPACITY = 10;
    public static final double LOAD_FACTOR = 0.75;
    public static final double SCALE_FACTOR = 1.5;
    private Node<Entry<K, V>>[] buckets;
    private int load;


    public MyHashMap() {
        Node<Entry<K, V>>[] emptyArray = this.<Node<Entry<K, V>>>getGenericArray();
        buckets = (Node<Entry<K, V>>[]) Array.newInstance(emptyArray.getClass().getComponentType(), INIT_CAPACITY);
    }

    @Override
    public void put(K key, V value) {
        ensureCapacity();
        load++;
        Entry<K, V> newEntry = new Entry<>(key, value);
        Node<Entry<K, V>> newNode = new Node<>(newEntry);

        putNode(newNode);
    }

    private void putNode(Node<Entry<K, V>> newNode) {
        int bucketIdx = hash(newNode.value.key);
        if (buckets[bucketIdx] == null) {
            buckets[bucketIdx] = newNode;
            return;
        }

        var curNode = buckets[bucketIdx];
        var preNode = curNode;
        while (curNode != null) {
            preNode = curNode;
            if (curNode.value.key == newNode.value.key || curNode.value.key.equals(newNode.value.key)) {
                curNode.value.value = newNode.value.value;
                return;
            }

            curNode = curNode.next;
        }
        preNode.next = newNode;

//        newNode.next = buckets[bucketIdx];
//        buckets[bucketIdx] = newNode;
    }

    @Override
    public V get(K key) {
        int bucketIdx = hash(key);
        if (buckets[bucketIdx] == null) {
            return null;
        }

        Node<Entry<K, V>> curNode = buckets[bucketIdx];
        while (curNode != null) {
            if (curNode.value.key == key || curNode.value.key.equals(key)) {
                return curNode.value.value;
            }

            curNode = curNode.next;
        }

        return null;
    }

    @Override
    public void remove(K key) {

    }

    private void ensureCapacity() {
        if (load < buckets.length * LOAD_FACTOR) {
            return;
        }
        resize();
    }

    private void resize() {
        int newLength = (int) (buckets.length * SCALE_FACTOR);
        Node<Entry<K, V>>[] emptyArray = this.<Node<Entry<K, V>>>getGenericArray();
        var newBuckets = (Node<Entry<K, V>>[]) Array.newInstance(emptyArray.getClass().getComponentType(), newLength);
        var oldBuckets = buckets;
        buckets = newBuckets;

        for (Node<Entry<K, V>> node: oldBuckets) {
            var curNode = node;
            while (curNode != null) {
                Node<Entry<K, V>> newNode = new Node<>(curNode.value);
                putNode(newNode);

                curNode = curNode.next;
            }
        }
    }

    public int hash(Object o) {
        return o.hashCode() & (buckets.length - 1);
    }

    private <T> T[] getGenericArray(T ... elements) { // vararg - variable amount of argument
        return elements;
    }

    private class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
