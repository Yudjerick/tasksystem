package org.example;

import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class LessonCreator {
    public static Task createTask(String question, String optionsString){
        Task task = new Task();
        task.setQuestion(question);
        ArrayList<String> options;
        options = new ArrayList<>(List.of((optionsString.split(" "))));
        String answer = options.get(0);
        Collections.shuffle(options);
        task.setOptions(options);
        task.setAnswerIndex(options.indexOf(answer));
        return task;
    }

    public static void enterLessonData(){
        System.out.println("Введите название теста: ");
        Scanner scanner = new Scanner(System.in);
        String testName = scanner.nextLine();
        Lesson lesson = new Lesson(testName);
        while (true){
            System.out.println("Введите вопрос задания или 'end' чтобы закончить"+ (lesson.getTasks().size() + 1) +": ");
            String question = scanner.nextLine();
            if(question.equals("end")){
                break;
            }
            System.out.println("Введите верный ответ и другие варианты ответа через пробел: ");
            String optionsString = scanner.nextLine();
            Task task = LessonCreator.createTask(question, optionsString);
            lesson.getTasks().add(task);
        }
        try {
            Writer writer = new FileWriter("test");
            writer.write(new Gson().toJson(lesson));
            writer.close();
            System.out.println("Тест сохранен в файл test");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
