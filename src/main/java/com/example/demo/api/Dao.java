package com.example.demo.api;

import com.example.demo.Recipe;

public interface Dao {
    void add(Recipe recipe);
    void delete(String s);
    Recipe search(String s);
}
