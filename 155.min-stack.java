/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
import java.util.Stack;
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stk;
    Stack<Integer> min;
    public MinStack() {
        stk = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        stk.push(x);
       
        if(!min.isEmpty() && min.peek()<x)
        {
              min.push(min.peek());
        }
        else{
            min.push(x);
        }
    }
    
    public void pop() {
        stk.pop();
        min.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

