/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
       // we need to count the number of the left parentheses
       // if the number of the left parentheses > 0
       // which means it probably has some valid parentheses
       // we just add 2 cuz the size of the parentheses is 2 
       // then we need to make sure we add some other valid parentheses like ()(())
       // so we need to verify if the index of i - dp[i] >=0 if >= 0 we need to  add the number of them 
       //dp[i] means the longest valid parentheses in the current position
       // then we get the longest valid parentheses  globally.

       int n = s.length();
       if(n == 0)
       {
           return 0;
       }
       int[] dp = new int[n+1];
       dp[0] = 0;
       int leftCount = 0;
       int ans = 0;
       for(int i = 1; i < n+1; i++)
       {
            if(s.charAt(i-1) == '(')
            {
                leftCount++;
            }else if (leftCount > 0 && s.charAt(i-1) == ')')
            {
                dp[i] = dp[i-1] + 2;
                dp[i] += (i-dp[i]) >= 0 ? dp[i-dp[i]]: 0;
                ans = Math.max(ans,dp[i]);
                leftCount--;

            }
        
       }
       return ans;

    }
}
// @lc code=end

