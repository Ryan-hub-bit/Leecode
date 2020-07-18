/*
 * @lc app=leetcode id=1269 lang=java
 *
 * [1269] Number of Ways to Stay in the Same Place After Some Steps
 */

// @lc code=start
class Solution {
    //dfs O(N) 3^steps
    public int numWays(int steps, int arrLen) {
        // write your code here
        if (steps == 0) {
            return 1;
        }
        arrLen = Math.min(arrLen, steps / 2 + 1);
        return dfs(0, steps, arrLen);
    }

    public int dfs(int position, int steps, int arrLen) {
        // cut off
        if (position < 0 || position >= arrLen) {
            return 0;
        }
        // boundary condition
        if (steps == 0) {
            if (position != 0) {
                return 0;
            }
            return 1;
        }
        // recursive
        return dfs(position + 1, steps - 1, arrLen) + dfs(position, steps - 1, arrLen)
                + dfs(position - 1, steps - 1, arrLen);
    }
}
// @lc code=end

