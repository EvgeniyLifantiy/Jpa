package com.example.demo.Dao;

import com.example.demo.Model.Recipe;
import com.example.demo.api.Dao;
import com.example.demo.api.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class RecipeDao implements Dao {

    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeDao(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Transactional
    @Override
    public void add(Recipe recipe) {
        recipeRepository.save(recipe);
    }


    @Transactional
    @Override
    public Recipe search(String s) {
        return recipeRepository.findByName(s);
    }

    @Transactional
    @Override
    public void delete(String s) {
        recipeRepository.deleteByName(s);
    }

}
