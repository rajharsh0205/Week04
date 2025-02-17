package com.annotations.advancedlevel.customcachingsystem;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @CacheResult annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD) // Can be applied to methods
@interface CacheResult {}

// Step 2: Implement a Caching Proxy
class CacheHandler {
    private static final Map<String, Object> cache = new HashMap<>();

    public static Object invokeWithCache(Object obj, String methodName, Object... args) {
        try {
            // Create a unique cache key
            String key = methodName + "(";
            for (Object arg : args) {
                key += arg.toString() + ",";
            }
            key += ")";

            // Check if the result is already cached
            if (cache.containsKey(key)) {
                System.out.println("Returning cached result for " + key);
                return cache.get(key);
            }

            // Invoke the method using reflection
            Method method = obj.getClass().getMethod(methodName, int.class); // Assuming single int parameter
            if (method.isAnnotationPresent(CacheResult.class)) {
                Object result = method.invoke(obj, args); // Compute result
                cache.put(key, result); // Store in cache
                return result;
            } else {
                return method.invoke(obj, args); // Execute normally if no caching
            }
        } catch (Exception e) {
            throw new RuntimeException("Error invoking method", e);
        }
    }
}

// Step 3: Create a Class with a Computationally Expensive Method
class ExpensiveOperations {

    @CacheResult// This method should be cached
    public int factorial(int n) {
        System.out.println("Computing factorial of " + n);
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}

// Step 4: Test the Caching System
public class CacheResults {
    public static void main(String[] args) {
        ExpensiveOperations operations = new ExpensiveOperations();

        // First Call (Computes the value)
        System.out.println("Result: " + CacheHandler.invokeWithCache(operations, "factorial", 5));

        // Second Call (Uses cached result)
        System.out.println("Result: " + CacheHandler.invokeWithCache(operations, "factorial", 5));

        // Another call with a different input
        System.out.println("Result: " + CacheHandler.invokeWithCache(operations, "factorial", 6));
    }
}
