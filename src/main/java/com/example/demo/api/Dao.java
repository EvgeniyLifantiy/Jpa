package com.example.demo.api;

import com.example.demo.Model.Recipe;

public interface Dao {
    void add(Recipe recipe);
    void delete(String s);
    Recipe search(String s);
}
