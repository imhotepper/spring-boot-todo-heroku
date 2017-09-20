
package com.example.javatodo.controllers;

import com.example.javatodo.models.Todo;
import com.example.javatodo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class TodoesController {

    @Autowired
    private TodoRepository _todoesRepository;
   /* @RequestMapping(value="/todos",  produces = "application/json")
    public String Landind(){return "up and running ...";}
*/

    @RequestMapping("/api/todos")
    public List<Todo> list(){
        return _todoesRepository.findAll();
    }

    @RequestMapping(value = "/api/todos", method = RequestMethod.POST)
    public Todo create(@RequestBody Todo todo){
        return  _todoesRepository.saveAndFlush(todo);
    }

    @RequestMapping(value = "/api/todos/{id}/complete", method = RequestMethod.POST)
    public Todo Complete(@PathVariable Long id)
    {
        Todo todo = _todoesRepository.findOne(id);
        if (todo != null){
            todo.isCompleted = true;
            todo.CompletedAt = new Date();
            _todoesRepository.saveAndFlush(todo);
        }
        return  _todoesRepository.findOne(id);
    }

    @RequestMapping(value = "/api/todos/{id}", method = RequestMethod.DELETE)
    public Todo delete(@PathVariable Long id)
    {
        Todo todo = _todoesRepository.findOne(id);
        _todoesRepository.delete(id);

        return todo;
    }


}
