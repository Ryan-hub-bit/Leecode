import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numb, int target) {
      Map<Integer,Integer> map=new HashMap<>();
      for(int i=0;i<numb.length;i++)
      {
          if(map.containsKey(target-numb[i]))
          {
              return new int[] {map.get(target-numb[i]),i};
          }
          map.put(numb[i],i);
    }
    
      return new int[] {0,0};
    }
}
// @lc code=end

