/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0)
        {
            return 0;
        }
        int[] ans = new int[s.length()+1];
        //在前边添加0这样第一个数也可以按照两位数来算,但是他两位数的结果为0
        ans[0] = 1;
        ans[1] = s.charAt(0) == '0' ? 0 :1;
        for(int i = 2; i < s.length()+1; i++)
        {
            if(s.charAt(i-1) != '0')
            {
                ans[i] = ans[i-1];
            }
            int tw =(s.charAt(i-2) - '0') * 10 +(s.charAt(i-1) - '0');
            if(tw >= 10 && tw <=26)
            {
                ans[i] += ans[i-2];
            }
        }
        return ans[s.length()];
        
    }
}
// @lc code=end

