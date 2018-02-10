package com.pier.algorithm.chap1_stack_and_queue;

public class TestMyStack1 {
    public static void main(String[] args) {
        MyStack1 stack = new MyStack1();
        int[] arr = {3,4,5,1,2,1};
        for (int i:arr){
            stack.push(i);
        }
        System.out.println(stack.getMin());
    }
}
