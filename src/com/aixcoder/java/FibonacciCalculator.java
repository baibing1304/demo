package com.aixcoder.java;

public class FibonacciCalculator {
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 40;
        long startTime = System.currentTimeMillis();
        long result = fibonacci(n);
        long endTime = System.currentTimeMillis();
        System.out.println("Fibonacci(" + n + ") = " + result);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}