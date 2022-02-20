package dinamiccoding;
/**
 * given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights
 * associated with n items respectively. Also given an integer W which represents knapsack capacity,
 * find out the maximum value subset of val[] such that sum of the weights
 * of this subset is smaller than or equal to W.
 * */
public class KnapsackProgram {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(knapSach(W, wt, val, n));
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    //returns the maximun value that can be retuned
    //to the rucksack of capacity W
    static int knapSach(int W, int wt[], int val[], int n) {
        //base case
        if (n == 0 || W == 0) {
            return 0;
        }
        //if weight of the nth item is
        //more than W then this item cannot
        //be invluded in the optimal solution
        if (wt[n - 1] > W) {
            return knapSach(W, wt, val, n - 1);
        }
        //return the maximum of the two cases
        //(1) nth item is included
        //(2) not included
        else
            return max(val[n - 1]
                            + knapSach(W - wt[n - 1], wt, val, n - 1)
            , knapSach(W, wt, val, n - 1));
    }

}
