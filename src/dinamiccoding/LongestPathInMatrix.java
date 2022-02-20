package dinamiccoding;

public class LongestPathInMatrix {
    private static int n = 3;

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 9},
                {5, 3, 8},
                {4, 6, 7}
        };
        System.out.println("The length of the longest path: " + findMaxOverAll(mat));
    }

    static int findMaxOverAll(int mat[][]) {
        //initialize result
        int result = 1;
        //creates a loop for initializing all the values to -1
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        //computes the longest path beginning of all the cells.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1) {
                    findTheLongestFromACell(i, j, mat, dp);
                    //updates result if needed
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }

    static int findTheLongestFromACell(int i, int j, int mat[][], int dp[][]) {
        //Base case
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }
        //if this subproblem is already solved
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        //to store tha path length in all four directions
        int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;
        int z = Integer.MIN_VALUE;
        int w = Integer.MIN_VALUE;
        //since all numbers are unique and the range is from 1 to n*n
        //there is almost one possible direction from any cell
        if (j < n - 1 && ((mat[i][j] + 1) == mat[i][j + 1])) {
            x = dp[i][j] = 1 + findTheLongestFromACell(i, j + 1, mat, dp );
        }
        if (j > 0 && (mat[i][j] + 1 == mat[i][j - 1])) {
            y = dp[i][j] = 1 + findTheLongestFromACell(i, j, mat, dp);
        }
        if (i > 0 && ((mat[i][j] + 1) == mat[i - 1][j])) {
            z = dp[i][j] = 1 + findTheLongestFromACell(i - 1, j, mat, dp);
        }
        if (i < n - 1 && ((mat[i][j] + 1) == (mat[i + 1][j]))) {
            w = dp[i][j] = 1 + findTheLongestFromACell(i + 1, j, mat, dp);
        }
        // If none of the adjacent fours is one greater we will take 1
        // otherwise we will pick maximum from all the four directions
        return dp[i][j] = Math.max(x, Math.max(y, Math.max(z, Math.max(w, 1))));
    }
}
