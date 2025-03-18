import java.util.ArrayList;
import java.util.HashSet;

public class LongestConsecutive {
    public static int find(ArrayList<Integer> list){
        HashSet<Integer> map = new HashSet<>(list);
        int cnt = 0;
        for(int i=0; i<list.size(); i++){
            int c = 0;
            int n = list.get(i);
            if (map.contains(n-1)) continue;
            while (map.contains(n)){
                c++;
                n++;
            }
            cnt = Math.max(cnt, c);
        }
        return cnt;
    }
}
