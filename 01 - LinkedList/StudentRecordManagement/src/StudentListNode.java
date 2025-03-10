public class StudentListNode {
    private Student student;
    private StudentListNode next;

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public StudentListNode getNext() {
        return next;
    }
    public void setNext(StudentListNode next) {
        this.next = next;
    }


    public StudentListNode(Student student) {
        this.student = student;
        this.next = null;
    }
}
