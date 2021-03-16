package com.example.demo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    @JoinColumn(name = "id")
    private List<Ingredient> ingredients;

    private String recipeName;

    private String author;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id && ingredients.equals(recipe.ingredients) && recipeName.equals(recipe.recipeName) && author.equals(recipe.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredients, recipeName, author);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                ", ingredients=" + ingredients +
                ", recipeName='" + recipeName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
