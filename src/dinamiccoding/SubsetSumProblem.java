package dinamiccoding;

/**
 * Given a set of non-negative integers, and a value sum,
 * determine if there is a subset of the given set with sum equal to given sum.
 * */
public class SubsetSumProblem {
    public static void main(String[] args) {
        int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 900;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }

    public static boolean sumSubSetRecurrency(int[] set, int n, int sum) {
        if (sum == 0) {
            return  true;
        }
        if (n == 0) {
            return false;
        }
        if (set[n - 1] > sum) {
            return sumSubSetRecurrency(set, n - 1, sum); // if last element greater than sum, ignore it
        }
          /* else, check if sum can be obtained
        by any of the following
            (a) including the last element
            (b) excluding the last element */
        return sumSubSetRecurrency(set, n - 1, sum) ||
                sumSubSetRecurrency(set, n - 1, sum - set[n - 1]);
    }

    public static boolean isSubsetSum(int[] set, int n, int sum) {
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        boolean subset[][] = new boolean[sum + 1][n + 1];
        //If the sum is zero the answer is true
        for (int i = 0; i <= n; i++) {
            subset[0][i] = true;
        }
        //IF the sum is not 0 and the
        //set is empty, the answer is false
        for (int i = 1; i <= sum; i++) {
            subset[i][0] = false;
        }
        //Fill the subset table
        // from bottom to
        //up manner
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1]) {
                    subset[i][j]  = subset[i][j] || subset[i - set[j - 1]][j - 1];
                }
            }
        }
        return subset[sum][n];
    }

}
