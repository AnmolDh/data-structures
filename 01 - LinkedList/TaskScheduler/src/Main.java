public class Main {
    public static void main(String[] args) {
        TaskLinkedList scheduler = new TaskLinkedList();

        scheduler.addTaskAtBeginning(new Task(1, "Task A", 2, "2023-12-01"));
        scheduler.addTaskAtEnd(new Task(2, "Task B", 1, "2023-12-05"));
        scheduler.addTaskAtPosition(new Task(3, "Task C", 3, "2023-12-10"), 2);

        System.out.println("All Tasks:");
        scheduler.displayAllTasks();

        System.out.println("\nViewing Current Task:");
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();

        System.out.println("\nTasks with Priority 2:");
        scheduler.searchTasksByPriority(2);

        System.out.println("\nRemoving Task with ID 2:");
        scheduler.removeTaskById(2);
        scheduler.displayAllTasks();
    }
}