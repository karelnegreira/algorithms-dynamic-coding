package dynamicproblems;
/**
 * Given a rope of length N, cutting it in pieces,
 * to obtain the maximun value the product of the
 * partitions whous lengths are integers and check
 * the maximun product
 * */
public class MaxProductCutRope {
    public static void main(String[] args) {
        System.out.println(maxProd(10));
    }

    public static int maxProd(int n) {
        int[] val = new int[n + 1];
        val[0] = 0;
        val[1] = 0;

        for (int i = 1; i <= n; i++) {
            int max_val = 0;
            for (int j = 0; j <= i / 2; j++) {
                max_val = Math.max(max_val, Math.max((i - j)*j, j*val[i - j]));
            }
            val[i] = max_val;
        }
        return val[n];
    }

}
