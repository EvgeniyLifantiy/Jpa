package com.example.demo.Model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class Ingredient {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int weight;

    @Override
    public String toString() {
        return "Ingredient{" +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public Ingredient(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
}
