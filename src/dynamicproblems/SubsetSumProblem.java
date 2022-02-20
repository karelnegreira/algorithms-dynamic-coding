package dynamicproblems;
/*
* EL problema de la suma de subconjuntos es un problema
* importante en la teoria de la complejidad y la criptografia.
* El problemma es este: dado un conjunto de enteros,
* Existe algun subconjunto cuya suma sea exactamente un valor entero dado?
* */
public class SubsetSumProblem {
    public static void main(String[] args) {
        int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int n = set.length;
        if (subset(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }

    public static boolean subset(int[] set, int n, int sum) {
        boolean[][] subset = new boolean[sum + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            subset[0][i] = true;
        }

        for (int i = 1; i <= sum; i++) {
            subset[i][0] = false;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; i++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1]) {
                    subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
                }
            }
        }

        return subset[sum][n];
    }

    public static boolean subsetsum(int[] set, int m, int sum) {
        //the value of the subset subset[i][j] will be true
        //if there is a subset of set[0...j - 1] with
        //sum equals to i
        boolean[][] subset = new boolean[sum + 1][m + 1];
        //if the sum is zero the answer is true
        for (int i = 0; i <= m; i++) {
            subset[0][i] = true;
        }
        //if the sum is not zero
        //then the set is empty, so the
        //answer is false
        for (int i = 1; i <= sum; i++) {
            subset[i][0] = false;
        }
        //fill the table in
        //bottom up manner
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= m; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1]) {
                    subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
                }
            }
        }

        return subset[sum][m];
    }


}
