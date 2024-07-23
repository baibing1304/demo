from classroom import Classroom

# 创建班级对象
classroom1 = Classroom("Class A", "Mr. Smith")

# 添加学生到班级
classroom1.add_student("张三", "男", 15, "北京")
classroom1.add_student("李四", "女", 16, "北京")
classroom1.add_student("王五", "男", 23, "北京")

# 输出班级信息
print(f"Class Name: {classroom1.class_name}")
print(f"Teacher: {classroom1.teacher_name}")
print(f"Number of Students: {classroom1.num_students()}")

# 遍历班级中的学生信息
print("\nStudents in the class:")
classroom1.list_students()

