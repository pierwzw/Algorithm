package com.pier.algorithm.chap1_stack_and_queue;

public class TestGetMinStack2 {
    public static void main(String[] args) {
        GetMinStack2 stack = new GetMinStack2();
        int[] arr = {3,4,5,1,2,1};
        for (int i:arr){
            stack.push(i);
        }
        System.out.println(stack.getMin());
    }
}
