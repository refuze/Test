package Lesson4;

public class Task417 {
    public static void main(String[] args) {
        Student student = new Student();
        Teacher teacher = new Teacher();
        Student student1 = (Student) teacher;
    }

}

class Student extends Teacher {

}

class Teacher {

}