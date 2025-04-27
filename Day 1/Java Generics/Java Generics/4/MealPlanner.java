public class MealPlanner {

    // Generic method to generate personalized meal plan
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealType) {
        System.out.println("Generating meal plan...");
        return new Meal<>(mealType);
    }
}
