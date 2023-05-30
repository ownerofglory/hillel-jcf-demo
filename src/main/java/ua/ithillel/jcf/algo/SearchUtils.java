package ua.ithillel.jcf.algo;

import java.util.Arrays;

public class SearchUtils {

    public static <T extends Comparable<T>> int binarySearch(T[] arr, T el, int left, int right) {
        // 1, 4, 6, 9, 12, 34, 45, 47, 49
        int mid = left + (right - left) / 2;

        int cmp = el.compareTo(arr[mid]);
        if (cmp < 0) {
            return binarySearch(arr, el, left, mid);
        } else if (cmp > 0) {
            return binarySearch(arr, el, mid + 1, right);
        } else {
            return mid;
        }
    }

    public static int binarySearchInt(int[] arr, int el, int left, int right) {
        // 1, 4, 6, 9, 12, 34, 45, 47, 49
        int mid = left + (right - left) / 2;

        if (el < arr[mid]) {
            return binarySearchInt(arr, el, left, mid);
        } else if (el > arr[mid]) {
            return binarySearchInt(arr, el, mid + 1, right);
        } else {
            return mid;
        }
    }

    public static int linearSearchInt(int[] arr, int el) {
        for (int i = 0; i < arr.length; i++) {
            if (el == arr[i]) {
                return i;
            }
        }

        return -1;
    }

    public static <T> int linearSearch(T[] arr, T el) {
        for (int i = 0; i < arr.length; i++) {
            if (el == arr[i] || el.equals(arr[i])) {
                return i;
            }
        }

        return -1;
    }
}
