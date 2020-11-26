import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       //dfs + memo 
       Map<Integer,Boolean> memo = new HashMap<>();
       return dfs(s, wordDict, 0, memo);
     
    }

    public boolean dfs(String s, List<String> wordDict, int start, Map<Integer,Boolean> memo)
    {
        if(start == s.length())
        {
            return true;
        }

        if(memo.containsKey(start))
        {
            return memo.get(start);
        }

        for(int end = start + 1; end <= s.length(); end++)
        {
            if(wordDict.contains(s.substring(start,end)) && dfs(s,wordDict,end,memo))
            {
                memo.put(start,true);
                return true;
            }
        }
        memo.put(start,false);
        return false;

        
    }
}
// @lc code=end

