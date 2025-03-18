package Sorting_Algorithms;

public class StudentAge {
    String student;
    int age;

    public StudentAge(String student, int age) {
        this.student = student;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student = " + student  +" : "+
                "Age = " + age;
    }
}
