package codingtest;

/**
 *  * The main function that returns number of ways to get sum 'x'
 *  * with 'n' dice and 'm' with m faces.
 * */
public class DiceTrownV2 {
    public static void main(String[] args) {
        System.out.println(findWays(4, 2, 1));
        System.out.println(findWays(2, 2, 3));
        System.out.println(findWays(6, 3, 8));
        System.out.println(findWays(4, 2, 5));
        System.out.println(findWays(4, 3, 5));
    }

    public static long findWays(int faces, int dice, int sum) {
        // Create a table to store results of subproblems.  One extra
        // row and column are used for simpilicity (Number of dice
        // is directly used as row index and sum is directly used
        // as column index).  The entries in 0th row and 0th column
        // are never used.
        long[][] mem = new long[dice + 1][sum + 1];
        // Table entries for no dices
        // If you do not have any data, then the value must be 0, so the result is 1
        mem[0][0] = 1;
        //iterates over the dices
        for (int i = 1; i <= dice; i++) {
            //iterates over the sums
            for (int j = i; j <= sum; j++) {
                // The result is obtained in two ways, pin the current dice and spending 1 of the value,
                // so we have mem[i-1][j-1] remaining combinations, to find the remaining combinations we
                // would have to pin the values ??above 1 then we use mem[i][j-1] to sum all combinations
                // that pin the remaining j-1's. But there is a way, when "j-f-1> = 0" we would be adding
                // extra combinations, so we remove the combinations that only pin the extrapolated dice face and
                // subtract the extrapolated combinations.
                mem[i][j] = mem[i][j - 1] + mem[i - 1][j - 1];
                if (j - faces - 1 >= 0) {
                    mem[i][j] -= mem[i - 1][j - faces - 1];
                }
            }
        }
        return mem[dice][sum];
    }

}
