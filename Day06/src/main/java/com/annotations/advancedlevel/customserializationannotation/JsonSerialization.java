package com.annotations.advancedlevel.customserializationannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @JsonField annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.FIELD) // Can be applied to fields
@interface JsonField {
    String name(); // Custom JSON key name
}

// Step 2: Create a User class with @JsonField annotations
class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    @JsonField(name = "email_address")
    private String email;

    public User(String username, int age, String email) {
        this.username = username;
        this.age = age;
        this.email = email;
    }
}

// Step 3: Implement the JSON Serializer
class JsonSerializerDemo {
    public static String serialize(Object obj) {
        try {
            Class<?> objClass = obj.getClass();
            Map<String, String> jsonElements = new HashMap<>();

            for (Field field : objClass.getDeclaredFields()) {
                field.setAccessible(true); // Access private fields

                if (field.isAnnotationPresent(JsonField.class)) {
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    jsonElements.put(annotation.name(), field.get(obj).toString());
                }
            }

            // Convert map to JSON string
            StringBuilder jsonBuilder = new StringBuilder("{");
            for (Map.Entry<String, String> entry : jsonElements.entrySet()) {
                jsonBuilder.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\", ");
            }
            if (!jsonElements.isEmpty()) {
                jsonBuilder.setLength(jsonBuilder.length() - 2); // Remove last comma
            }
            jsonBuilder.append("}");

            return jsonBuilder.toString();
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error in JSON serialization", e);
        }
    }
}

// Step 4: Test the JSON Serialization
public class JsonSerialization {
    public static void main(String[] args) {
        User user = new User("Raj", 25, "rajharsh@gmail.com");
        String json = JsonSerializerDemo.serialize(user); // Corrected line
        System.out.println("Serialized JSON: " + json);
    }
}

