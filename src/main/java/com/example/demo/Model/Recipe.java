package com.example.demo.Model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Recipe {
    public Recipe(String recipeName, String author,List<Ingredient> ingredients) {
        this.ingredients=ingredients;
        this.recipeName = recipeName;
        this.author = author;

    }

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(targetEntity = Ingredient.class,cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="recipe_id")
    private List<Ingredient> ingredients;

    private String recipeName;

    private String author;

    @Override
    public String toString() {
        return "Recipe{" +
                ", ingredients=" + ingredients +
                ", recipeName='" + recipeName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
