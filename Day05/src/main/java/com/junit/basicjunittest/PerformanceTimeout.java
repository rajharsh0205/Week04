package com.junit.basicjunittest;

public class PerformanceTimeout {
    public static String longRunningTask() throws InterruptedException {
        Thread.sleep(3000); // Simulating a long task (3 seconds)
        return "Task Completed";
    }
}