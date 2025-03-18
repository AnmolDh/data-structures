public class Stack <T>{
    private final T[] array;
    private int top;

    @SuppressWarnings("unchecked")
    public Stack() {
        array = (T[]) new Object[100];
        top = 0;
    }

    public void push(T item) {
        array[top++] = item;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return array[--top];
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return array[top-1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public static <K extends Comparable<K>> Stack<K> sortStack(Stack<K> st){
        Stack<K> sortedStack = new Stack<>();
        Stack<K> stack = copyStack(st);

        while(!stack.isEmpty()){
            K temp = stack.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek().compareTo(temp) < 0) {
                stack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }

        return sortedStack;
    }

    private static <K extends Comparable<K>> Stack<K> copyStack(Stack<K> stack) {
        Stack<K> temp = new Stack<>();
        Stack<K> copy = new Stack<>();

        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }

        while (!temp.isEmpty()) {
            K item = temp.pop();
            stack.push(item);
            copy.push(item);
        }

        return copy;
    }
}
