/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
       
    }
    public void backtrack(List<String> ans,String str,int open,int closed,int max)
    {
        if(str.length()==max*2)
        {
            ans.add(str);
           return;
        }
        if(open<max)
         backtrack(ans,str+"(",open+1,closed,max);
        if(closed<open)
        backtrack(ans,str+")",open,closed+1,max);

    }
}
// @lc code=end

