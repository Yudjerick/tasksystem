package org.example;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Task {
    private String question;
    private ArrayList<String> options;

    private int answerIndex;

}
