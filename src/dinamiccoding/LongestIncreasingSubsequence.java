package dinamiccoding;

public class LongestIncreasingSubsequence {

    static int max_ref;

    public static void main(String[] args) {
        int[] array = {10, 22, 9, 33, 21, 50, 41, 60};
        int n = array.length;

        int result = longestIncreaseSequence(array, array.length);

        System.out.println(result);

        /**
        for (int i: lis) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(Arrays.asList(lis).stream().sorted().findFirst().get()[lis.length - 1]);
        */

    }

    static int lisv2(int arr[], int n) {
        int lis[] = new int[n];
        int i, j;
        int max = 0;
        //initializes the LIS values for all indexes
        for (i = 0; i < n; i++) {
            lis[i] = 1;
        }
        //Compute the optimized LIS values in bottom up manner
        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if ((arr[i] > arr[j]) && (lis[i] < lis[j] + 1)) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        //Picks maximum of all LIS values
        for (i = 0; i < n; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }

        return max;
    }

    static int lis(int array[], int n) {
        max_ref = 1;
        longestIncreaseSequence(array, n);
        return max_ref;
    }

    public static int longestIncreaseSequence(int[] array, int n) {
        /*
        This is the simplest base case, length of array equals 1
        * */
        if (n == 1) {
            return 1;
        }
        /*
        * max_ending_here variable is the length of the
        * longest increase sequence ending with array[n - 1]
        * */
        int res = 1;
        int max_ending_here = 1;

        /* Recursively get all LIS ending with arr[0],
           arr[1] ... arr[n-2]. If   arr[i-1] is smaller
           than arr[n-1], and max ending with arr[n-1] needs
           to be updated, then update it */
        for (int i = 1; i < n; i++) {
            res = longestIncreaseSequence(array, i);
            if ((array[i - 1] < array[n - 1]) && (res + 1 > max_ending_here)) {
                max_ending_here = res + 1;
            }
        }
        // Compare max_ending_here with the overall max. And
        // update the overall max if needed
        if (max_ref < max_ending_here) {
            max_ref = max_ending_here;
        }

        // Return length of LIS ending with arr[n-1]
        return max_ending_here;
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    /**
     * The belows method gets the longest
     * increasing consecutive subsequence
     **/

    /*
    public static int[] LICS(int[] array) {
        int counter = 0;
        int[] lengthssequence = new int[array.length];

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                counter++;
            }
            if (array[i] > array[i + 1] || (i + 1 == array.length - 1)) {
                lengthssequence[i] = counter;
                counter = 0;
            }
        }

        return lengthssequence;
    }*/
}
