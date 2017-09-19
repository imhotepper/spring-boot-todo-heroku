
package com.example.javatodo.controllers;

import com.example.javatodo.models.Todo;
import com.example.javatodo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @RequestMapping(value="/home",  produces = "application/json")
    public String Landind(){return "up and running ...";}

    @RequestMapping("/list")
    public List<Todo> list(){
        return _repo.findAll();
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Todo create(@RequestBody Todo todo){
        return  _repo.saveAndFlush(todo);
    }
    @Autowired
    private TodoRepository _repo;
}
