package com.omnicell.recipe.service;

import com.omnicell.recipe.entity.Recipe;
import com.omnicell.recipe.repo.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepo recipeRepo;

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepo.findAll();
    }

    @Override
    @Cacheable("recipes")
    public Recipe getRecipeById(Integer id) {
        Recipe recipe = recipeRepo.findRecipeById(id);

        if (recipe == null) {
            throw new EntityNotFoundException("Recipe with id:" + id + "did not found!");
        }

        return recipe;
    }

    @Override
    @Cacheable("recipeUrls")
    public String getRecipeShowById(Integer id) {
        Recipe recipe = recipeRepo.findRecipeById(id);

        if (recipe == null) {
            throw new EntityNotFoundException("Recipe with id:" + id + " did not found!");
        }

        return recipe.getImage();
    }

    @Override
    @Transactional
    public Recipe createRecipe(Recipe recipe) {
        if (recipeRepo.findRecipeById(recipe.getId()) != null) {
            throw new EntityExistsException("Recipe with id:" + recipe.getId() + " already exists!");
        }
        return recipeRepo.save(recipe);
    }
}
