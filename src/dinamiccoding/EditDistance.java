package dinamiccoding;

/**
 * The problem to find the number of combinations, operations necessary
 * to equals two strings, str1 and str2. ex: str1 = karel, str2 = karer,
 * the result is 1 since we have to substitute the last r in str2 by a l.
 * */

public class EditDistance {
    public static void main(String[] args) {
        String str1 = "Sunday";
        String str2 = "Saturday";

        //System.out.println(editDistance("Sunday", "Saturday",str1.length(), str2.length()));
        editDistanceOptimize(str1, str2);
    }

    static void editDistanceOptimize(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();

        int[][] DP = new int[2][length1 + 1];
        //base condition when second String
        //is empty then we remove all characters
        for (int i = 0; i <= length1; i++) {
            DP[0][i] = i;
        }
        //start filling the DP
        //this loop runs for every
        //character of the second String
        for (int i = 1; i <= length2; i++) {
            //this loop compares the char from
            //second String with the first String
            //characters
            for (int j = 0; j <= length1; j++) {
                //if the first String is empty
                //we have to perform add character
                //operation to get the second character
                if (j == 0) {
                    DP[i % 2][j] = i;
                }
                // if character from both String
                // is same then we do not perform any
                // operation . here i % 2 is for bound
                // the row number.
                else if (str1.charAt(j - 1) == str2.charAt(i - 1) ) {
                    DP[i % 2][j] = DP[(i - 1) % 2][j - 1];
                }
                else {
                    DP[i % 2][j] = 1 + Math.max(DP[(i - 1) % 2][j] , // insert
                            Math.max(DP[i % 2][j - 1],               // remove
                                    DP[(i - 1) % 2][j - 1]));        //replacce
                }
            }
        }
        System.out.println(DP[length2 % 2][length1]);
    }

    static int editDistance(String str1, String str2, int m, int n) {
        //create a table to store the subproblems
        int[][] dp = new int[m + 1][n + 1];
        //fills dp[][]
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                //if the fitst string is empty,
                //the solution is to add all the second string
                //characters into the first one...
                if (i == 0) {
                    dp[i][j] = j; // Min. operation. j
                }
                //if the second string is empty, then
                //have to fill it with all characters of the
                //first one
                else if (j == 0) {
                    dp[i][j] = i;
                }
                //if last characters are same, ignore them
                //and recur the others
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                //if the last character is different,
                //considers all the possibilities to find
                //the minimum.
                else
                    dp[i][j] = 1
                            + MIN(dp[i][j - 1], //insert
                            dp[i - 1][j],       //remove
                            dp[i - 1][j - 1]);  //replace
            }
        }
        return dp[m][n];
    }

    public static int MIN(int x, int y, int z) {
        if (x <= y && x <= z) {
            return x;
        }
        if (y <= x && y <= z) {
            return y;
        } else
            return z;
    }

}