package com.lms.auth.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lms.auth.entities.User;

public class ControllerFile {
    public List<User> readDataFromFile(String fileName) {
        List<User> students = new ArrayList<>();
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                // String id = scanner.nextLine();
                // String name = scanner.nextLine();
                // int age = Integer.parseInt(scanner.nextLine());
                // float mark = Float.parseFloat(scanner.nextLine());
                // Student s = new Student(id, name, age, mark);
                // students.add(s);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return students;
    }

    public boolean writeDataToFile(List<User> students, String fileName) {

        return false;
    }
}
