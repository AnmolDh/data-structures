public class TextEditor {
    private TextState head;
    private TextState tail;
    private TextState currentState;
    private final int maxHistorySize;
    private int currentHistorySize;

    public TextEditor(int maxHistorySize) {
        this.maxHistorySize = maxHistorySize;
        this.currentHistorySize = 0;
        this.head = null;
        this.tail = null;
        this.currentState = null;
    }

    // Add a new text state
    public void addState(String content) {
        TextState newState = new TextState(content);

        if (head == null) {
            head = newState;
            tail = newState;
        } else {
            tail.setNext(newState);
            newState.setPrev(tail);
            tail = newState;
        }

        currentState = newState;
        currentHistorySize++;

        // Remove the oldest state if history size exceeds the limit
        if (currentHistorySize > maxHistorySize) {
            head = head.getNext();
            head.setPrev(null);
            currentHistorySize--;
        }
    }

    // Undo functionality
    public void undo() {
        if (currentState == null || currentState.getPrev() == null) {
            System.out.println("Nothing to undo.");
            return;
        }
        currentState = currentState.getPrev();
        System.out.println("Undo successful. Current state: " + currentState);
    }

    // Redo functionality
    public void redo() {
        if (currentState == null || currentState.getNext() == null) {
            System.out.println("Nothing to redo.");
            return;
        }
        currentState = currentState.getNext();
        System.out.println("Redo successful. Current state: " + currentState);
    }

    // Display the current state of the text
    public void displayCurrentState() {
        if (currentState == null) {
            System.out.println("No text available.");
        } else {
            System.out.println("Current state: " + currentState);
        }
    }

    // Display the entire history (for debugging purposes)
    public void displayHistory() {
        TextState temp = head;
        System.out.println("History:");
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}