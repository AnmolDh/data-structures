import java.util.ArrayList;
import java.util.Collections;

public class StockSpan {
    private final ArrayList<Integer> prices;

    public StockSpan() {
        prices = new ArrayList<>();
    }

    public ArrayList<Integer> get() {
        return prices;
    }

    public void add(int price) {
        prices.add(price);
    }

    public ArrayList<Integer> getSpan() {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(prices.size(), 0));

        for (int i = 0; i < prices.size(); i++) {
            while (!stack.isEmpty() && prices.get(i) >= prices.get(stack.peek())) {
                stack.pop();
            }
            result.set(i, (stack.isEmpty() ? (i + 1) : (i - stack.peek())));
            stack.push(i);
        }

        return result;
    }
}
