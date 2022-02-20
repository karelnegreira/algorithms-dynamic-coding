package dynamicproblems;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        System.out.println(shortestSuperSequence(X, Y));
    }

    public static int shortestSuperSequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int l = lcs(str1, str2, m, n);

        return (m + n - l);
    }

    private static int lcs(String str1, String str2, int m, int n) {
        int[][] L = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    L[i][j] = 1 + L[i - 1][j - 1];
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        return L[m][n];
    }
}
