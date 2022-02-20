package codingtest;

/**
 * Given a rod of length n inches and an array of prices that includes prices
 * of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * Given a method curRod with paremeters  int length, then the solution
 * cna be expressed like:
 * cutRod(n) = max(price[i] + cutRod(n-i-1)) for all i in {0, 1 .. n-1}
 * */
public class CutRodProblem {
    public static void main(String[] args) {
        int[] array = {1, 5, 8, 9, 10, 17, 17, 20};
        int size = array.length;

        System.out.println(cutRodV2(array, size));
    }

    /**
     * <<the problem here is the overlapping subproblem property, so has to be
     *      * <<solved by dynamic programming, using a int[] val matrix in bottom up
     *      * <<manner as per method below.
     * */
    public static int cutRodV2(int[] array, int length) {
        int[] vals = new int[length + 1];
        vals[0] = 0;

        for (int i = 1; i <= length; i++) {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max_val = Math.max(max_val, array[j] + vals[i - j - 1]);
            }
            vals[i] = max_val;
        }
        return vals[length];
    }
    /**Non dynamic naive solution for the optimal problem of ontaining
     * the maximal sum, given a length and each cut with a weight assigned on it
     * */
    public static int cutRod(int[] array, int length) {
        if (length <= 0) {
            return 0;
        }
        int max_value = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            max_value = Math.max(max_value,  array[i] + cutRod(array, length - i - 1)); //recursively obtains the value
        }
        return max_value;
    }
}
