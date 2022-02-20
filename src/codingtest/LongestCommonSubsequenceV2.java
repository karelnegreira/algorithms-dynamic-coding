package codingtest;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestCommonSubsequenceV2 {
    public static void main(String[] args) {
        String text1 = "AGGTAB";
        String text2 = "GXTXAYB";

        System.out.println(LCS_optimal(text1, text2, text1.length(), text2.length()));
    }


    public static int LCS_optimal(String X, String Y, int m, int n) {
        int[][] L = new int[m + 1][n + 1];
        int i, j;
        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    L[i][j] = 1 + L[i - 1][j - 1];
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        return L[m][n];
    }

    /**Naive algorithm for obtaining the longest common subsequence*/
    public static int LCS(char[] X, char[] Y, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (X[m - 1] == Y[n - 1]) {
            return 1 + LCS(X, Y, m - 1, n - 1);
        } else {
            return Math.max(LCS(X, Y, m, n - 1),
                    LCS(X, Y, m - 1, n));
        }
    }

    /**
     * Method that takes common characters in both
     * strings, still not necessary a subsequence
     * */
    public static void commonCharacters(String str1, String str2) {
        String concat_str = str1 + str2;
        char[] array_str = concat_str.toCharArray();
        Map<Character, Integer> table_char_occurance = new LinkedHashMap<>();

        for (char s: array_str) {
            if (table_char_occurance.containsKey(s)) {
                table_char_occurance.put(s, table_char_occurance.get(s) + 1);
            } else {
                table_char_occurance.put(s, 1);
            }
        }

        table_char_occurance.entrySet()
                .stream()
                .filter(o -> o.getValue() > 1)
                .forEach(o -> System.out.println(o.getKey()));
    }
}
