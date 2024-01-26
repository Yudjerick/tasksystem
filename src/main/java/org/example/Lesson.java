package org.example;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Lesson {
    private String name;
    private ArrayList<Task> tasks;

    public Lesson(String name){
        this.name = name;
        tasks = new ArrayList<>();
    }
}
