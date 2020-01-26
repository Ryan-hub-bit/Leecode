/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set=new HashSet<>();
        //define a max to record the max size , and a i to remove from the begining of the set, and j to add elements  if there is not repeating word in the set 
        int max=0,i=0,j=0;
        while(j<s.length())
        {
            //use the first one to add element if there is no existing elemetn in the set
            if(!set.contains(s.charAt(j)))
            {
               set.add(s.charAt(j++));
               max=Math.max(max,set.size());
            }
            //else  use the begining of 
            else{
                set.remove(s.charAt(i++));
            }
           
        }
        return max;

    }
}
// @lc code=end

