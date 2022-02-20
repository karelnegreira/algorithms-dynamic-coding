package NumericProblems;

public class ReverseInPlaceArray {
    public static void main(String[] args) {
        int[] array = {2, 5, 4, 11,7, 8, 9};
        printArray(array);
        reverseArray(array, array.length);
        printArray(array);
    }

    public static int _(int x, int y) {
        return x;
    }

    public static void reverseArray(int[] array, int n) {
        for (int i = 0; i < n/2; i++) {
            array[i] = _(array[n - i - 1], array[n - i - 1] = array[i]);
        }
    }

    public static void printArray(int[] array) {
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
