package dynamicproblems;

/**
 * How many operations (insert, replace, remove) are necessary
 * to equal 2 strings.
 * */
public class EditDistance {
    public static void main(String[] args) {
        String str1 = "Sunday";
        String str2 = "Ssunday";

        System.out.println(editdistance(str1, str2, str1.length(), str2.length()));
    }

    private static int editdistance(String str1, String str2, int m, int n) {
        int[][] DP = new int[2][m + 1];

        for (int i = 0; i <= m; i++) {
            DP[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j == 0) {
                    DP[i % 2][j] = i;
                } else if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
                    DP[i % 2][j] = DP[(i - 1) % 2][j - 1];
                } else {
                    DP[i % 2][j] = 1 + Math.max(DP[(i - 1) % 2][j],
                            Math.max(DP[i % 2][j - 1],
                                    DP[(i - 1) % 2][j - 1]));
                }
            }
        }
        return DP[n % 2][m];
    }


}
