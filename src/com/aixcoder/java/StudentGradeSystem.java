package com.aixcoder.java;

import java.util.ArrayList;
import java.util.List;

public class StudentGradeSystem {
    // 定义一个学生列表
    private List<Student> students;

    // 构造函数，初始化学生列表
    public StudentGradeSystem() {
        students = new ArrayList<>();
    }

    // 添加学生信息
    public void addStudent(String name, int age, double grade) {
        students.add(new Student(name, age, grade));
    }

    // 计算平均成绩
    public double calculateAverageGrade() {
        double sum = 0;
        for (Student student : students) {
            sum += student.grade;
        }
        // Bug 1: 除以0的问题
        return sum / students.size();
    }

    // 打印最高分的学生
    public void printTopStudent() {
        Student topStudent = null;
        double highestGrade = Double.MIN_VALUE;

        // Bug 2: 索引越界
        for (int i = 0; i <= students.size(); i++) {  
            Student student = students.get(i);
            if (student.grade > highestGrade) {
                highestGrade = student.grade;
                topStudent = student;
            }
        }

        if (topStudent != null) {
            System.out.println("Top student: " + topStudent.name + " with grade " + topStudent.grade);
        } else {
            System.out.println("No students in the system.");
        }
    }

    // 定义一个学生类
    private class Student {
        String name;
        int age;
        double grade;

        // 构造函数，初始化学生信息
        Student(String name, int age, double grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {
        StudentGradeSystem sgs = new StudentGradeSystem();

        // 添加学生信息
        sgs.addStudent("Alice", 20, 85.5);
        sgs.addStudent("Bob", 21, 92.0);
        sgs.addStudent("Charlie", 19, 78.5);

        // 计算平均成绩
        System.out.println("Average grade: " + sgs.calculateAverageGrade());
        // 打印最高分的学生
        sgs.printTopStudent();
    }
}