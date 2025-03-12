public class Main {
    public static void main(String[] args) {
        ProcessLinkedList scheduler = new ProcessLinkedList(4);

        scheduler.addProcess(new Process(1, 10, 2));
        scheduler.addProcess(new Process(2, 5, 1));
        scheduler.addProcess(new Process(3, 8, 3));

        // Display initial list of processes
        System.out.println("Initial Process List:");
        scheduler.displayProcesses();

        // Simulate round-robin scheduling
        scheduler.simulateScheduling();
    }
}