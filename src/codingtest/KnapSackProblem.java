package codingtest;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get
 * the maximum total value in the knapsack. In other words, given two integer
 * arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items
 * respectively. Also given an integer W which represents knapsack capacity, find out the maximum
 * value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 * */
public class KnapSackProblem {
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println("The optimal value is: " + knapSackDynamic(W, wt, val, n));
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static int knapSack(int W, int wt[], int val[], int n) {
        //base case
        if (n == 0 || W == 0) {
            return 0;
        }
        // If weight of the nth item is
        // more than Knapsack capacity W,
        // then this item cannot be included
        // in the optimal solution
        if (wt[n - 1] > W) {
            return knapSack(W, wt, val, n - 1);
        }
        // Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        else {
            return max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),
                    knapSack(W, wt, val, n - 1) );
        }
    }
    /**Dynamic programming solution - 0 1 RuckSack problem */
    static int knapSackDynamic(int W, int wt[], int val[], int n) {
        int[][] K = new int[n + 1][W + 1];
        int i, w;
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                } else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }
        return K[n][W];
    }

}
