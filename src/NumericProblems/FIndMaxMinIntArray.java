package NumericProblems;

public class FIndMaxMinIntArray {

    public static void main(String[] args) {
        findMaxMin(new int[]{1, 4, 23, 77, 5, 2});
    }

    public static void findMaxMin(int[] array) {
        int[] sortedArray = sort(array);

        for (int i: sortedArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("The maximun is: " + sortedArray[0]);
        System.out.println("The minimun is: " + sortedArray[sortedArray.length - 1]);
    }

    public static int[] sort(int[] array) {
        int temp = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
