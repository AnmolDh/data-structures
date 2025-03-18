import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(){{
            add(2);
            add(1);
            add(4);
            add(3);
            add(5);
            add(6);
        }};

        System.out.println(LongestConsecutive.find(list));;
    }
}