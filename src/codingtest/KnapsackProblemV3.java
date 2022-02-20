package codingtest;

public class KnapsackProblemV3 {
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(snapsack_optimus(W, val, wt, n));
    }

    public static int snapsack_optimus(int W, int[] vals, int[] wt, int n) {
       int[][] K = new int[n + 1][W + 1];
       int i, w;

       for (i = 0; i <= n; i++) {
           for (w = 0; w <= W; w++) {
               if (i == 0 || w == 0) {
                   K[i][w] = 0;
               } else if (wt[i - 1] <= w) {
                   K[i][w] = Math.max(vals[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w] );
               } else {
                   K[i][w] = K[i - 1][w];
               }
           }
       }

       return K[n][W];
    }


    /**Naive solution for the rucksack problem*/
    public static int knapsack (int W, int[] vals, int[] wt, int n) {
        if (W == 0 || n == 0) {
            return 0;
        } else if (wt[n - 1] > W) {
            return knapsack(W, vals, wt, n - 1);
        } else {
            return Math.max(vals[n - 1] + knapsack(W - wt[n - 1], vals, wt, n - 1),
                    knapsack(W, vals, wt, n - 1));
        }
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
