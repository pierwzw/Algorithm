package com.pier.algorithm.chap1_stack_and_queue;

public class TestTwoStacksQueue {
    public static void main(String[] args) {
        TwoStacksQueue queue = new TwoStacksQueue();
        int[] arr = {3,4,5,1,2,1};
        for (int i:arr){
            queue.add(i);
        }
        System.out.println(queue.peek());
    }
}
