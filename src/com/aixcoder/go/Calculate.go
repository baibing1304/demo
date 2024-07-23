package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func calculate(num1, num2 float64, operator string) (float64, error) {
	switch operator {
	case "+":
		return num1 + num2, nil
	case "-":
		return num1 - num2, nil
	case "*":
		return num1 * num2, nil
	case "/":
		if num2 != 0 {
			return num1 / num2, nil
		}
		return 0, fmt.Errorf("错误：除数不能为零")
	default:
		return 0, fmt.Errorf("无效的操作符")
	}
}

func main() {
	reader := bufio.NewReader(os.Stdin)

	fmt.Println("简单计算器")
	fmt.Println("可用操作: +, -, *, /")
	fmt.Println("输入 'q' 退出")

	for {
		// 获取第一个数
		fmt.Print("请输入第一个数: ")
		input, _ := reader.ReadString('\n')
		input = strings.TrimSpace(input)
		if input == "q" || input == "Q" {
			break
		}
		num1, err := strconv.ParseFloat(input, 64)
		if err != nil {
			fmt.Println("无效的输入，请输入一个数字")
			continue
		}

		// 获取操作符
		fmt.Print("请输入操作符 (+, -, *, /): ")
		operator, _ := reader.ReadString('\n')
		operator = strings.TrimSpace(operator)
		if operator == "q" || operator == "Q" {
			break
		}
		if operator != "+" && operator != "-" && operator != "*" && operator != "/" {
			fmt.Println("无效的操作符")
			continue
		}

		// 获取第二个数
		fmt.Print("请输入第二个数: ")
		input, _ = reader.ReadString('\n')
		input = strings.TrimSpace(input)
		if input == "q" || input == "Q" {
			break
		}
		num2, err := strconv.ParseFloat(input, 64)
		if err != nil {
			fmt.Println("无效的输入，请输入一个数字")
			continue
		}

		// 计算并显示结果
		result, err := calculate(num1, num2, operator)
		if err != nil {
			fmt.Println(err)
		} else {
			fmt.Printf("结果: %.2f %s %.2f = %.2f\n", num1, operator, num2, result)
		}

		fmt.Println() // 打印空行以增加可读性
	}

	fmt.Println("感谢使用！")
}