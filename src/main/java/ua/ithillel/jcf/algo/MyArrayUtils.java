package ua.ithillel.jcf.algo;

import java.lang.reflect.Array;

public class MyArrayUtils {

    public static <T extends Comparable<T>> T[] createGenericComparableArray(int capacity, Class<?> elementClass) {
        return (T[]) Array.newInstance(elementClass, capacity);
    }
    public static <T> T[] createGenericArray(int capacity) {
        T[] emptyArr = getGenericArray();
        return (T[]) Array.newInstance(emptyArr.getClass().getComponentType(), capacity);
    }

    private static <T> T[] getGenericArray(T ... elements) { // vararg - variable amount of argument
        return elements;
    }

}
