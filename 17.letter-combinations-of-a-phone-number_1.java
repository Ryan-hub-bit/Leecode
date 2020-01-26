/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        String[] digitsLetter={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans =new ArrayList<>();
        if(digits.length()==0)
        return ans;
        ans.add("");
        for(int i=0;i<digits.length();i++)
        {
            ans=combine(digitsLetter[digits.charAt(i)-'0'],ans);
        }
        return ans;
    }
    public List<String> combine(String curString,List<String> list)
    {
        List<String> ans=new ArrayList<>();
        for(String x:list)
        {
           
            for(int i=0;i<curString.length();i++)
            {
                ans.add(x+curString.charAt(i));
            }
        }
        return ans;
    }
}
// @lc code=end

