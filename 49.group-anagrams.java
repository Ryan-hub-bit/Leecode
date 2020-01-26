import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Character,Integer> map =new HashMap<>();
        List<List<String>> list =new ArrayList<>();
        for(int i=0;i<strs.length;i++)
        {
            for(int j=0;j<strs[i].length();j++)
            {
                map.put(str.charAt(j),map.getOrDefault(str.charAt(j), 0)+1);
           }
           
              for(int z=0;z<list.size();z++)
              {
                    for(int k=0;k<list.get(z).size();k++)
                     {
                         
                     }
                }
          
        }
    }
}
// @lc code=end

