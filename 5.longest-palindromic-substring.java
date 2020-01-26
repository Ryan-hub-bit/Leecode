/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
      int [] start=new int[1];
      int [] end=new int[1];
      //int start=0,end==0 为什么不能这样用
        if(s.length()<2)
       {
           return s;
       }
       for(int i=0;i<s.length();i++)
       {
           extendPalindrome(s,i,i,start,end);//odd palindrome
           extendPalindrome(s,i,i+1,start,end);//even palindrome
       }
       
     return s.substring(start[0],end[0]+1);
    }
    private void extendPalindrome(String s,int i,int j,int[] start,int[] end)
    {
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j))
        {
            i--;
            j++;
        }
        i++;//back to the last valid match
        j--;
        if(j-i+1>end[0]-start[0]+1)
        {
            start[0]=i;
            end[0]=j;
        }
    }
}
// @lc code=end

