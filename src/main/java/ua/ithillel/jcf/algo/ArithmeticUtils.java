package ua.ithillel.jcf.algo;

import java.util.Arrays;
import java.util.Comparator;

public class ArithmeticUtils {
    public static int factorial(int n) {
        // base case
        if (n == 0) {
            return 1;
        }

        // recursive case
        return  n * factorial(n - 1);

//        int product = 1;
//        for (int i = n; i > 0; i--) {
//            product *= i;
//        }
//
//        return product;
    }

    public static <T> T max(Comparator<T> comparator, T ... values) {
        if (values.length == 0) {
            throw new RuntimeException();
        }

        // base case
        if (values.length == 1) {
            return values[0];
        }

        // recursive case
        T max = values[0];
        T other = max(comparator, Arrays.copyOfRange(values, 1, values.length));

        int cmp = comparator.compare(other, max);
        if (cmp > 0) {
            max = other;
        }

        return max;
    }

    public static <T extends Comparable<T>> T max(T ... values) {
        if (values.length == 0) {
            throw new RuntimeException();
        }

        // base case
        if (values.length == 1) {
            return values[0];
        }

        // recursive case
        T max = values[0];
        T other = max(Arrays.copyOfRange(values, 1, values.length));

        int cmp = other.compareTo(max);
        if (cmp > 0) {
            max = other;
        }

        return max;
    }

    public static int maxInt(int ... values) {
        if (values.length == 0) {
            throw new RuntimeException();
        }

        // base case
        if (values.length == 1) {
            return values[0];
        }

        // recursive case
        int max = values[0];
        int other = maxInt(Arrays.copyOfRange(values, 1, values.length));

        if (other > max) {
            max = other;
        }

        return max;
//
//       int max = values[0];
//
//        for (int i = 0; i < values.length; i++) {
//            if (values[i] > max) {
//                max = values[i];
//            }
//        }
//
//        return max;
    }

    public static int minInt(int ... values) {
        if (values.length == 0) {
            throw new RuntimeException();
        }

        // base case
        if (values.length == 1) {
            return values[0];
        }

        // recursive case
        int min = values[0];
        int other = minInt(Arrays.copyOfRange(values, 1, values.length));

        if (other < min) {
            min = other;
        }

        return min;
    }
}
