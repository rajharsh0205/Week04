package com.collection.queueinterface;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int x) {
        queue1.offer(x);
    }

    public int pop() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int popped = queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return popped;
    }

    public int top() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int top = queue1.peek();
        queue2.offer(queue1.poll());
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return top;
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Pop: " + stack.pop());
    }
}