# classroom.py

from student import Student

class Classroom:
    def __init__(self):
        self.students = []

    def add_student(self, student):
        self.students.append(student)

    def display_students(self):
        for student in self.students:
            print(student)
#班级
classroom = Classroom()

# 添加学生
classroom.add_student(Student("张三", "男", 20))
classroom.add_student(Student("李四", "女", 22))
classroom.add_student(Student("王五", "男", 21))

# 输出班级所有学生的信息
classroom.display_students()
