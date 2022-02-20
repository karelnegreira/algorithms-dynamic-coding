package dinamiccoding;

import java.util.Arrays;

public class BooleanParenthizationProblemV2 {

    public static void main(String[] args) {
        String symbols = "TTFT";
        String operators = "|&^";
        StringBuilder S = new StringBuilder();
        int j = 0;

        for (int i = 1; i < symbols.length(); i++) {
            S.append(symbols.charAt(i));
            if (j < operators.length()) {
                S.append(operators.charAt(j++));
            }
        }
        //We obtain the String T|T&F^T
        int N = S.length();
        // There are 4 ways
        // ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and
        // (T|((T&F)^T))
        System.out.println(countWays(N, S.toString()));
    }

    public static int countWays(int N, String S) {
        int dp[][][] = new int[N+1][N+1][2];
        for (int row[][]: dp) {
            for (int col[]: row) {
                Arrays.fill(col, -1);
            }
        }
        return parenthesis_count(S, 0, N - 1, 1, dp);
    }

    private static int parenthesis_count(String s, int i, int j, int isTrue, int[][][] dp) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if (isTrue == 1) {
                return (s.charAt(i) == 'T') ? 1 : 0;
            } else {
                return (s.charAt(i) == 'F') ? 1 : 0;
            }
        }
        if (dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue];
        }
        int temp_ans = 0;
        int leftTrue, rightTrue, leftFalse, rightFalse;

        for (int k = i + 1; k <= j - i; k = k + 2) {
            if (dp[i][k - 1][1] != -1) {
                leftTrue = dp[i][k - 1][1];
            } else {
                //Count number of TRUE in the left partition
                leftTrue = parenthesis_count(s, i, k - 1, 1, dp);
            }
            if (dp[i][k - 1][0] != -1) {
                leftFalse = dp[i][k - 1][0];
            } else {
                leftFalse = parenthesis_count(s, i, k - 1, 0, dp);
            }
            if (dp[k + 1][j][1] != -1) {
                rightTrue = dp[k + 1][j][1];
            } else {
                //Count number of TRUE in the right position
                rightTrue = parenthesis_count(s, k + 1, j, 1, dp);
            }
            if (dp[k + 1][j][0] != -1) {
                rightFalse = dp[k + 1][j][0];
            } else {
                //Counts the number of FALSE in the right position
                rightFalse = parenthesis_count(s, k + 1, j, 0, dp);
            }
            //Evaluate AND operator
            if (s.charAt(k) == '&') {
                if (isTrue == 1) {
                    temp_ans = temp_ans + leftTrue * rightTrue;
                } else {
                    temp_ans = temp_ans
                            + leftTrue * rightFalse
                            + leftFalse * rightTrue
                            + leftFalse * rightFalse;
                }
            }
            //Evaluate OR operator
            else if (s.charAt(k) == '|') {
                if (isTrue == 1) {
                    temp_ans = temp_ans
                            + leftTrue * rightTrue
                            + leftTrue * rightFalse
                            + leftFalse * rightTrue;
                } else {
                    temp_ans = temp_ans + leftFalse * rightFalse;
                }
            }
            //Evaluate XOR operator
            else if (s.charAt(k) == '^') {
                if (isTrue == 1) {
                    temp_ans = temp_ans
                            + leftTrue * rightFalse
                            + leftFalse * rightTrue;
                } else {
                    temp_ans = temp_ans
                            + leftTrue * rightTrue
                            + leftFalse * rightFalse;
                }
            }
            dp[i][j][isTrue] = temp_ans;
        }
        return temp_ans;
    }
}
