/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
       //dp[i][j] 表示前i个元素和前j个元素匹配需要的最小操作数
       int n = word1.length();
       int m = word2.length();
       
       int[][] dp = new int[n+1][m+1];
       for(int i = 0; i < n+1; i++)
       {
           dp[i][0] = i;
       }

       for(int j = 0; j < m+1; j++)
       {
           dp[0][j] = j;
       }

       for(int i = 1; i < n+1; i++)
       {
           for(int j = 1; j < m+1; j++)
           {
               if(word1.charAt(i-1) == word2.charAt(j-1))
               {
                   dp[i][j] = dp[i-1][j-1];
               }
               else{
                   dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]))+1;
               }
           }
       }
       return dp[n][m];
    }
}
// @lc code=end

