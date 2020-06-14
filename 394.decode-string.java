import java.util.Stack;

/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
       //int n = s.length();
       char[] ch = s.toCharArray();
       int num =0;
       Stack<Object> stk = new Stack<>();
       for(char c :ch)
       {
           if(Character.isDigit(c))
           {
               num =num * 10 + (c-'0');
           }
           else if(c == '[')
           {
               System.out.println(num);
               stk.push(num);
               num = 0;
           }
           else if(c == ']')
           {
             String str = popStk(stk);
             int count = (Integer)stk.pop();
             for(int i =0; i<count; i++)
             {
                 stk.push(str);
             }
           }
           else{
               stk.push(String.valueOf(c));
           }
       }
       return popStk(stk);
    }
    public String  popStk(Stack<Object> stk)
    {
        Stack<String> buffer = new Stack<>();
        while(!stk.isEmpty() && stk.peek() instanceof String)
        {
            buffer.push((String)stk.pop());
        }
        StringBuilder  sb = new StringBuilder();
        while(!buffer.isEmpty())
        {
            sb.append(buffer.pop());
        }
        return sb.toString();
    }
}
// @lc code=end

