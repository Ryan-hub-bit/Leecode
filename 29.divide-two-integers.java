/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {

        if(dividend==0)
        return 0;
        int sum=0, n=0,dflag=1,rflag=1;
        if(dividend>=Integer.MAX_VALUE||dividend<=Integer.MIN_VALUE)
        {
            dividend=(dividend>0||divisor>0)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            return dividend;
        }
        if(dividend<0)
        {
            dividend=-dividend;
         dflag=-1;
        }
         if(divisor<0)
         {
             divisor=-divisor;
         rflag=-1;
         }
        while(sum<=dividend)
        {
            sum+=divisor;
            n++;
        }
        return rflag*(n-1)*dflag;
    }
}
// @lc code=end

