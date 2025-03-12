public class TaskLinkedList {
    private TaskListNode head;
    private TaskListNode current;

    public boolean isEmpty() {
        return head == null;
    }

    public void addTaskAtBeginning(Task task) {
        TaskListNode taskNode = new TaskListNode(task);
        if (isEmpty()) {
            head = taskNode;
            head.setNext(head);
            current = head;
        } else {
            TaskListNode lastNode = head;
            while (lastNode.getNext() != head) {
                lastNode = lastNode.getNext();
            }
            taskNode.setNext(head);
            head = taskNode;
            lastNode.setNext(head);
        }
    }

    public void addTaskAtEnd(Task task) {
        TaskListNode taskNode = new TaskListNode(task);
        if (isEmpty()) {
            head = taskNode;
            head.setNext(head);
            current = head;
        } else {
            TaskListNode lastNode = head;
            while (lastNode.getNext() != head) {
                lastNode = lastNode.getNext();
            }
            lastNode.setNext(taskNode);
            taskNode.setNext(head);
        }
    }

    public void addTaskAtPosition(Task task, int position) {
        TaskListNode taskNode = new TaskListNode(task);
        if (position < 1) {
            System.out.println("Invalid position. Position should be >= 1.");
            return;
        }
        if (position == 1) {
            addTaskAtBeginning(task);
        } else {
            TaskListNode temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.getNext();
                if (temp == head) {
                    System.out.println("Position out of range.");
                    return;
                }
            }
            taskNode.setNext(temp.getNext());
            temp.setNext(taskNode);
        }
    }

    public void removeTaskById(int taskId) {
        if (isEmpty()) {
            System.out.println("Task list is empty.");
            return;
        }
        TaskListNode temp = head;
        TaskListNode prev = null;
        do {
            if (temp.getTask().getTaskId() == taskId) {
                if (temp == head) {
                    TaskListNode lastNode = head;
                    while (lastNode.getNext() != head) {
                        lastNode = lastNode.getNext();
                    }
                    if (head == head.getNext()) {
                        head = null;
                    } else {
                        head = head.getNext();
                        lastNode.setNext(head);
                    }
                    if (current == temp) {
                        current = head;
                    }
                } else {
                    if (prev != null){
                        prev.setNext(temp.getNext());
                    }
                    if (current == temp) {
                        current = temp.getNext();
                    }
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.getNext();
        } while (temp != head);
        System.out.println("Task with ID " + taskId + " not found.");
    }

    public void viewCurrentTask() {
        if (isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Current Task: " + current);
        current = current.getNext();
    }

    public void displayAllTasks() {
        if (isEmpty()) {
            System.out.println("Task list is empty.");
            return;
        }
        TaskListNode temp = head;
        do {
            System.out.println(temp);
            temp = temp.getNext();
        } while (temp != head);
    }

    public void searchTasksByPriority(int priority) {
        if (isEmpty()) {
            System.out.println("Task list is empty.");
            return;
        }
        TaskListNode temp = head;
        boolean found = false;
        do {
            if (temp.getTask().getPriority() == priority) {
                System.out.println(temp);
                found = true;
            }
            temp = temp.getNext();
        } while (temp != head);
        if (!found) {
            System.out.println("No tasks found with priority " + priority + ".");
        }
    }
}
