package dinamiccoding;

/**
 * Given n dice each with m faces, numbered from 1 to m, find the number of ways to get sum X.
 * X is the summation of values on each face when all the dice are thrown.
 * */

public class DiceThrow {
    public static void main(String[] args) {
        System.out.println(findWaysOptimized(4, 2, 1));
        System.out.println(findWaysOptimized(2, 2, 3));
        System.out.println(findWaysOptimized(6, 3, 8));
        System.out.println(findWaysOptimized(4, 2, 5));
        System.out.println(findWaysOptimized(4, 3, 5));
    }

    public static long findWays(int m, int n, int x) {
        long[][] table = new long[n + 1][x + 1];
        /*Table entries for only once dice*/
        for (int j = 1; j <= m && j <= x; j++) {
            table[1][j] = 1;
        }
        /* Fill rest of the entries in table using recursive relation
    i: number of dice, j: sum */
        for (int i = 2; i <= n; i ++) {
            for (int j = 1; j <= x; j ++) {
                for (int k = 1; k < j && k <= m; k ++) {
                    table[i][j] += table[i - 1][j - k];
                }
            }
        }
        return table[n][x];
    }

    public static long findWaysOptimized(int f, int d, int s) {
        // Create a table to store results of subproblems.  One extra
        // row and column are used for simpilicity (Number of dice
        // is directly used as row index and sum is directly used
        // as column index).  The entries in 0th row and 0th column
        // are never used.
        long mem[][] = new long[d + 1][s + 1];
        // Table entries for no dices
        // If you do not have any data, then the value must be 0, so the result is 1
        mem[0][0] = 1;
        //iterate over dices
        for (int i = 1; i <= d; i++) {
            //iterate over sum
            for (int j = i; j <= s; j++) {
                // The result is obtained in two ways, pin the current dice and spending 1 of the value,
                // so we have mem[i-1][j-1] remaining combinations, to find the remaining combinations we
                // would have to pin the values ??above 1 then we use mem[i][j-1] to sum all combinations
                // that pin the remaining j-1's. But there is a way, when "j-f-1> = 0" we would be adding
                // extra combinations, so we remove the combinations that only pin the extrapolated dice face and
                // subtract the extrapolated combinations.
                mem[i][j] = mem[i][j - 1] + mem[i - 1][j - 1];
                if (j - f - 1 >= 0) {
                    mem[i][j] -= mem[i - 1][j - f - 1];
                }
            }
        }
        return mem[d][s];
    }

}
