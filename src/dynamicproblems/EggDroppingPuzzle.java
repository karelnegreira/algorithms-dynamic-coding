package dynamicproblems;

/*
* Is the problem where you have to find how many
* eggs are necessary to find out which is the
* optimal height of a 100 floor builden, that
* when you drop them one by one, the eggs
* get broken
* */
public class EggDroppingPuzzle {
    public static void main(String[] args) {
        int n = 2, k = 10;

        System.out.print("Minimum number of "
                + "trials in worst case with "
                + n + " eggs and " + k
                + " floors is " + dynamicegg(n, k));
    }

    private static int dynamicegg(int n, int k) {
        int[][] eggfloor = new int[n + 1][k + 1];
        int res;
        int i, j, x;

        for (i = 1; i < n; i++) {
            eggfloor[i][1] = 1;
            eggfloor[i][0] = 0;
        }

        for (j = 1; j <= k; j++) {
            eggfloor[1][j] = j;
        }

        for (i = 2; i <= n; i++) {
            for (j = 2; j <= k; j++) {
                eggfloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++) {
                    res = 1 + Math.max(eggfloor[i - 1][x - 1], eggfloor[i][j - x]);
                    if (res < eggfloor[i][j]) {
                        eggfloor[i][j] = res;
                    }
                }
            }
        }
        return eggfloor[n][k];
    }


    public static int eggdropdynamic(int n, int k) {
        int[][] eggfloor = new int[n + 1][k + 1];
        int res;
        int i, j, x;
        //we need one trial for one floor
        //and zero trial for - floor
        for (i = 1; i < n; i++) {
            eggfloor[i][1] = 1;
            eggfloor[i][0] = 0;
        }
        //we always need j trial for one egg
        //and j floor
        for (j = 1; j <= k; j++) {
            eggfloor[1][j] = j;
        }
        //fill the rest of entries in the table
        //using optimal subsrtucture property
        for (i = 2; i <= n; i++) {
            for (j = 2; j <= k; j++) {
                eggfloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++) {
                    res = 1 + Math.max(eggfloor[i - 1][x - 1], eggfloor[i][j - x]);
                    if (res < eggfloor[i][j]) {
                        eggfloor[i][j] = res;
                    }
                }
            }
        }

        return eggfloor[n][k];
    }
}
