public class StudentLinkedList {
    private StudentListNode head;

    public StudentLinkedList() {
        this.head = null;
    }

    public static void displayDetails(Student student) {
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Roll No: " + student.getRollNumber());
        System.out.println("Student Grade: " + student.getGrade());
    }

    public static void traverse(StudentLinkedList list) {
        StudentListNode temp = list.head;
        while (temp != null) {
            displayDetails(temp.getStudent());
            temp = temp.getNext();
        }
    }

    public void add(Student student) {
        StudentListNode node = new StudentListNode(student);
        if (head == null) {
            head = node;
            return;
        }
        StudentListNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    public void add(Student student, int index) {
        StudentListNode node = new StudentListNode(student);
        try{
            if (index <= 0 || head == null) {
                addAtStart(node.getStudent());
                return;
            }
            StudentListNode temp = head;
            int counter = 0;
            while (counter < index-1 && temp != null) {
                temp = temp.getNext();
                counter++;
            }
            if (temp == null) {
                add(node.getStudent());
            } else {
                StudentListNode tempNext = temp.getNext();
                temp.setNext(node);
                node.setNext(tempNext);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addAtStart(Student student) {
        StudentListNode node = new StudentListNode(student);
        if (head == null) {
            head = node;
            return;
        }
        StudentListNode temp = head;
        head = node;
        node.setNext(temp);
    }

    public void delete(int rollNumber) {
        if (head == null) {
            return;
        }

        if (head.getStudent().getRollNumber() == rollNumber) {
            head = head.getNext();
            return;
        }

        StudentListNode temp = head;
        StudentListNode tempPrev = null;

        while (temp != null && temp.getStudent().getRollNumber() != rollNumber) {
            tempPrev = temp;
            temp = temp.getNext();
        }

        if (temp != null && tempPrev != null) {
            tempPrev.setNext(temp.getNext());
        }
    }

    public void search(int rollNumber) {
        if (head == null) {
            return;
        }

        if (head.getStudent().getRollNumber() == rollNumber) {
            displayDetails(head.getStudent());
            return;
        }

        StudentListNode temp = head;
        while (temp != null && temp.getStudent().getRollNumber() != rollNumber) {
            temp = temp.getNext();
        }
        if (temp != null) {
            displayDetails(temp.getStudent());
        }
    }


    public void updateGrade(int rollNumber, char newGrade) {
        if (head == null) {
            return;
        }

        if (head.getStudent().getRollNumber() == rollNumber) {
            head.getStudent().setGrade(newGrade);
            return;
        }

        StudentListNode temp = head;
        while (temp != null && temp.getStudent().getRollNumber() != rollNumber) {
            temp = temp.getNext();
        }
        if (temp != null) {
            temp.getStudent().setGrade(newGrade);
        }
    }
}
