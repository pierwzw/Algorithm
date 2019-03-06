package com.pier.algorithm.chap2_list;

/**
 * @author: pier
 * @date: 2018/2/10 18:39
 * @desc:
 */

public class ReverseList {

    public class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public class DNode{
        public int value;
        public DNode next;
        public DNode last;
        public DNode(int value){
            this.value = value;
        }
    }

    public DNode reverseList(DNode head){
        DNode pre = null;
        DNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
