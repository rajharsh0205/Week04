package com.annotations.intermediatelevel.maxlengthannotationforfieldvalidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

// Step 1: Define the @MaxLength annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.FIELD) // Can be applied to fields
@interface MaxLength {
    int value(); // Maximum allowed length
}

// Step 2: Create a User class with a @MaxLength field
class User {
    @MaxLength(10) // Maximum username length is 10 characters
    private String username;

    public User(String username) {
        validateMaxLength(username);
        this.username = username;
    }

    // Step 3: Validate @MaxLength using Reflection
    private void validateMaxLength(String value) {
        try {
            // Get the field with @MaxLength annotation
            Field field = User.class.getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                if (value.length() > maxLength.value()) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength.value() + " characters.");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

// Step 4: Test the @MaxLength annotation
public class UserManager {
    public static void main(String[] args) {
        try {
            User user1 = new User("Harsh"); // Valid username
            System.out.println("User 1 created: " + user1.getUsername());

            User user2 = new User("Raj"); // Valid username
            System.out.println("User 2 created: " + user2.getUsername());

            User user3 = new User("LongUsername123"); // Invalid username
            System.out.println("User 3 created: " + user3.getUsername());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
