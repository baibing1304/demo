#include <iostream>
#include <limits>
#include <cmath>

double calculate(double num1, char op, double num2) {
    switch (op) {
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
                std::cout << "错误：除数不能为零" << std::endl;
                return std::numeric_limits<double>::quiet_NaN();
            }
        default:
            std::cout << "无效的操作符" << std::endl;
            return std::numeric_limits<double>::quiet_NaN();
    }
}

int main() {
    double num1, num2, result;
    char op;
    std::string input;

    std::cout << "简单计算器" << std::endl;
    std::cout << "可用操作: +, -, *, /" << std::endl;
    std::cout << "输入 'q' 退出" << std::endl;

    while (true) {
        // 获取第一个数
        std::cout << "请输入第一个数: ";
        std::cin >> input;
        if (input == "q" || input == "Q") break;

        try {
            num1 = std::stod(input);
        } catch (const std::invalid_argument&) {
            std::cout << "无效的输入，请输入一个数字" << std::endl;
            std::cin.clear();
            std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
            continue;
        }

        // 获取操作符
        std::cout << "请输入操作符 (+, -, *, /): ";
        std::cin >> op;
        if (op == 'q' || op == 'Q') break;

        if (op != '+' && op != '-' && op != '*' && op != '/') {
            std::cout << "无效的操作符" << std::endl;
            continue;
        }

        // 获取第二个数
        std::cout << "请输入第二个数: ";
        std::cin >> input;
        if (input == "q" || input == "Q") break;

        try {
            num2 = std::stod(input);
        } catch (const std::invalid_argument&) {
            std::cout << "无效的输入，请输入一个数字" << std::endl;
            std::cin.clear();
            std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
            continue;
        }

        // 计算并显示结果
        result = calculate(num1, op, num2);
        if (!std::isnan(result)) {
            std::cout << "结果: " << num1 << " " << op << " " << num2 << " = "
                      << std::fixed << std::setprecision(2) << result << std::endl;
        }

        std::cout << std::endl;  // 打印空行以增加可读性
    }

    std::cout << "感谢使用！" << std::endl;
    return 0;
}