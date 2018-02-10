package com.pier.algorithm.chap1_stack_and_queue;

import java.util.Stack;

/**
 * @author: pier
 * @date: 2018/2/10 14:06
 * @desc: 设计一个有getMin()功能的栈
 */

public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1(){
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum){
        if (stackMin.isEmpty()){
            stackMin.push(newNum);
        }else if (newNum <= getMin()){
            stackMin.push(newNum);
        }
        stackData.push(newNum);
    }

    public int pop(){
        if (stackData.isEmpty()){
            throw new RuntimeException("stack is empty.");
        }
        int value = stackData.pop();
        if (value == getMin()){
            stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if (stackMin.isEmpty()){
            throw new RuntimeException("stack is empty.");
        }
        return stackMin.peek();
    }
}
