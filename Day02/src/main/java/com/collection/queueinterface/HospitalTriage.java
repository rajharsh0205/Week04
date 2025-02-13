package com.collection.queueinterface;

import java.util.PriorityQueue;
import java.util.Comparator;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

public class HospitalTriage {
    public static void main(String[] args) {
        PriorityQueue<Patient> queue = new PriorityQueue<>(Comparator.comparingInt(p -> -p.severity));

        queue.offer(new Patient("Harsh", 3));
        queue.offer(new Patient("Raj", 5));
        queue.offer(new Patient("Ankit", 2));

        System.out.print("Treatment Order: ");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll().name + " ");
        }
    }
}