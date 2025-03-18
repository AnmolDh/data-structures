public class Main {
    public static void main(String[] args) {
        School school = new School();
        school.addStudent("John Smith", 98);
        school.addStudent("John Smith", 89);
        school.addStudent("John Smith", 78);

        school.sortStudentsByMarks();

        school.displayMarks();
    }
}