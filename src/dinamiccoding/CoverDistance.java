package dinamiccoding;

public class CoverDistance {
    public static void main(String[] args) {
        //System.out.println(coverDist(4));
        //System.out.println(optimalCoverDist(4));
        System.out.println(mostOptimalWayToCoverSet(4));
    }

    public static int coverDist(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return coverDist(n - 1) + coverDist(n - 2) + coverDist(n - 3);
    }
/**
    Algorithm:

    Create an array of size n + 1 and initialize the first 3 variables with 1, 1, 2. The base cases.
    Run a loop from 3 to n.
    For each index i, compute value of ith position as dp[i] = dp[i-1] + dp[i-2] + dp[i-3].
    Print the value of dp[n], as the Count of number of ways to cover a distance.
 */
    public static int optimalCoverDist(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        if (n >= 1) {
            count[1] = 1;
        }
        if (n >= 2) {
            count[2] = 2;
        }
        for (int i = 3; i <= n; i ++) {
            count[i] = count[i - 1] + count[i - 2] + count[ i - 3];
        }
        return count[n];
    }

    /**
     * MORE OPTIMAL SOLUTION
     *     Create an array of size 3 and initialize the values for step 0,1,2 as 1,1,2 (Base cases).
     *     Run a loop from 3 to n(dist).
     *     For each index compute the value as ways[i%3] = ways[(i-1)%3] + ways[(i-2)%3] + ways[(i-3)%3] and store its value at i%3 index of array ways. If we are computing value for index 3 then the computed value will go at index 0 because for larger indices(4 ,5,6…..) we don’t need the value of index 0.
     *     Return the value of ways[n%3].
     * */
    public static int mostOptimalWayToCoverSet(int n) {
        int ways[] = new int[3];
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 2;

        for (int i = 3; i <= n; i++) {
            ways[i % 3] = ways[(i - 1) % 3] + ways[(i - 2) % 3] + ways[(i - 3) % 3];
        }
        return ways[n % 3];
    }

}
