package day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recipe {
    String name;
    List<String> ingredients = new ArrayList<>();
    String description;

    public Recipe(String name) {
        this.name = name;
    }

    public Recipe(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addIngredient(String ingredients, String... arg) {
        this.ingredients.add(ingredients);
        for (String s:arg){
            this.ingredients.add(s);
        }
      //  this.ingredients.addAll(Arrays(arg));
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getDescription() {
        return description;
    }
}
