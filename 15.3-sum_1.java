/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
      //sort the array
        List<List<Integer>> threeS=new ArrayList<>();
        //for loop iterate the target=-nums[i], so in order to avoid duplication , i should <nums.length-2
        for(int i=0;i<nums.length-2;i++)
        {
           if(i>0&&nums[i]==nums[i-1])//skip the duplication
           {
               continue;
           }
           //two pointer from start to end
           int j=i+1,k=nums.length-1;
           //
           int target=-nums[i];
           while(j<k)
           {
               //if the target==nums[i]+nums[k];
               if(target==nums[j]+nums[k])
               {
                   //add it
                   threeS.add(Arrays.asList(nums[i],nums[j],nums[k]));
                   //j++,k-- and skip the duplication by comparing with the previous element
                   j++;
                   k--;
                   while(j<k&&nums[j]==nums[j-1]) j++;
                   while(j<k &&nums[k]==nums[k+1]) k--;
               }
               //classic binary search
               else if(target>nums[j]+nums[k])
                {
                    j++;
                }
                else {
                    k--;
                }
           }
        }
       return threeS;
    }
}
// @lc code=end

