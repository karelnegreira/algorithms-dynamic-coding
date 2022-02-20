package NumericProblems;

import java.util.HashSet;
import java.util.Set;

public class FindTwoMumbersSumsToGivenNumber {

    public static void main(String[] args) {
        //printPairs(new int[]{1, 2, 3, 4}, 5);
        printPairsOptimalSolution(new int[]{1, 2, 3, 4}, 50);
        //list.forEach(System.out::println);
    }

    /*
    public static List<Integer> pairSum(int[] array, int sum_result) {
        List<Integer> result_list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j <= array.length - 1; j++) {
                if ((array[i] + array[j]) == sum_result) {
                    result_list.add(array[i]);
                    result_list.add(array[j]);
                }
            }
        }
        return result_list;
    }*/

    /**
     * The algorithm below is ok, still its order is O(n^2)
     * usually the best perforance would be O(1), O(n), O(nlog(n))
     * */

    public static void printPairs(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            int first = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int second = array[j];
                if ((first + second) == target) {
                    System.out.print("The pairs are: " + first + " " + second);
                }
            }
        }
    }

    public static void printPairsOptimalSolution(int[] array, int n) {
        Set set = new HashSet(array.length);

        for (int value: array) {
            int target = n - value;      // here (target + value = n) -> (happens to be the sums result
            if (!set.contains(target)) { // here the order is O(1)...
                set.add(value);
            } else {
                System.out.println("The pair of numbers are: " +  value + " " + target);
            }
        }
    }
}
