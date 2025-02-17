package com.annotations.deprecated;

// Legacy API class
class LegacyAPI {

    @Deprecated
    void oldFeature() {
        System.out.println("This is the old feature, avoid using it.");
    }

    void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

// Main class to test
public class DeprecatedAnnotation {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        api.oldFeature(); // This should show a warning in modern IDEs
        api.newFeature();
    }
}