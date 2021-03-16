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
        dao.add(new Recipe("1","2",new ArrayList<>()));
    }
    @GetMapping("Search")
    public String show(@RequestParam String id){
        return dao.search("1").toString();
    }

    @GetMapping("delete")
    public void delete(@RequestParam String id){
        dao.delete("1");
    }
}
