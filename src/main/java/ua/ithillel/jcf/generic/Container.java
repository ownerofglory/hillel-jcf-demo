package ua.ithillel.jcf.generic;

import java.lang.reflect.Array;

public class Container<T> {
    private T value; // Object

    public Container(T value) { // Object value
        this.value = value;
    }

    public T getValue() { // Object
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean compare(Container<? extends Comparable> other) {
        int i = other.value.compareTo(value);
        return i > 0;
    }
}
