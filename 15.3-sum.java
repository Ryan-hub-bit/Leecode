/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++)
        {
          if(i>0&&nums[i]==nums[i-1])
                 continue;
            int j=i+1,k=nums.length-1;
            int target=-nums[i];
            while(j<k)
            {
              if(target==nums[j]+nums[k])
              {
                  res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                  j++;
                  k--;
                  while(j<k&&nums[j]==nums[j-1]) j++;
                  while(j<k&&nums[k]==nums[k+1]) k--;
                  
              }
              else if(target>nums[j]+nums[k])
              {
                  j++;
              }
              else{
                 k--;
              }

            
            }
            
        }
        return res;
    }
}
// @lc code=end

