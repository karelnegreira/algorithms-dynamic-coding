package codingtest;

/**
 * The problem to find the number of combinations, operations necessary
 * to equals two strings, str1 and str2. ex: str1 = karel, str2 = karer,
 * the result is 1 since we have to substitute the last r in str2 by a l.
 * */
public class EditDistanceV2 {
    public static void main(String[] args) {
        String str1 = "Sunday";
        String str2 = "Saturday";
        setOperationsOptV2(str1, str2);
    }

    static void setOperationsOptV2(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
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
                    DP[i % 2][j] = 1 + Math.max(DP[(i - 1) % 2][j], //insert
                            Math.max(DP[i % 2][j - 1],              //replace
                            DP[(i - 1) % 2][j - 1]));               //remove
                }
            }
        }
        System.out.println(DP[n % 2][m]);
    }

    public static int MIN(int x, int y, int z) {
        if (x <= y && x <= z) {
            return x;
        }
        if (y <= x && y <= z) {
            return y;
        } else
            return z;
    }
}
