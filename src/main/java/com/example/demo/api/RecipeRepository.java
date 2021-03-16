package com.example.demo.api;

import com.example.demo.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,String> {

    @Query("select distinct r from Recipe r where r.recipeName like :name")
    Recipe findByName(@Param("name") String SearchName);

    @Modifying
    @Query("delete from Recipe r where r.recipeName =:name")
    void deleteByName(@Param("name") String SearchName);

}
