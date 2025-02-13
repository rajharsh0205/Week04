package com.collection.queueinterface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println("Original Queue: " + queue);
        System.out.println("Reversed Queue: " + reverseQueue(queue));
    }
}