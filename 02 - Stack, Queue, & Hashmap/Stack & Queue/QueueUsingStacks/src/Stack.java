public class Stack {
    private final int[] array;
    private int top;

    Stack() {
        array = new int[100];
        top = 0;
    }

    public void push(int x) {
        array[top] = x;
        top++;
    }

    public int pop() {
        if (isEmpty()) return -1;
        return array[--top];
    }

    public int peek() {
        if (isEmpty()) return -1;
        return array[top-1];
    }

    public boolean isEmpty() {
        return top == 0;
    }
}
