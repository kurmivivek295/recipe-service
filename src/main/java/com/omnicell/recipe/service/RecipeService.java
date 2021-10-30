package com.omnicell.recipe.service;

import com.omnicell.recipe.entity.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes();
    Recipe getRecipeById(Integer id);
    String getRecipeShowById(Integer id);
    Recipe createRecipe(Recipe recipe);
}
