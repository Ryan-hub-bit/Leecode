import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0 || intervals == null)
        {
            return intervals;
        }
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] x, int[] y)
            {
                return x[0] == y[0] ? x[1] - y[1] : x[0] - y[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        int[] pre = intervals[0];
        
        for(int[] in : intervals)
        {
            if(pre[1] >= in[0])
            {
                if(pre[1] < in[1])
                {
                pre[1] = in[1];
                }
            }
            else{
             ans.add(pre);
             pre = in;   
            }
        }
        ans.add(pre);
        return ans.toArray(new int[ans.size()][2]);

    }
}
// @lc code=end

