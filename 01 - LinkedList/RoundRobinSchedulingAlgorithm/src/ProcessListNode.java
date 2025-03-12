public class ProcessListNode {
    private Process process;
    private ProcessListNode next;

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public ProcessListNode getNext() {
        return next;
    }

    public void setNext(ProcessListNode next) {
        this.next = next;
    }

    public ProcessListNode(Process process) {
        this.process = process;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Process ID: " + process.getProcessId() + ", Burst Time: " + process.getBurstTime() + ", Priority: " + process.getPriority();
    }
}
