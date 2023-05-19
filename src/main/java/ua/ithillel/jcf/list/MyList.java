package ua.ithillel.jcf.list;

public interface MyList<T> extends Iterable<T> {
    boolean isEmpty();
    void add(T el);
    T get(int i);
    T remove(int i);
    void set(int i, T el);
    int size();
}
