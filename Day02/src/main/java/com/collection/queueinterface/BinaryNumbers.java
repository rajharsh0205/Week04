package com.collection.queueinterface;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbers {
    public static void generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");

        for (int i = 0; i < n; i++) {
            String current = queue.poll();
            System.out.print(current + " ");

            queue.offer(current + "0");
            queue.offer(current + "1");
        }
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.print("Binary Numbers: ");
        generateBinaryNumbers(N);
    }
}