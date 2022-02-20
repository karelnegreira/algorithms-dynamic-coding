package codingtest;

/**
 * Given a rope of length n meters, cut the rope in different parts of integer lengths
 * in a way that maximizes product of lengths of all parts.
 * You must make at least one cut. Assume that the length of rope is more than 2 meters.
 * */

public class MaxProductCutRope {
    public static void main(String[] args) {
        System.out.println("The maximum product is: " + maxProd(10));
    }

    public static int maxProd(int n) {
        int[] values = new int[n + 1];
        values[0] = 0;
        values[1] = 0;

        for (int i = 1; i <= n; i++) {
            int max_value = 0;
            for (int j = 0; j < i / 2; j++) {
                max_value = Math.max(max_value, Math.max((i - j)*j, values[i - j]*j));
                values[i] = max_value;
            }
        }
        return values[n];
    }

    public static int maxProductV2(int n) {
        int[] values = new int[n + 1];
        values[0] = 0;
        values[1] = 0;

        for (int i = 1; i <= n; i++) {
            int max_val = 0;
            for (int j = 1; j <= i/2; j++) {
                max_val = Math.max(max_val, Math.max((i - j)*j, j*values[i - j]));
                values[i] = max_val;
            }
        }
        return values[n];
    }
}
