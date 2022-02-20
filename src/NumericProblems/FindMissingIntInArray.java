package NumericProblems;

public class FindMissingIntInArray {

    public static void main(String[] args) {
        findArray(new int[] {1, 2, 4, 5, 6, 9, 15, 20});
    }

    public static void findArray(int[] array) {
        int diff = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] + 1 != array[i + 1]) {
                diff = array[i + 1] - array[i];

                for (int j = 1; j < diff; j++) {
                    System.out.println(array[i] + j);
                }
            }
        }
    }

}
