import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Window {
    private final ArrayList<Integer> list;

    public Window() {
        list = new ArrayList<>();
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public void add(int x) {
        list.add(x);
    }

    public ArrayList<Integer> getWindowMaximum(int windowSize) {
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        int currentWindowMax = -1;
        for (int i = 0; i < windowSize; i++) {
            deque.addLast(i);
            currentWindowMax = Math.max(currentWindowMax, list.get(deque.peekLast()));
        }
        result.add(currentWindowMax);

        int s = windowSize;
        while (s < list.size()) {
            deque.removeFirst();
            deque.addLast(s);
            currentWindowMax = Math.max(currentWindowMax, list.get(deque.peekLast()));
            result.add(currentWindowMax);
            s++;
        }

        return result;
    }
}
