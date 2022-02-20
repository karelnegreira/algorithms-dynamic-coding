package codingtest;

public class LongestIncreasingSubsequence {
    static int max_ref;

    public static void main(String[] args) {
        int[] array = {10, 22, 9, 33, 21, 50, 41, 60};
        int length = array.length;
        System.out.println(LIS(array, length));
    }

    public static int LIS(int[] array, int length) {
        if (length == 1) {
            return 1;
        }
        int res = 1;
        int end_here = 1;

        for (int i = 1; i < length; i++) {
            res = LIS(array, i);
            if ((array[i - 1] < array[length - 1]) && (res + 1 > end_here)) {
                end_here = res + 1;
            }
        }
        return end_here;
    }
}
