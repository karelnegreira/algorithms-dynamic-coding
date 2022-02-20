package NumericProblems;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDupesFromArray {

    public static void main(String[] args) {
        removeDupes(new int[] {1, 2, 3, 3, 3, 3, 6});
    }

    public static void removeDupes(int[] array) {
        Set<Integer> setNonDupeArray = new LinkedHashSet<Integer>();

        for (int i = 0; i < array.length; i++) {
            setNonDupeArray.add(array[i]);
        }

        for (Object x: setNonDupeArray.toArray()) {
            System.out.println(x.toString());
        }
    }
}
