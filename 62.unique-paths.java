/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    int[] dx = new int[]{1,0};
    int[] dy = new int[]{0,1};
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(i == 0 && j == 0)
                {
                    continue;
                }
                if(i == 0 || j == 0)
                {
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }

            }
        }
        return dp[n-1][m-1];
    }
}
// @lc code=end

