public class Main {
    public static void main(String[] args) {
        VegetarianMeal vegMeal = new VegetarianMeal();
        VeganMeal veganMeal = new VeganMeal();
        KetoMeal ketoMeal = new KetoMeal();
        HighProteinMeal hpMeal = new HighProteinMeal();

        // Generate and serve meals
        Meal<VegetarianMeal> myVegMeal = MealPlanner.generateMealPlan(vegMeal);
        myVegMeal.serve();

        Meal<VeganMeal> myVeganMeal = MealPlanner.generateMealPlan(veganMeal);
        myVeganMeal.serve();

        Meal<KetoMeal> myKetoMeal = MealPlanner.generateMealPlan(ketoMeal);
        myKetoMeal.serve();

        Meal<HighProteinMeal> myHighProteinMeal = MealPlanner.generateMealPlan(hpMeal);
        myHighProteinMeal.serve();
    }
}
