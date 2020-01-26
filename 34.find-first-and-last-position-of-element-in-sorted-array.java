/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)
        {
            return new int[]{-1,-1};
        }
        if(nums.length==1)
        {
            if(nums[0]==target)
            {
                return new int[]{0,0};
            }
            else {
                return new int[]{-1,-1};
            }
        }
        int max=binarySearch(nums,target,true);
        int min=binarySearch(nums,target,false);
        int[] ans=new int[2];
        ans[0]=min;
        ans[1]=max;
        return ans;
        
    }
    public int binarySearch(int[] nums,int target,boolean max)
    {   
        int low=0,hi=nums.length-1;
        while(low<=hi)
        {
            int mid=(low+hi)/2;
            if(nums[mid]==target){
                if(max&&mid+1<nums.length&&nums[mid+1]==target)
                {
                    low=mid+1;
                }
                else if(!max&&mid-1>=0&&nums[mid-1]==target)
                {
                    hi=mid-1;
                }
                else
                {
                    return mid;
                }
            }

            if(nums[mid]<target)
            {
                low=mid+1;
            }
            else if(nums[mid]>target)
            {
                hi=mid-1;
            }
            
            
        }
        return -1;
    }
}
// @lc code=end

