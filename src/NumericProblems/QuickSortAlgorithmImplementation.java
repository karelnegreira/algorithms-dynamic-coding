package NumericProblems;

public class QuickSortAlgorithmImplementation {

    public static void main(String[] args) {
        int[] array = {1, 6, 3, 7, 4};
        array = quickSort(array, 0, array.length - 1);

        for (int x: array) {
            System.out.println(x);
        }
    }

    public static int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
        return array;
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        //index the smaller element
        //indicates the right position
        //of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
     return (i + 1);
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
