public class ProcessLinkedList {
    private ProcessListNode head;
    private ProcessListNode current;
    private int timeQuantum;

    public ProcessLinkedList(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addProcess(Process process) {
        ProcessListNode newProcess = new ProcessListNode(process);
        if (isEmpty()) {
            head = newProcess;
            head.setNext(head);
            current = head;
        } else {
            ProcessListNode temp = head;
            while (temp.getNext() != head) {
                temp = temp.getNext();
            }
            temp.setNext(newProcess);
            newProcess.setNext(head);
        }
    }

    public void removeProcessById(int processId) {
        if (isEmpty()) {
            System.out.println("No processes to remove.");
            return;
        }
        ProcessListNode temp = head;
        ProcessListNode prev = null;
        do {
            if (temp.getProcess().getProcessId() == processId) {
                if (temp == head) {
                    if (head.getNext() == head) {
                        head = null;
                    } else {
                        ProcessListNode lastNode = head;
                        while (lastNode.getNext() != head) {
                            lastNode = lastNode.getNext();
                        }
                        head = head.getNext();
                        lastNode.setNext(head);
                    }
                } else {
                    prev.setNext(temp.getNext());
                }
                System.out.println("Process with ID " + processId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.getNext();
        } while (temp != head);
        System.out.println("Process with ID " + processId + " not found.");
    }

    public void simulateScheduling() {
        if (isEmpty()) {
            System.out.println("No processes to schedule.");
            return;
        }
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int totalProcesses = 0;

        System.out.println("Starting Round Robin Scheduling with Time Quanta: " + timeQuantum);
        while (!isEmpty()) {
            ProcessListNode currentProcess = current;
            System.out.println("Executing: " + currentProcess);

            // Execute the process for the time quantum or its remaining burst time
            int executionTime = Math.min(timeQuantum, currentProcess.getProcess().getBurstTime());
            currentProcess.getProcess().setBurstTime(currentProcess.getProcess().getBurstTime()-executionTime);

            // Calculate waiting time and turn-around time
            totalWaitingTime += (totalTurnAroundTime - currentProcess.getProcess().getPriority()); // Simplified waiting time calculation
            totalTurnAroundTime += executionTime;
            totalProcesses++;

            // Display the updated list of processes
            System.out.println("Updated Process List:");
            displayProcesses();

            // Remove the process if it has completed execution
            if (currentProcess.getProcess().getBurstTime() == 0) {
                removeProcessById(currentProcess.getProcess().getProcessId());
            }

            // Move to the next process
            current = current.getNext();
        }

        // Calculate and display average waiting time and turn-around time
        double averageWaitingTime = (double) totalWaitingTime / totalProcesses;
        double averageTurnAroundTime = (double) totalTurnAroundTime / totalProcesses;
        System.out.println("\nAverage Waiting Time: " + averageWaitingTime);
        System.out.println("Average Turn-Around Time: " + averageTurnAroundTime);
    }

    public void displayProcesses() {
        if (isEmpty()) {
            System.out.println("No processes in the scheduler.");
            return;
        }
        ProcessListNode temp = head;
        do {
            System.out.println(temp);
            temp = temp.getNext();
        } while (temp != head);
    }
}
