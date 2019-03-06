package com.pier.algorithm.chap2_list;

/**
 * @author: pier
 * @date: 2018/2/10 20:10
 * @desc: 约瑟夫问题:1.O(nxm),2.O(N)
 */

public class Josephus {

    public class Node{
        public Node next;
        public int value;
        public Node(int value){
            this.value = value;
        }
    }

    public Node josephusKill1(Node head, int m){
        if (head == null || head.next == head || m < 1){
            return head;
        }
        Node last = head;
        while (last.next != head){
            last = last.next;
        }
        int count = 0;
        while (head != last){
            if (++count == m){
                last.next = head.next;
                count = 0;
            }else{
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }

    public Node josephusKill2(Node head, int m){
        if (head == null || head.next == head || m < 1){
            return head;
        }
        int tmp = 1;
        Node cur = head.next;
        while (cur != head){
            cur = cur.next;
            tmp++;
        }
        tmp = getLive(tmp, m);
        while (--tmp != 0){
            head = head.next;
        }
        head.next = head;
        return head;
    }

    public int getLive(int i, int m){
        if (i == 1){
            return 1;
        }
        return (getLive(i - 1, m) + m - 1) % i + 1;
    }
}
