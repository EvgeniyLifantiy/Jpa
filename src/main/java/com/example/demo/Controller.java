package com.example.demo;

import com.example.demo.api.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("Search")
    public String show(@RequestParam String id){
        return dao.search("Hash").toString();
    }

    @GetMapping("delete")
    public void delete(@RequestParam String id){
        dao.delete("Hash");
    }
}
