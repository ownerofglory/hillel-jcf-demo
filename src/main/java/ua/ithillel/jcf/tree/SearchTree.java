package ua.ithillel.jcf.tree;

public interface SearchTree<V> extends Iterable<V> {
    boolean search(V value);
    void insert(V value);
    void delete(V value);
}
