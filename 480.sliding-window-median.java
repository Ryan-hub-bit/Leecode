import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=480 lang=java
 *
 * [480] Sliding Window Median
 */

// @lc code=start

//two priorityQueue<Integer>  and balance the number of each heap;
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length];
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
       for(int i=0; i<nums.length;i++)
       {
           if(i<k)
           {
               minHeap.add(nums[i]);
               continue;
           }
           else{

           }
       } 

    }
}
// @lc code=end

