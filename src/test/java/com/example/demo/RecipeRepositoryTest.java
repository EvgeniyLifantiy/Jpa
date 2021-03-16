package com.example.demo;


import com.example.demo.api.RecipeRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class RecipeRepositoryTest {

    @Autowired
    public RecipeRepositoryTest(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }



     RecipeRepository recipeRepository;

    @BeforeAll
    @Test
     void DataDB(){
        ArrayList<Ingredient> list=new ArrayList<>();
        list.add(new Ingredient("Voda",100));
        list.add(new Ingredient("Krupa",200));


        recipeRepository.save(new Recipe("Kasha","Misha",list));
    }

    @Test
    void AddTest(){

        ArrayList<Ingredient> list=new ArrayList<>();
        list.add(new Ingredient("Voda",100));
        list.add(new Ingredient("Krupa",200));

        Recipe recipe=new Recipe("Kasha","Misha",list);

        //fullname
        Assertions.assertEquals(recipe.toString(),recipeRepository.findByName("Kas")
        );

        //short name
        Assertions.assertEquals(
                recipe.toString(),recipeRepository.findByName("Kas")
        );


    }

}
