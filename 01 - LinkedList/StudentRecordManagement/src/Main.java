public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(1, "jack", 19, 'A');
        Student s2 = new Student(2, "jane", 20, 'B');
        Student s3 = new Student(3, "john", 21, 'C');
        Student s4 = new Student(4, "harry", 22, 'D');

        StudentLinkedList list = new StudentLinkedList();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4, 1);

        list.delete(1);

        list.search(4);

        list.updateGrade(4, 'A');

        StudentLinkedList.traverse(list);
    }
}