package dinamiccoding;

/*
* How many eggs will i use to find out
* the height an egg breaks if I throw them from
* a building with 100 floor. What is the minimum
* number of eggs I need.
* */

public class EggDroppingPuzzle {
    public static void main(String[] args) {
        int n = 2, k = 10;

        System.out.print("Minimum number of "
                + "trials in worst case with "
                + n + " eggs and " + k
                + " floors is " + eggDropDynamic(n, k));
    }

    /**
     * Function to get minimum number of
     * trials needed in worst case with
     * n eggs and k floors
     * */
    static int eggDrop(int n, int k) {
        //if there is no floors,
        //then there is no trials needed. OR
        //if there is one floor, one trial needed
        if (k == 1 || k == 0) {
            return k;
        }
        //we need k trials for one egg
        //and k floors
        if (n == 1) {
            return k;
        }
        int min = Integer.MAX_VALUE;
        int res;
        //Considere all dropping from
        //1 to kth and return
        //the minimum of this plus 1
        for (int x = 1; x <= k; x ++) {
            res = Math.max(eggDrop(n - 1, x - 1), eggDrop(n, k - x));
            if (res < min) {
                min = res;
            }
        }
        return min + 1;
    }

    /**
     * Dynamic programming approach
     * */

    static int max1(int a, int b) {
        return (a > b) ? a : b;
    }
    /**
     * Function to get minimum number
     * of trials needed in worse case which
     * have kth floors with n eggs
     * */
    public static int eggDropDynamic(int n, int k) {
               /* A 2D table where entry eggFloor[i][j]
 will represent minimum number of trials
needed for i eggs and j floors. */
        int eggFloor[][] = new int[n + 1][k + 1];
        int res;
        int i, j, x;
        //we need one trial for one floor
        //and 0 trial for 0 floors
        for (i = 1; i < n; i++) {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }
        //we always need j trial for one egg
        //and j floor
        for (j = 1; j <= k; j ++) {
            eggFloor[1][j] = j;
        }
        // Fill rest of the entries in table using
        // optimal substructure property
        for (i = 2; i <= n; i ++) {
            for (j = 2; j <= k; j ++) {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x ++) {
                    res = 1 + max1(
                            eggFloor[i - 1][x - 1], eggFloor[i][j - x]
                    );
                    if (res < eggFloor[i][j]) {
                        eggFloor[i][j] = res;
                    }
                }
            }
        }
        //eggFloor[n][k] holds the result
        return eggFloor[n][k];
    }

}
