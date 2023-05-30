package ua.ithillel.jcf.algo;

public class SortUtils {

    public static <T extends Comparable<T>> void mergeSort(T[] arr, int left, int right) {

        if (left < right) {
            int mid = left + (right - left) / 2;

            // sort left part
            mergeSort(arr, left, mid);

            // sort right part
            mergeSort(arr, mid + 1, right);

            // merge left and right
            merge(arr, left, mid, right);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int left, int mid, int right) {
        int nLeft = mid - left + 1;
        int nRight = right - mid;

        T[] leftArr = MyArrayUtils.<T>createGenericComparableArray(nLeft, arr.getClass().getComponentType());
        T[] rightArr = MyArrayUtils.<T>createGenericComparableArray(nRight, arr.getClass().getComponentType());

        for (int i = 0; i < nLeft; i++) {
            leftArr[i] = arr[left + i];
        }

        for (int j = 0; j < nRight; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int leftIdx = 0;
        int rightIdx = 0;
        int i = left;
        while (leftIdx < leftArr.length && rightIdx < rightArr.length) {
            int cmp = leftArr[leftIdx].compareTo(rightArr[rightIdx]);
            if (cmp > 0) {
                arr[i++] = leftArr[leftIdx++];
            } else {
                arr[i++] = rightArr[rightIdx++];
            }
        }

        while (leftIdx < leftArr.length) {
            arr[i++] = leftArr[leftIdx++];
        }

        while (rightIdx < rightArr.length) {
            arr[i++] = rightArr[rightIdx++];
        }

    }

    public static void mergeSortInt(int[] arr, int left, int right) {

        if (left < right) {
            int mid = left + (right - left) / 2;

            // sort left part
            mergeSortInt(arr, left, mid);

            // sort right part
            mergeSortInt(arr, mid + 1, right);

            // merge left and right
            mergeInt(arr, left, mid, right);
        }
    }

    private static void mergeInt(int[] arr, int left, int mid, int right) {
        int nLeft = mid - left + 1;
        int nRight = right - mid;

        int[] leftArr = new int[nLeft];
        int[] rightArr = new int[nRight];

        for (int i = 0; i < nLeft; i++) {
            leftArr[i] = arr[left + i];
        }

        for (int j = 0; j < nRight; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int leftIdx = 0;
        int rightIdx = 0;
        int i = left;
        while (leftIdx < leftArr.length && rightIdx < rightArr.length) {
            if (leftArr[leftIdx] > rightArr[rightIdx]) {
                arr[i++] = leftArr[leftIdx++];
            } else {
                arr[i++] = rightArr[rightIdx++];
            }
        }

        while (leftIdx < leftArr.length) {
            arr[i++] = leftArr[leftIdx++];
        }

        while (rightIdx < rightArr.length) {
            arr[i++] = rightArr[rightIdx++];
        }

    }

    public static void bubbleSortInt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int cmp = arr[i].compareTo(arr[j]);
                if (cmp > 0) {
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
