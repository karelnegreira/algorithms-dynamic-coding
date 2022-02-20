package NumericProblems;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateNumbersInArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 1};
        findDuplicateInArray(array);
    }

    public static void findDuplicateInArray(int[] array) {
        Map<Integer, Integer> hashTableNumbers = new HashMap<>();
        int temp;

        for (int i = 0; i < array.length; i++) {
            temp = array[i];

            if (hashTableNumbers.containsKey(temp)) {
                hashTableNumbers.put(temp, hashTableNumbers.get(temp) + 1);
            } else {
                hashTableNumbers.put(temp, 1);
            }
        }

        hashTableNumbers
                .entrySet()
                .stream()
                .filter(o -> o.getValue() > 1)
                .forEach(System.out::println);
    }
}
