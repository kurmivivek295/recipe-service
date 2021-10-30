package com.omnicell.recipe.controller;

import com.omnicell.recipe.entity.Recipe;
import com.omnicell.recipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("{id}")
    public Recipe getRecipeById(@PathVariable("id") Integer id) {
        return recipeService.getRecipeById(id);
    }

    @GetMapping("{id}/show")
    public String getRecipeShowById(@PathVariable("id") Integer id) {
        return recipeService.getRecipeShowById(id);
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

}
