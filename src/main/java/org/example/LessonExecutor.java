package org.example;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LessonExecutor {
    public static void executeLesson(){
        String jsonStr;
        try {
            jsonStr = new Scanner(new FileReader("test")).nextLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        Lesson lesson = gson.fromJson(jsonStr, Lesson.class);
        System.out.println(lesson.getName());
        for (Task task: lesson.getTasks()) {
            System.out.println(task.getQuestion());
            for (int i = 0; i < task.getOptions().size(); i++) {
                System.out.println("[" + (i +1) + "] " + task.getOptions().get(i));
            }
            System.out.println("Введите цифру ответа: ");
            String answer = new Scanner(System.in).next();
            if(answer.equals(String.valueOf(task.getAnswerIndex()+1))){
                System.out.println("Верно");
            }
            else {
                System.out.println("Неверно");
            }
        }
    }
}
