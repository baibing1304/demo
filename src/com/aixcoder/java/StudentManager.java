package com.aixcoder.java;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Added student: " + student.getName());
    }

    public void removeStudent(String name) {
        students.removeIf(student -> student.getName().equals(name));
        System.out.println("Removed student: " + name);
    }

    // 这个方法名不符合驼峰规则，且使用了汉语拼音
    public void CHAXUN_suoyouxuesheng() {
        System.out.println("All students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        manager.addStudent(new Student("Alice", 20));
        manager.addStudent(new Student("Bob", 22));
        manager.addStudent(new Student("Charlie", 21));

        manager.CHAXUN_suoyouxuesheng();

        manager.removeStudent("Bob");

        manager.CHAXUN_suoyouxuesheng();
    }
}

class Student {

}