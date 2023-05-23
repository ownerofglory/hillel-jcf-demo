package ua.ithillel.jcf.map;

public interface MyMap<K, V> {
    void put(K key, V value);
    V get(K key);
    void remove(K key);
}
