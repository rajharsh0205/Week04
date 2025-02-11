package com.generics.personalizedmealplangenerator;

// Define a MealPlan interface
interface MealPlan {
    void showMeal();
}

// Implement different types of meals
class VegetarianMeal implements MealPlan {
    public void showMeal() {
        System.out.println("Vegetarian Meal: Grilled Paneer with Vegetables.");
    }
}

class VeganMeal implements MealPlan {
    public void showMeal() {
        System.out.println("Vegan Meal: Quinoa Salad with Avocado.");
    }
}

class KetoMeal implements MealPlan {
    public void showMeal() {
        System.out.println("Keto Meal: Grilled Chicken with Avocado.");
    }
}

class HighProteinMeal implements MealPlan {
    public void showMeal() {
        System.out.println("High-Protein Meal: Egg Whites with Lean Beef.");
    }
}

// Generic Meal Class
class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public void displayMeal() {
        meal.showMeal();
    }
}

// Meal Generator with Generic Method
class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T meal) {
        System.out.println("Generating meal plan...");
        return new Meal<>(meal);
    }
}

// Main Class to Test the Implementation
public class MealPlanApp {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMeal = MealPlanGenerator.generateMealPlan(new VegetarianMeal());
        vegetarianMeal.displayMeal();

        Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMealPlan(new VeganMeal());
        veganMeal.displayMeal();

        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(new KetoMeal());
        ketoMeal.displayMeal();

        Meal<HighProteinMeal> highProteinMeal = MealPlanGenerator.generateMealPlan(new HighProteinMeal());
        highProteinMeal.displayMeal();
    }
}