package dynamicproblems;

/*
 *This is a problem where we find the longest increasing subsequence in a given array, example:
 * lets array {10, 12, 33, 5, 2, 55}, here the LIS is {10, 12, 33, 55} so the result is 4.
 * */
public class LIS {
    static int max_ref;

    public static void main(String[] args) {
        int[] array = {10, 12, 33, 5, 2, 55};
        int n = array.length;

        int r = lis(array, n);

        System.out.println(r);
    }

    private static int lis(int[] array, int n) {
        int[] table = new int[n];
        int i, j;
        int max = 0;

        for (i = 0; i < n; i++) {
            table[i] = 1;
        }

        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if ((array[i] > array[j]) && (table[i] < table[j] + 1)) {
                    table[i] = table[j] + 1;
                }
            }
        }

        for ( i = 0; i < n; i++) {
            if (max < table[i]) {
                max = table[i];
            }
        }
        return max;
    }


    /**Dynamic Programing Java implementation*/


    public  static int LIS(int[] array, int n) {
        max_ref = 1;
        longestincreasingsubsequence(array, n);
        return max_ref;
    }

    private static int longestincreasingsubsequence(int[] array, int n) {
        if (n == 1) {
            return 1;
        }

        int res = 1;
        int max_index_here = 1;

        for (int i = 1; i < n; i++) {
            res = longestincreasingsubsequence(array, i);
            if ((array[i - 1] < array[n - 1]) && (res + 1 > max_index_here)) {
                max_index_here = res + 1;
            }
        }
        if (max_ref < max_index_here) {
            max_ref = max_index_here;
        }

        return max_index_here;
    }
}
