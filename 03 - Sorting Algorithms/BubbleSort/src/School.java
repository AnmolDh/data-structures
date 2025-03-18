import java.util.ArrayList;

public class School {
    private final ArrayList<Student> student;

    public School() {
        this.student = new ArrayList<>();
    }

    public ArrayList<Student> getStudent() {
        return student;
    }
    public void addStudent(String name, int marks) {
        student.add(new Student(name, marks));
    }

    public void sortStudentsByMarks() {
        for (int i = 0; i < student.size(); i++) {
            for (int j = 0; j < student.size() - i - 1; j++) {
                if (student.get(j).getMarks() > student.get(j + 1).getMarks()) {
                    Student temp = student.get(j);
                    student.set(j, student.get(j + 1));
                    student.set(j + 1, temp);
                }
            }
        }
    }

    public void displayMarks() {
        for (Student value : student) {
            System.out.print(value.getMarks() + " ");
        }
    }
}
