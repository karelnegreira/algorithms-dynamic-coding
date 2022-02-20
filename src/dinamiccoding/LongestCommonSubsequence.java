package dinamiccoding;

import java.util.*;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String str1 = "fdsdfsdfshf";
        String str2 = "dfsdfsdfsdf";

        LCSV2(str1, str2);
    }

    public static List LCS(String[] array1, String[] array2) {
        List commonchar = new LinkedList();

        for (String s : array1) {
            for (String z : array2) {
                if (s == z) {
                    commonchar.add(s);
                }
            }
        }

        return commonchar;
    }

    public static void LCSV2(String str1, String str2) {
        Map<Character, Integer> table_str1 = new Hashtable<>();

        for (char s : str2.toCharArray()) {
            if (table_str1.containsKey(s)) {
                table_str1.put(s, table_str1.get(s) + 1);
            } else {
                table_str1.put(s, 1);
            }
        }
        table_str1.entrySet()
                .stream()
                .filter(o -> o.getValue() > 1)
                .forEach(System.out::println);
    }
}
