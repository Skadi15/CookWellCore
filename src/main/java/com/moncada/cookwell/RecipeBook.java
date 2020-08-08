package com.moncada.cookwell;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeBook {

    private static final Map<String, List<String>> DEFAULT_TAGS = ImmutableMap.<String, List<String>>builder()
            .put("Event", ImmutableList.of("Christmas", "Thanksgiving", "Easter", "Superbowl"))
            .put("Meal", ImmutableList.of("Breakfast", "Lunch", "Dinner", "Dessert", "Snack"))
            .put("Type", ImmutableList.of("Appetizer", "Main Dish", "Soup", "Salad", "Bread", "Confection"))
            .put("Main Ingredient", ImmutableList.of("Chicken", "Beef", "Pork", "Fish", "Rice", "Beans", "Eggs"))
            .build();

    private final List<Recipe> recipes;
    private final Map<String, List<String>> userDefinedTags;

    public RecipeBook() {
        recipes = new ArrayList<>();
        userDefinedTags = new HashMap<>();
    }

    /**
     * Adds the given recipe to the recipe book.
     *
     * @param recipe The recipe to add to the book.
     */
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    /**
     * Removes the given recipe from the recipe book, if it exists.
     *
     * @param recipe The recipe to remove.
     * @return True if the recipe existed and was removed, false otherwise.
     */
    public boolean removeRecipe(Recipe recipe) {
        return recipes.remove(recipe);
    }

    public void addTag(Recipe.Tag tag) {
        if (userDefinedTags.containsKey(tag.getType()) && userDefinedTags.get(tag.getType()) != null) {
            userDefinedTags.get(tag.getType()).add(tag.getValue());
        } else {
            userDefinedTags.put(tag.getType(), new ArrayList<>());
            userDefinedTags.get(tag.getType()).add(tag.getValue());
        }
    }

}
