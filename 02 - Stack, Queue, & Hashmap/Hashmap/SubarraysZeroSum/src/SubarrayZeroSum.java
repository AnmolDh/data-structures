import java.util.ArrayList;
import java.util.HashMap;

public class SubarrayZeroSum {
    private final ArrayList<Integer> array;

    public SubarrayZeroSum() {
        this.array = new ArrayList<>();
    }

    public ArrayList<Integer> getList() {
        return array;
    }

    public void addToList(int value) {
        array.add(value);
    }

    public int subarrayZeroSum(int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;

        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
            int prev = sum - k;
            count += map.getOrDefault(prev, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
