package com.annotations.beginnerlevel.markimportantmethods;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Step 1: Define the custom annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD) // Can be applied to methods
@interface ImportantMethod {
    String level() default "HIGH"; // Default priority is HIGH
}

// Step 2: Apply the annotation to methods
public class MethodTracker {

    @ImportantMethod // Default level (HIGH)
    public void criticalProcess() {
        System.out.println("Executing critical process...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void secondaryProcess() {
        System.out.println("Executing secondary process...");
    }

    @ImportantMethod(level = "LOW")
    public void optionalProcess() {
        System.out.println("Executing optional process...");
    }

    // Step 3: Retrieve and print all annotated methods using Reflection
    public static void main(String[] args) {
        try {
            // Get the class
            Class<?> clazz = MethodTracker.class;

            // Iterate through all methods
            for (Method method : clazz.getDeclaredMethods()) {
                // Check if @ImportantMethod annotation is present
                if (method.isAnnotationPresent(ImportantMethod.class)) {
                    // Retrieve annotation details
                    ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                    System.out.println("Method: " + method.getName());
                    System.out.println("Importance Level: " + annotation.level());
                    System.out.println();
                }
            }

            // Execute the annotated methods
            MethodTracker tracker = new MethodTracker();
            tracker.criticalProcess();
            tracker.secondaryProcess();
            tracker.optionalProcess();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
