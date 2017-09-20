package com.example.javatodo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Date;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String title;
    public Boolean isCompleted;
    public Date CreatedAt;
    public Date CompletedAt;

    public Todo(){
        CreatedAt = new Date();
    }

}
