package com.pier.algorithm.chap3_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: pier
 * @date: 2018/2/10 21:39
 * @desc: 二叉树前中后层次遍历递归与非递归
 */

public class PreInPosLevTraversal {

    public class Node{
        public Node left;
        public Node right;
        public int value;
        public Node(int value){
            this.value = value;
        }
    }

    public void preOrderRecur(Node head){
        if (head == null){
            return;
        }
        System.out.println(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public void preOrderUnRecur(Node head){
        System.out.println("pre-order: ");
        if (head != null){
            LinkedList<Node> stack = new LinkedList<>();
            stack.push(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.value + " ");
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public void inOrderRecur(Node head){
        if (head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.value + " ");
        inOrderRecur(head.right);
    }

    public void inOrderUnRecur(Node head){
        System.out.println("in-order: ");
        if (head != null){
            LinkedList<Node> stack = new LinkedList<>();
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.println(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public void postOrderRecur(Node head){
        if (head == null){
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.println(head.value + " ");
    }

    public void postOrderUnRecur1(Node head){
        System.out.println("post-order: ");
        if (head != null){
            LinkedList<Node> s1 = new LinkedList<>();
            LinkedList<Node> s2 = new LinkedList<>();
            s1.push(head);
            while (!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if (head.left != null){
                    s1.push(head.left);
                }
                if (head.right != null){
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()){
                System.out.println(s2.pop().value + " ");
            }
        }
        System.out.println();
    }

    public void postOrderUnRecur2(Node h){
        System.out.println("post-order: ");
        if (h != null){
            LinkedList<Node> stack = new LinkedList<>();
            stack.push(h);
            Node c;
            while (!stack.isEmpty()){
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right){
                    stack.push(c.left);
                }else if (c.right  != null && h != c.right){
                    stack.push(c.right);
                }else{
                    System.out.println(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }

    public void levelOrder(Node head){
        if (head == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            System.out.println(head.value + " ");
            if (head.left != null){
                queue.offer(head.left);
            }
            if (head.right != null){
                queue.offer(head.right);
            }
        }
    }

    public int getHeightRecur(Node h, int l){
        if (h == null){
            return l;
        }
        return Math.max(getHeightRecur(h.left, l+1), getHeightRecur(h.right, l+1));
    }

    public static void main(String[] args) {
        Node head = new PreInPosLevTraversal().new Node(1);
        head.left=new PreInPosLevTraversal().new Node(2);
        head.right=new PreInPosLevTraversal().new Node(3);
        head.left.left=new PreInPosLevTraversal().new Node(4);
        head.left.right=new PreInPosLevTraversal().new Node(5);
        new PreInPosLevTraversal().levelOrder(head);
    }
}
