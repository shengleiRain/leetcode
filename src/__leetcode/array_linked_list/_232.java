package __leetcode.array_linked_list;

import java.util.Stack;

/**
 * @author Rain
 * @date 2019/6/25.
 */
public class _232 {
    public static void main(String[] args) {
        //Your MyQueue object will be instantiated and called as such:
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.peek();
        int param_3 = obj.pop();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}

class MyQueue {

    Stack<Integer> input;
    Stack<Integer> output;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        input.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (output.empty()) {
            //将input中的元素，全部出栈并且入栈output
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (output.empty()) {
            //将input中的元素，全部出栈并且入栈output
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return input.empty() && output.empty();
    }
}

