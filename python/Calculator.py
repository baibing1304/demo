def calculate(num1, operator, num2):
    if operator == '+':
        return num1 + num2
    elif operator == '-':
        return num1 - num2
    elif operator == '*':
        return num1 * num2
    elif operator == '/':
        if num2 != 0:
            return num1 / num2
        else:
            return "错误：除数不能为零"
    else:
        return "无效的操作符"

print("简单计算器")
print("可用操作: +, -, *, /")
print("输入 'q' 退出")

while True:
    # 获取第一个数
    num1 = input("请输入第一个数: ")
    if num1.lower() == 'q':
        break

    try:
        num1 = float(num1)
    except ValueError:
        print("无效的输入，请输入一个数字")
        continue

    # 获取操作符
    operator = input("请输入操作符 (+, -, *, /): ")
    if operator.lower() == 'q':
        break

    if operator not in ['+', '-', '*', '/']:
        print("无效的操作符")
        continue

    # 获取第二个数
    num2 = input("请输入第二个数: ")
    if num2.lower() == 'q':
        break

    try:
        num2 = float(num2)
    except ValueError:
        print("无效的输入，请输入一个数字")
        continue

    # 计算并显示结果
    result = calculate(num1, operator, num2)
    if isinstance(result, str):
        print(result)
    else:
        print(f"结果: {num1} {operator} {num2} = {result:.2f}")

    print()  # 打印空行以增加可读性

print("感谢使用！")