
package com.example.javatodo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value="/home",  produces = "application/json")
    public String Landind(){return "up and running";}
}
