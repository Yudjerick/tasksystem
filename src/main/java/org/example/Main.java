package org.example;

import com.google.gson.Gson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String opt;
        while (true){
            System.out.println("Введите 1, чтобы создать тест. Введите 2, чтобы пройти тест: ");
            Scanner scanner = new Scanner(System.in);
            opt = scanner.nextLine();
            if(opt.equals("1") || opt.equals("2"))
                break;
        }
        if(opt.equals("1")){
            LessonCreator.enterLessonData();
        }
        else {
            LessonExecutor.executeLesson();
        }
    }
}