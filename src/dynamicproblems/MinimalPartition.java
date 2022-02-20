package dynamicproblems;

/**
 * Encontrar la particion mas pequena existente en un arreglo determinado,
 * digase {3, 1, 4, 2, 2, 1} --> aqui [3, 1] [1, 4] [4, 2][ 2, 1] [3, 4] [3, 2][3, 1]
 * [1, 2]...
 * la particicon mas pequena es 1...
 * */

public class MinimalPartition {
    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 2, 2, 1};
        int m = arr.length;

        System.out.println(minimalpartition(arr, m));
    }

    private static int minPartition(int[] array, int m) {
        //declare the SUM of array's all elements
        int sum = 0;
        //get the sum
        for (int i = 0; i < m; i++) {
            sum += array[i];
        }
        //creates an array to store
        //results of subproblems
        boolean[][] dp = new boolean[m + 1][sum + 1];
        //initialize first column as true
        //0 SUM is possible with all elements
        for (int i = 0; i <= m; i++) {
            dp[i][0] = true;
        }
        //initialize the top row, except dp[0][0]
        //as false, with 0 elements, no other
        //sum except 0 is possible
        for (int i = 0; i <= sum; i++) {
            dp[0][i] = false;
        }
        //fill the partition table
        //in button up manner
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (array[i - 1] <= j) {
                    dp[i][j] |= dp[i - 1][j - array[i - 1]];
                }
            }
        }
        //initialize the diference of the two sums
        int diff = Integer.MAX_VALUE;
        for (int k = sum / 2; k >= 0; k--) {
            // Find the largest j such that dp[n][j]
            // is true where j loops from sum/2 t0 0
            if (dp[m][k] == true) {
                diff = sum - 2*k;
                break;
            }
        }

        return diff;
    }

    public static int minimalpartition(int[] array, int m) {
       int sum = 0;
       for (int i = 0; i < m; i++) {
           sum += array[i];
       }
       boolean[][] dp = new boolean[m + 1][sum + 1];

       for (int i = 0; i <= m; i++) {
           dp[i][0] = true;
       }

       for (int j = 0; j <= sum; j++) {
           dp[0][j] = false;
       }

       for (int i = 1; i <= m; i++) {
           for (int j = 1; j <= sum; j++) {
               dp[i][j] = dp[i - 1][j];
               if (array[i - 1] <= j) {
                   dp[i][j] |= dp[i - 1][j - array[i - 1]];
               }
           }
       }
       int diff = Integer.MAX_VALUE;
       for (int k = sum / 2; k >= 0; k--) {
           if (dp[m][k] == true) {
               diff = sum - 2*k;
               break;
           }
       }

       return diff;
    }

}
