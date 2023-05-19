package ua.ithillel.jcf.list;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    public static final int DEFAULT_CAPACITY = 10;
    public static final double SCALE_FACTOR = 1.5;
    private T[] array;
    private int size;

    public MyArrayList() {
        array = getGenericArray(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(T el) {
        ensureCapacity();
        array[size++] = el;
    }



    @Override
    public T get(int i) {
        if (i >= size) {
            return null;
        }
        return array[i];
    }

    @Override
    public T remove(int i) {
        // 1 5 6 3 2
        //     ^
        // 1 5 _ 3 2
        // 1 5 3 2
        T removed = array[i];
        System.arraycopy(array, i + 1, array, i, array.length - (i + 1));
        size--;
        return removed;
    }

    @Override
    public void set(int i, T el) {
        if (i >= size) {
            return;
        }
        array[i] = el;
    }

    @Override
    public int size() {
        return size;
    }

    private T[] getGenericArray(int capacity) {
        T[] emptyArr = getGenericArray();
        return (T[]) Array.newInstance(emptyArr.getClass().getComponentType(), capacity);
    }

    private T[] getGenericArray(T ... elements) { // vararg - variable amount of argument
        return elements;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            grow();
        }
    }

    private void grow() {
        int newCapacity = (int)(array.length * SCALE_FACTOR);
        T[] newArray = Arrays.copyOf(array, newCapacity);
        array = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<T> {
        private int curIdx;

        @Override
        public boolean hasNext() {
            return curIdx < size;
        }

        @Override
        public T next() {
            return array[curIdx++];
        }
    }


}
