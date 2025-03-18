public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(2);

        Stack<Integer> sortedStack = Stack.sortStack(stack);

        System.out.println("Unsorted Stack: ");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("sorted stack: ");
        while (!sortedStack.isEmpty()) {
            System.out.println(sortedStack.pop());
        }
    }
}