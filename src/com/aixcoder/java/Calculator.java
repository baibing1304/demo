package com.aixcoder.java;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result;
        char operator;

        while (true) {
            System.out.println("简单计算器");
            System.out.println("可用操作: +, -, *, /");
            System.out.println("输入 'q' 退出");

            System.out.print("请输入第一个数: ");
            if (scanner.hasNext("q")) {
                break;
            }
            num1 = scanner.nextDouble();

            System.out.print("请输入操作符 (+, -, *, /): ");
            operator = scanner.next().charAt(0);

            System.out.print("请输入第二个数: ");
            num2 = scanner.nextDouble();

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("错误：除数不能为零");
                        continue;
                    }
                    break;
                default:
                    System.out.println("无效的操作符");
                    continue;
            }

            System.out.printf("结果: %.2f %c %.2f = %.2f\n", num1, operator, num2, result);
            System.out.println();
        }

        System.out.println("感谢使用！");
        scanner.close();
    }
}