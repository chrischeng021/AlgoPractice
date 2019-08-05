package StackAlgo;


import java.util.Stack;
public class MinStack {
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    /** initialize your data structure here. */

    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> norStack = new Stack<>();
    public MinStack() {

    }

    public void push(int x) {
        norStack.push(x);
        if(minStack.size() == 0){
            minStack.push(x);
        }
        else{
            minStack.push(Math.min(minStack.lastElement(), x));
        }
    }

    public void pop() {
        norStack.pop();
        minStack.pop();
    }

    public int top() {
        return norStack.lastElement();
    }

    public int getMin() {
        return minStack.lastElement();
    }
}
