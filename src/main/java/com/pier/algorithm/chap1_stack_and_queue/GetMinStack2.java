package com.pier.algorithm.chap1_stack_and_queue;

import java.util.LinkedList;

/**
 * @author: pier
 * @date: 2018/2/10 14:06
 * @desc: 设计一个有getMin()功能的栈
 */

public class GetMinStack2 {
    private LinkedList<Integer> stackData;
    private LinkedList<Integer> stackMin;

    public GetMinStack2(){
        this.stackData = new LinkedList<>();
        this.stackMin = new LinkedList<>();
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
