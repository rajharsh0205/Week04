package com.annotations.bugreport;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Step 1: Define a container annotation to hold multiple @BugReport annotations
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Step 2: Define the repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class) // Allows multiple @BugReport annotations
@interface BugReport {
    String description(); // Bug description
    String reportedBy(); // Person who reported the bug
}

// Step 3: Apply @BugReport multiple times on a method
public class BugTracker {

    @BugReport(description = "Null pointer exception on edge cases", reportedBy = "Raj")
    @BugReport(description = "Performance issue when handling large data", reportedBy = "Ram")
    public void processData() {
        System.out.println("Processing data...");
    }

    // Step 4: Retrieve and print all bug reports using Reflection
    public static void main(String[] args) {
        try {
            // Get the class
            Class<?> clazz = BugTracker.class;

            // Get the method where the annotation is applied
            Method method = clazz.getMethod("processData");

            // Check if @BugReport annotations are present
            if (method.isAnnotationPresent(BugReports.class)) {
                // Retrieve all @BugReport annotations
                BugReports bugReports = method.getAnnotation(BugReports.class);

                // Print each bug report
                for (BugReport bug : bugReports.value()) {
                    System.out.println("Bug Description: " + bug.description());
                    System.out.println("Reported By: " + bug.reportedBy());
                    System.out.println();
                }
            }

            // Execute the annotated method
            BugTracker tracker = new BugTracker();
            tracker.processData();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
