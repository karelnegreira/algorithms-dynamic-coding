package dinamiccoding;

public class MinimalPartition {
    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 2, 2, 1};
        int length  = arr.length;

        System.out.println("The optimal difference between two partitions is: " + findMin(arr, length));
    }

    public static int findMinRec(int array[], int i, int sumCalculated, int sumTotal) {
        //if we have reached the last element
        //The Sum of one subset is sumCalculated
        //the Sum of other subset is sumTotal - sumCalculated
        //It returns the absolute difference of two Sums
        if (i == 0) {
            return Math.abs((sumTotal - sumCalculated) - sumCalculated);
        }
        //for every item arr[i] we have two choices
        //(1) we do not include it first set
        //(2) we include it in first set
        //we return minimum of two choices
        return Math.min(findMinRec(array, i - 1,
                        sumCalculated + array[i - 1], sumTotal),
                findMinRec(array, i - 1, sumCalculated, sumTotal));
    }

    public static int findMin(int[] array, int n) {
        //compute total sum of elements
        int sumTotal = 0;
        for (int i = 0; i < n; i++) {
            sumTotal += array[i];
        }

        return findMinRec(array, n, 0, sumTotal);
    }
    /**
     * The above is the dynamic approach
     * */

    public static int minPartition(int[] array, int n){
       //calculate the sum of all elements
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        //creates an array to store
        //results of subproblems
        boolean dp[][] = new boolean[n + 1][sum + 1];
        //initialize first column as true
        //0 SUM is possible with all elements
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        //initialize the top row, except dp[0][0]
        //as false, with 0 elements, no other
        //sum except 0 is possible
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }
        //fill the partition table
        //in button up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                //if ith element is included
                if (array[i - 1] <= j)
                    dp[i][j] |= dp[i - 1][j - array[i - 1]];
            }
        }
        //initialize the diference of the two sums
        int diff = Integer.MAX_VALUE;
        // Find the largest j such that dp[n][j]
        // is true where j loops from sum/2 t0 0
        for (int j = sum / 2; j >= 0; j--) {
            //find the
            if (dp[n][j] == true) {
                diff = sum - 2*j;
                break;
            }
        }
        return diff;
    }
}
