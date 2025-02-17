package com.annotations.intermediatelevel.annotationforloggingmethodexecutiontime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Step 1: Define the @LogExecutionTime annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD) // Can be applied to methods
@interface LogExecutionTime {}

// Step 2: Create an interface for tasks
interface TaskService {
    void fastTask();
    void slowTask();
}

// Step 3: Create an implementation class and annotate methods
class TaskServiceImpl implements TaskService {

    @LogExecutionTime
    public void fastTask() {
        System.out.println("Executing fast task...");
    }

    @LogExecutionTime
    public void slowTask() {
        System.out.println("Executing slow task...");
        try {
            Thread.sleep(2000); // Simulating a slow method
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Step 4: Create a dynamic proxy to handle method execution and log time
class ExecutionTimeProxy implements InvocationHandler {
    private final Object target;

    public ExecutionTimeProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Check if the method is annotated with @LogExecutionTime
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            long startTime = System.nanoTime(); // Start time
            Object result = method.invoke(target, args); // Execute method
            long endTime = System.nanoTime(); // End time

            long executionTime = (endTime - startTime) / 1_000_000; // Convert to milliseconds
            System.out.println("Execution time of " + method.getName() + ": " + executionTime + " ms");
            return result;
        } else {
            return method.invoke(target, args);
        }
    }
}

// Step 5: Use Proxy to handle method execution time logging
public class ExecutionTime {
    public static void main(String[] args) {
        // Create a proxy instance for TaskService
        TaskService taskService = (TaskService) Proxy.newProxyInstance(
                TaskService.class.getClassLoader(),
                new Class<?>[]{TaskService.class},
                new ExecutionTimeProxy(new TaskServiceImpl())
        );

        // Call the annotated methods
        taskService.fastTask();
        taskService.slowTask();
    }
}
