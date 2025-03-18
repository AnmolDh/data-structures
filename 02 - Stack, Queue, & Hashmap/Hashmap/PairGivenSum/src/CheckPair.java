import java.util.ArrayList;
import java.util.HashMap;

public class CheckPair {
    public Pair<Integer, Integer> getPair(ArrayList<Integer> list, int target) {
        Pair<Integer, Integer> pair = new Pair<>(0, 0);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(target - list.get(i))){
                pair.setFirst(list.get(i));
                pair.setSecond(target - list.get(i));
                break;
            }
            map.put(list.get(i), 1);
        }
        return pair;
    }
}
