package com.example.demo.Controllers;

import com.example.demo.Model.Ingredient;
import com.example.demo.Model.Recipe;
import com.example.demo.api.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {

    private final Dao dao;

    @Autowired
    public Controller(Dao dao) {
        this.dao=dao;
    }

    @GetMapping("add")
    public void add(){
        ArrayList<Ingredient> list=new ArrayList<>();
        list.add(new Ingredient("Kart",122));
        list.add(new Ingredient("Mart",222));

            dao.add(new Recipe("Hash","Nash",list));
    }
    @GetMapping("get")
    public String show(){
        return dao.search("Hash").toString();
    }

    @GetMapping("delete")
    public void delete(){
        dao.delete("Hash");
    }
}
