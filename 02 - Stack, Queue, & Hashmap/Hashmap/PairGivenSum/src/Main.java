import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
            add(4);
        }};

        CheckPair checkPair = new CheckPair();
        Pair<Integer, Integer> pair = checkPair.getPair(list, 4);

        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }
}