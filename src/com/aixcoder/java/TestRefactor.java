package com.aixcoder.java;

import java.util.Scanner;

public class TestRefactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TestRefactor calculator = new TestRefactor();

        while (true) {
            System.out.println("简单计算器");
            System.out.println("可用操作: +, -, *, /");
            System.out.println("输入 'q' 退出");

            System.out.print("请输入第一个数: ");
            double num1 = scanner.nextDouble();

            System.out.print("请输入操作符 (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            System.out.print("请输入第二个数: ");
            double num2 = scanner.nextDouble();

            if (operator == 'q') {
                break;
            }

            double result = calculator.calculate(num1, operator, num2);
            System.out.printf("结果: %.2f %c %.2f = %.2f\n", num1, operator, num2, result);
            System.out.println();
        }

        System.out.println("感谢使用！");
        scanner.close();
    }

    public double calculate(double num1, char operator, double num2) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.out.println("错误：除数不能为零");
                    return 0;
                }
            default:
                System.out.println("无效的操作符");
                return 0;
        }
    }
}