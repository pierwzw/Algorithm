package com.pier.algorithm.chap1_stack_and_queue;

import java.util.LinkedList;

/**
 * @author: pier
 * @date: 2018/2/10 16:36
 * @desc: 由两个栈组成的队列
 */

public class TwoStacksQueue {
    private LinkedList<Integer> stackPush;
    private LinkedList<Integer> stackPop;

    public TwoStacksQueue(){
        stackPush = new LinkedList<>();
        stackPop = new LinkedList<>();
    }

    public void add(int pushInt){
        stackPush.push(pushInt);
    }

    public int poll(){
        movePushToPop();
        return stackPop.pop();
    }

    public int peek(){
        movePushToPop();
        return stackPop.peek();
    }

    public void movePushToPop(){
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("queue is empty.");
        }else if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

}
