package codingtest;

public class ShortestCommonSubsequenceV2 {
    public static void main(String[] args) {
        String text1 = "AGGTAB";
        String text2 = "GXTXAYB";
        System.out.println(shortest_common_sequnce(text1, text2));
    }

    public static int shortest_common_sequnce(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int l = LCS(str1, str2, str1.length(), str2.length());

        return (m + n - l);
    }

    /**Longest common sequence length, by using dynamic programming*/
    public static int LCS(String X, String Y, int m, int n) {
        int[][] LDP = new int[m + 1][n + 1];
        int i, j;
        for (i = 0; i <= m; i++) {
            for (j = 1; j <= n; j++) {
                if (i == 0 || j == 0) {
                    LDP[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    LDP[i][j] = 1 + LDP[i - 1][j - 1];
                } else {
                    LDP[i][j] = max(LDP[i - 1][j], LDP[i][j - 1]);
                }
            }
        }
        return LDP[m][n];
    }

    public static int max(int a, int b) {
        return (a > b)  ? a : b;
    }
}
