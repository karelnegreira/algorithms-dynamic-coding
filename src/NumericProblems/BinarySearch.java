package NumericProblems;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 2, 77, 55};
        Arrays.sort(array);
        System.out.print(binarySearch(array, 0, array.length - 1, 77));
        //System.out.print(binarySearchV2(array, 770));
    }

    public static int binarySearch(int[] array, int lower, int high, int key) {
        if (high >= lower) {
            int pivot = lower + (high - 1) / 2;

            if (array[pivot] == key) {
                return pivot;
            }

            if (array[pivot] > key) {
                return binarySearch(array, lower, pivot - 1, key);
            }
                return binarySearch(array, pivot + 1, high, key);

        }
        return -1;

    }

    public static int binarySearchV2(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = low + (high - 1) / 2;

            if (array[middle] == key) {
                return middle;
            }

            if (array[middle] < key) {
                low = middle + 1;
            } else
                high = middle - 1;
       }
        return -1;
    }

}
