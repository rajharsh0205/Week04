package com.annotations.beginnerlevel.todoannotationforpendingtask;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Step 1: Define the @Todo annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD) // Can be applied to methods
@interface Todo {
    String task();         // Description of the task
    String assignedTo();   // Developer responsible
    String priority() default "MEDIUM"; // Default priority is MEDIUM
}

// Step 2: Apply @Todo to multiple methods
public class TaskManager {

    @Todo(task = "Implement user authentication", assignedTo = "Raj", priority = "HIGH")
    public void loginFeature() {
        System.out.println("Login feature work in progress...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Ram")
    public void optimizeDatabase() {
        System.out.println("Database optimization pending...");
    }

    @Todo(task = "Enhance UI for dashboard", assignedTo = "Raja", priority = "LOW")
    public void updateDashboardUI() {
        System.out.println("Dashboard UI update in progress...");
    }

    // Step 3: Retrieve and print all @Todo annotations using Reflection
    public static void main(String[] args) {
        try {
            // Get the class
            Class<?> clazz = TaskManager.class;

            // Iterate through all methods
            for (Method method : clazz.getDeclaredMethods()) {
                // Check if @Todo annotation is present
                if (method.isAnnotationPresent(Todo.class)) {
                    // Retrieve annotation details
                    Todo todo = method.getAnnotation(Todo.class);
                    System.out.println("Task: " + todo.task());
                    System.out.println("Assigned To: " + todo.assignedTo());
                    System.out.println("Priority: " + todo.priority());
                    System.out.println("Method: " + method.getName());
                    System.out.println();
                }
            }

            // Execute the methods (optional)
            TaskManager manager = new TaskManager();
            manager.loginFeature();
            manager.optimizeDatabase();
            manager.updateDashboardUI();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
