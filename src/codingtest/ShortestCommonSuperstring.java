package codingtest;

/**
 * Given two strings str1 and str2,
 * the task is to find the length of the shortest string
 * that has both str1 and str2 as subsequences
 *
 * */
public class ShortestCommonSuperstring {
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        int m = X.length();
        int n = Y.length();

        System.out.println("The length of the shortest subsequence is: " + shortestSuperSequence(X, Y));
        //System.out.println("The length of the shortest subsequence is: " + superSeq(X, Y, m, n));
    }
    // Function to find length of the
    // shortest supersequence of X and Y.
    static int shortestSuperSequence(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int longest = longest_common_substring(X, Y, m, n);

        return (m + n - longest);
    }
    //returns the LCS
    //for X[0 .. n - 1] and Y[0 .. n - 1]
    static int longest_common_substring(String X, String Y, int m, int n) {
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
    //A Naive algorithm to find the
    //shortest supersequence
    static int superSeq(String X, String Y, int m, int n) {
        if (m == 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return 1 + superSeq(X, Y, m - 1, n - 1);
        }
        return 1 +
                Math.min(superSeq(X, Y, m - 1, n),
                        superSeq(X, Y, m, n - 1));
    }

}
