public class TaskLinkedList {
    private Task head;
    private Task current;

    public boolean isEmpty() {
        return head == null;
    }

    public void addTaskAtBeginning(Task task) {
        if (isEmpty()) {
            head = task;
            head.next = head; // Circular reference
            current = head;
        } else {
            Task lastNode = head;
            while (lastNode.next != head) {
                lastNode = lastNode.next;
            }
            task.next = head;
            head = task;
            lastNode.next = head;
        }
    }
}
