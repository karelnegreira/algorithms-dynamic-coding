package dinamiccoding;

/**
 * The longest common sequence between two strings,
 * say X, Y are two ARRAYS of chars with length m and n respectively,
 * the algorithm works as follows,
 * if X[m - 1] == Y[n - 1] then recursively equals to 1 + LCS(X[m - 2], Y[n - 2])
 * if X[m - 1] != Y[n - 1] then picks one of the two MAX(LCS(X, Y, m, n - 1), lcs(X, Y, m - 1, n))
 * **/

public class LongestCommonSubsequenceOfficial {

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        int m = x.length;
        int n = y.length;

        System.out.println("The length of the longest subarray contained in both strings is: " +
                lcs(x, y, m, n));

    }

    public static int LCS_optimal(String X, String Y, int m, int n) {
        int[][] L = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
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

    public static int lcs(char[] x, char[] y, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (x[m - 1] == y[n - 1]) {
            return 1 + lcs(x, y, m - 1, n - 1);
        } else {
            return max(lcs(x, y, m, n - 1), lcs(x, y, m - 1, n));
        }
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

}
