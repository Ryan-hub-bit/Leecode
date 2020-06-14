import java.util.Stack;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        //if(n)
        Stack<Integer> stk = new Stack<Integer>();   
        int i =0;
        int max =0;
        while(i<=n)
        {
            int h =(i==n ? 0 :heights[i]);
            if(stk.isEmpty() || heights[stk.peek()]<= h)
            {
                stk.push(i);
                i++;
            
               
            }
            else{
                int top =stk.pop();
                System.out.println(heights[top]);
                int area = heights[top] * (stk.isEmpty()?i :i-1-stk.peek());
               // System.out.println(heights[top]);
                //System.out.println(i);
                
                max = Math.max(area, max);

               // System.out.println(max);
            }

        }
        return max;
    }
}
// @lc code=end

