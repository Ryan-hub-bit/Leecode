import java.util.Arrays;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start
class Main {
    public static void main(String[] args) {
        // Create a new Solution instance
        Solution solution = new Solution();
        // Create a test case
        int[] nums={1, 0, -1, 0, -2, 2};
        // Get the answer
         solution.fourSum(nums,0);
        // Print the answer

    }
}
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length<4)
           return res;
        if(nums.length==4)
        {
            if(nums[0]+nums[1]+nums[2]+nums[3]==target)
            {
               res.add(Arrays.asList(nums[0],nums[1],nums[2],nums[3]));
               return res;
            }
        }
         
        Arrays.sort(nums);
       
        for(int i=0;i<nums.length-3;i++)
        {
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int threeSum=target-nums[i];
            for(int j=i+1;j<nums.length-2;j++)
            {
                if(nums[j]==nums[j-1])
                    continue;

                int twoSum=threeSum-nums[j];
               
                int z=j+1,k=nums.length-1;
                while(z<k)
                {
                    if(twoSum==nums[z]+nums[k])
                    {
                        res.add(Arrays.asList(nums[i],nums[j],nums[z],nums[k]));
                        z++;
                        k--;
                        while(z<k&&nums[z]==nums[z-1]) z++;
                        while(z<k&&nums[k]==nums[k+1]) k--;
                    }
                    else if(twoSum>nums[z]+nums[k])
                    {
                        z++;
                    }
                    else{
                        k--;
                    }
                }
            }
           
        }
        return res;
    }
}
// @lc code=end

