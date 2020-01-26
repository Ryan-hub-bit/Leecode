/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {

        String[] digitletter={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res=new ArrayList<>();
    
        if(digits.length()==0)
            return res;
         res.add("");
         
         for(int j=0;j<digits.length();j++)
         {
            List<String> ans=res;
            res=new ArrayList<>();
            int len=digits.charAt(j)-'0';
            for(int i=0;i<digitletter[len].length();i++)
            {
                for(String x:ans)
                {
                    res.add(x+digitletter[len].charAt(i));
                }
            }


             //res=combina(digitletter[digits.charAt(i)-'0'],res);
         }
         return res;
    }
    
}
// @lc code=end

