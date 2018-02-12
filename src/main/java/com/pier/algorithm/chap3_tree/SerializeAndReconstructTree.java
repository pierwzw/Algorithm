package com.pier.algorithm.chap3_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: pier
 * @date: 2018/2/12 22:00
 * @desc: 二叉树的序列化与反序列化
 */

public class SerializeAndReconstructTree {
    public class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value = value;
        }

        public String serialByPre(Node head){
            if (head == null){
                return "#!";
            }
            String res = head.value + "!";
            res += serialByPre(head.left);
            res += serialByPre(head.right);
            return res;
        }

        public Node reconByPreString(String preStr){
            String[] values = preStr.split("!");
            Queue<String> queue = new LinkedList<>();
            for (String str:values){
                queue.offer(str);
            }
            return reconPreOrder(queue);


        }

        public Node reconPreOrder(Queue<String> queue){
            String value = queue.poll();
            if (value.equals("#")){
                return null;
            }
            Node head = new Node(Integer.valueOf(value));
            head.left = reconPreOrder(queue);
            head.right = reconPreOrder(queue);
            return head;
        }

        public String serialByLevel(Node head){
            if (head == null){
                return "#!";
            }
            String res = head.value + "!";
            Queue<Node> queue = new LinkedList<>();
            queue.offer(head);
            while (!queue.isEmpty()){
                head = queue.poll();
                if (head.left != null){
                    res += head.left.value + "!";
                    queue.offer(head.left);
                }else{
                    res += "#!";
                }
                if (head.right != null){
                    res += head.right.value + "!";
                    queue.offer(head.right);
                }else{
                    res += "#!";
                }
            }
            return res;
        }

        public Node reconByLevelString(String levelStr){
            String[] values = levelStr.split("!");
            int index = 0;
            Node head = generateNodeByString(values[index++]);
            Queue<Node> queue = new LinkedList<>();
            if (head == null) {
                queue.offer(head);
            }
            Node node = null;
            while (!queue.isEmpty()){
                node = queue.poll();
                node.left = generateNodeByString(values[index++]);
                node.right = generateNodeByString(values[index++]);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            return head;
        }

        public Node generateNodeByString(String val){
            if (val.equals("#")){
                return null;
            }
            return new Node(Integer.valueOf(val));
        }
    }
}
