package com.annotations.taskinfo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Step 1: Define the custom annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD) // Can be applied to methods
@interface TaskInfo {
    String priority();  // Task priority (e.g., "High", "Medium", "Low")
    String assignedTo(); // Person responsible for the task
}

// Step 2: Apply the annotation to a method
public class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Harsh")
    public void completeTask() {
        System.out.println("Task is being completed.");
    }

    // Step 3: Main method to retrieve annotation details using Reflection
    public static void main(String[] args) {
        try {
            // Get the class
            Class<?> taskClass = TaskManager.class;

            // Get the method where the annotation is applied
            Method method = taskClass.getMethod("completeTask");

            // Check if @TaskInfo annotation is present
            if (method.isAnnotationPresent(TaskInfo.class)) {
                // Retrieve annotation details
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Task Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }

            // Execute the annotated method
            TaskManager manager = new TaskManager();
            manager.completeTask();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}