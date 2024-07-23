import keyboard

while True:
    print("简单计算器")
    print("可用操作: +, -, *, /")
    print("输入 'q' 退出")

    num1 = float(input("请输入第一个数: "))
    if keyboard.is_pressed('q'):
        break

    operator = input("请输入操作符 (+, -, *, /): ")
    num2 = float(input("请输入第二个数: "))

    if operator == '+':
        result = num1 + num2
    elif operator == '-':
        result = num1 - num2
    elif operator == '*':
        result = num1 * num2
    elif operator == '/':
        if num2 != 0:
            result = num1 / num2
        else:
            print("错误：除数不能为零")
            continue
    else:
        print("无效的操作符")
        continue

    print("结果: {:.2f} {} {:.2f} = {:.2f}".format(num1, operator, num2, result))
    print()

print("感谢使用!")