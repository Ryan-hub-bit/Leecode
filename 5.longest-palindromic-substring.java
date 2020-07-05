/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
       if(s.length() == 0)
       {
           return "";
       } 
       boolean[][] dp = new boolean[s.length()][s.length()];
       int start = 0, end = 0;
       for(int i = 0; i < s.length(); i++)
       {
           for(int j = i; j>=0; j--)
           {
                boolean startEqEnd = s.charAt(i) == s.charAt(j);
                if(i == j)
                {   // a = a letter in the same position
                    dp[i][j] = true;
                }
                else if( i == j+1)
                {   // a = a or a = b  two letters in adjacent position, it depends on if they are equal

                    dp[i][j] = startEqEnd;
                }
                else if(startEqEnd && dp[i-1][j+1])
                {   // for two letters, if they are equal, we also need to see if the inner element are palindromic
                    //dp[i][j] 表示 i 和 j 之间的字符串是不是palindromic
                    dp[i][j] = true;
                }

                if(dp[i][j] && i - j > end - start)
                {
                   end = i; 
                   start = j;
                }
           }
       }
       return s.substring(start,end+1);
    }
}
// @lc code=end

