package com.aixcoder.java;

public class InefficientExample {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        String result = "";
        for (int i = 0; i < 100000; i++) {
            result += i + " ";
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + " ms");
        System.out.println("Result length: " + result.length());
    }
}
