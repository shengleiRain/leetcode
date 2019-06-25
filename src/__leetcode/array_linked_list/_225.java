package __leetcode.array_linked_list;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rain
 * @date 2019/6/25.
 */
public class _225 {
    public static void main(String[] args){
        MyStack2 stack = new MyStack2();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());

    }
}
class MyStack {

    private Queue<Integer> input;
    private Queue<Integer> output;
    private int front;

    /** Initialize your data structure here. */
    public MyStack() {
        input = new LinkedList<>();
        output = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        input.add(x);
        front=x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (input.size()>1){
            front=input.remove();
            output.add(front);
        }
        int value = input.remove();
        Queue<Integer> temp = input;
        input=output;
        output=temp;
        return value;
    }

    /** Get the top element. */
    public int top() {
        if (!input.isEmpty() || !output.isEmpty()){
            return front;
        }else{
            throw new RuntimeException("stack is empty");
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return input.isEmpty();
    }
}

class MyStack2 {

    private Queue<Integer> queue;
    private int front;

    /** Initialize your data structure here. */
    public MyStack2() {
        queue=new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        front=x;
//        for (int i = 1; i < queue.size(); i++) {
//            queue.add(queue.remove());
//        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for (int i = 1; i < queue.size(); i++) {
            front=queue.remove();
            queue.add(front);
        }
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        if (queue.isEmpty()){
            throw new RuntimeException("stack is empty.");
        }
        return front;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}



