package com.pier.algorithm.chap1_stack_and_queue;

public class TestGetMinStack1 {
    public static void main(String[] args) {
        GetMinStack1 stack = new GetMinStack1();
        int[] arr = {3,4,5,1,2,1};
        for (int i:arr){
            stack.push(i);
        }
        System.out.println(stack.getMin());
    }
}
