package dinamiccoding;
/**
 * Given a rod of length n inches and an array of prices that includes
 * prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces
 * */
public class CuttingRod {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum obtained prices is: " + rodCuttingDynamic(arr, size));
    }

    public static int rodCutNaive(int[] prices, int length) {
        if (length <= 0) {
            return 0;
        }
        int max_value = Integer.MIN_VALUE;
        //recursively cut rod in different possitions
        //and compare different configurations
        for (int i = 0; i < length; i++) {
            max_value = Math.max(max_value, prices[i] + rodCutNaive(prices, length - i - 1));
        }
        return max_value;
    }

    /**A Dynamic programming solution for Rod cutting problem*/
    static int rodCuttingDynamic(int[] prices, int size) {
        int[] val = new int[size + 1];
        val[0] = 0;
        //builds the table val[] in buttom-up manner
        //and return the last entry of the table
        for (int i = 1; i <= size; i++) {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max_val = Math.max(max_val, prices[j] + val[i - j - 1]);
            }
            val[i] = max_val;
        }
        return val[size];
    }
}
