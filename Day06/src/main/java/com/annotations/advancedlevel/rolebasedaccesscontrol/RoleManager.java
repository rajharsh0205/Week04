package com.annotations.advancedlevel.rolebasedaccesscontrol;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Step 1: Define the @RoleAllowed annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD) // Can be applied to methods
@interface RoleAllowed {
    String value(); // Role required to execute the method
}

// Step 2: Create a User class to store user roles
class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

// Step 3: Create an AdminService class with restricted methods
class AdminService {

    @RoleAllowed("ADMIN") // Only ADMINs can execute this method
    public void deleteUsers() {
        System.out.println("Deleting users...");
    }

    @RoleAllowed("USER") // Normal users can access this
    public void viewDashboard() {
        System.out.println("Viewing dashboard...");
    }
}

// Step 4: Role-Based Access Control (RBAC) System
class AccessControl {
    private User user; // Current user

    public AccessControl(User user) {
        this.user = user;
    }

    public void invokeMethod(Object obj, String methodName) {
        try {
            // Get the method using reflection
            Method method = obj.getClass().getMethod(methodName);

            // Check if the method is annotated with @RoleAllowed
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);

                // Check if the user's role matches the required role
                if (user.getRole().equalsIgnoreCase(roleAllowed.value())) {
                    method.invoke(obj); // Execute method if role matches
                } else {
                    System.out.println("Access Denied! " + user.getRole() + " is not allowed to execute " + methodName);
                }
            } else {
                method.invoke(obj); // If no restriction, execute normally
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Step 5: Test the Role-Based Access Control System
public class RoleManager {
    public static void main(String[] args) {
        User adminUser = new User("ADMIN");
        User normalUser = new User("USER");

        AdminService service = new AdminService();

        AccessControl adminAccess = new AccessControl(adminUser);
        AccessControl userAccess = new AccessControl(normalUser);

        // Admin trying to delete users (Allowed)
        adminAccess.invokeMethod(service, "deleteUsers");

        // Normal user trying to delete users (Denied)
        userAccess.invokeMethod(service, "deleteUsers");

        // Normal user viewing dashboard (Allowed)
        userAccess.invokeMethod(service, "viewDashboard");

        // Admin viewing dashboard (Allowed)
        adminAccess.invokeMethod(service, "viewDashboard");
    }
}
