package dynamicproblems;

/**
 * se tiene un arreglo de valores y otro con el peso de cada
 * uno, se desea determinar la combinacion que hace que
 * la suma de los valores sea maxima.
 * */
public class KnapsackProblem {
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        int n = val.length;

        System.out.println("OPTIMAL: " + knapSack(W, val, wt, n));
    }

    public static int knapSack(int W, int vals[], int wt[], int size) {
        int[][] DP = new int[size + 1][W + 1];
        int i, j;

        for (i = 0; i <= size; i++) {
            for (j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    DP[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    DP[i][j] = Math.max(vals[i - 1] + DP[i - 1][j - wt[i - 1]], DP[i - 1][j]);
                } else {
                    DP[i][j] = DP[i - 1][j];
                }
            }
        }
        return DP[size][W];
    }
}
