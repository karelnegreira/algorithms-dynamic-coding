package codingtest;

public class SubsetSumProblem {
    public static void main(String[] args) {
        int[] set = {3, 5, 6, 2};
        int sum = 16;
        int length = set.length;

        System.out.println(isSumDynamicSolution(set, length, sum));
    }

    public static boolean isSumDynamicSolution(int[] set, int length, int sum) {
        boolean[][] subset = new boolean[sum + 1][length + 1];
        //if sum is zero then it is all true
        for (int i = 0; i <= length; i++) {
            subset[0][i] = true;
        }
        //if the length is zero then its false
        for (int i = 1; i <= sum; i++) {
            subset[i][0] = false;
        }
        //build the table
        //in up bottom matter
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= length; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1]) {
                    subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
                }
            }
        }
        return subset[sum][length];
    }

    /**Naive solution of the isSum per target subset algorithm*/
    public static boolean isSum(int[] set, int length, int sum) {
        if (length == 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        if (set[length - 1] > sum) {
            return isSum(set, length - 1, sum);
        } else {
            return isSum(set, length - 1, sum)
                    || isSum(set, length - 1, sum - set[length - 1]);
        }
    }
}
