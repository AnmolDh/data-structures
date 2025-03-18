package Sorting_Algorithms;

public class Exam {
    String student;
    float percentage;

    public Exam(String student, float percentage) {
        this.student = student;
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Student: " + student + ", Percentage: " + percentage;
    }
}