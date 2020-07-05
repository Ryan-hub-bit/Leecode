/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
       // when meet open bracket push, when meet closed bracket pop see if there is a corresponding open bracket in the peek of the stack
       // when pop, must notice if the stack is empty. 
       Stack<Character> stk = new Stack<>();
       int n = s.length();
       if(n%2 != 0)
       {
           return false;
       }
       int i = 0;
       while( i < n)
       {
           if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[')
           {
               stk.push(s.charAt(i));
           }
           else{
               if(stk.isEmpty())
               {
                   return false;
               }
               else if(s.charAt(i) == ']' && stk.peek() == '[')
               {
                   stk.pop();
               }
               else if(s.charAt(i) == '}' && stk.peek() == '{')
               {
                   stk.pop();
               }
               else if(s.charAt(i) == ')' && stk.peek() == '(')
               {
                   stk.pop();
               }
           }
           i++;
       }
       return stk.isEmpty();
    }
}
// @lc code=end

