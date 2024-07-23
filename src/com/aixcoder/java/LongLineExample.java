package com.aixcoder.java;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;

public class LongLineExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Henry", "Ivy", "Jack");
        Map<String, Integer> ages = Map.of(
                "Alice", 25, "Bob", 30, "Charlie", 35, "David", 28, "Eva", 22,
                "Frank", 40, "Grace", 33, "Henry", 45, "Ivy", 27, "Jack", 31
        );

        // 优化后的代码
        List<String> filteredAndFormattedNames = names.stream()
                .filter(name -> name.length() > 4 && ages.getOrDefault(name, 0) > 30)
                .map(name -> {
                    int age = ages.get(name);
                    return name.toUpperCase() + " (" + age + ")";
                })
                .sorted((a, b) -> Integer.compare(age(b), age(a)))
                .collect(Collectors.toList());

        System.out.println("Filtered and formatted names: " + filteredAndFormattedNames);
    }

    // helper method
    private static int age(String name) {
        return ages.get(name.substring(0, name.indexOf(' ')));
    }
}