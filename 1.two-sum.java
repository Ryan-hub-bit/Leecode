import java.util.Map;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
       int[] ans = new int[2];
       if(nums.length == 0)
       {
           return ans;
       } 
       Map<Integer,Integer> map = new HashMap<>();
       for(int i = 0; i < nums.length; i++)
       {
           if(map.containsKey(target-nums[i]))
           {
               ans[0] = map.get(target-nums[i]);
               ans[1] = i;
               return ans;
           }
           else{
               map.put(nums[i],i);
           }
       }
       return new int[]{-1,-1};
    }
}
// @lc code=end

