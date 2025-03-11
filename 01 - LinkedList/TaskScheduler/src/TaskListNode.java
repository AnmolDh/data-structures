public class TaskListNode {
    private Task task;
    private TaskListNode next;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public TaskListNode getNext() {
        return next;
    }

    public void setNext(TaskListNode next) {
        this.next = next;
    }

    public TaskListNode(Task task) {
        this.task = task;
        this.next = null;
    }
}
