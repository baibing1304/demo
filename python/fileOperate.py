def read_file(file_path):
    """
        读取指定文件的内容

        参数:
        file_path (str): 文件路径

        返回:
        str: 文件内容
        """
    try:
        with open(file_path, 'r', encoding='utf-8') as file:
            content = file.read()
        return content
    except FileNotFoundError:
        return "文件未找到"
    except Exception as e:
        return f"读取文件时出错: {e}


def write_file(file_path, content):
    """
        将内容写入指定文件

        参数:
        file_path (str): 文件路径
        content (str): 要写入的内容
        """
    try:
        if not content.strip():
            raise ValueError("内容不能为空或全是空白")

        with open(file_path, 'w', encoding='utf-8') as file:
            file.write(content)
        return "写入成功"
    except ValueError as ve:
        return f"写入文件时出错: {ve}"
    except Exception as e:
        return f"写入文件时出错: {e}"


def append_to_file(file_path, content):
    """
        将内容追加到指定文件

        参数:
        file_path (str): 文件路径
        content (str): 要追加的内容
        """
    try:
        if not content.strip():
            raise ValueError("内容不能为空或全是空白")

        with open(file_path, 'a', encoding='utf-8') as file:
        return "追加成功"
    except ValueError as ve:
        return f"追加内容时出错: {ve}"
    except Exception as e:
        return f"追加内容时出错: {e}"


# 示例用法
if __name__ == "__main__":
    file_path = 'example.txt'

    # 写入文件
    write_result = write_file(file_path, "这是一个测试内容。\n")
    print(write_result)

    # 读取文件
    read_result = read_file(file_path)
    print(read_result)

    # 追加内容到文件
    append_result = append_to_file(file_path, "这是追加的内容。\n")
    print(append_result)

    # 再次读取文件
    read_result = read_file(file_path)
    print(read_result)
