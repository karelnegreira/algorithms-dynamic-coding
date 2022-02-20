package dinamiccoding;
/**
 * Given a rope of length n meters, cut the rope in different parts of integer lengths
 * in a way that maximizes product of lengths of all parts.
 * You must make at least one cut. Assume that the length of rope is more than 2 meters.
 * */
public class MaximumProductCutting {
    public static void main(String[] args) {
        System.out.println("Maximum Product is "
                + maxProdDynamic(10));
    }

    static int maxProd(int n) {
        //base case
        if (n == 0 || n == 1)
            return 0;
        //make a cut at different places
        //and take the maximum of all
        int max_val = 0;
        for(int i = 1; i < n; i++) {
            max_val = Math.max(max_val, Math.max(i*(n - i), maxProd(n - i)*i));
        }
        //return the maximum of all value
        return max_val;
    }
    /*Dynamic programming solution*/
    static int maxProdDynamic(int n) {
        int[] val = new int[n + 1];
        val[0] = val[1] = 0;
        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int i = 1; i <= n; i++) {
            int max_val = 0;
            for (int j = 1; j <= i/2; j++) {
                max_val = Math.max(max_val, Math.max((i - j)*j, j*val[i - j]));
                val[i] = max_val;
            }
        }
        return val[n];
    }
}
