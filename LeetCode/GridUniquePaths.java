package LeetCode;

import java.util.Arrays;

//URL:https://leetcode.com/problems/unique-paths

public class GridUniquePaths {

    public int uniquePaths(int m, int n) {          //Best approach
        int N = m + n - 2;
        int r = m - 1;
        double res = 1;
        for(int i = 1; i <= r; i++){
            res = res * (N - r + i) / i;
        }
        return (int)res;
    }

    public int approach2(int m, int n) {           //Approach 2 T(n*m) S(n*m)
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return pathCounts(0, 0, m - 1, n - 1, dp);
    }

    public int pathCounts(int i, int j, int m, int n, int[][] dp) {
        if (i == m && j == n) {
            return 1;
        }
        if (i > m || j > n) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        } else {
            return dp[i][j] = pathCounts(i + 1, j, m, n, dp) + pathCounts(i, j + 1, m, n, dp);
        }
    }
}
