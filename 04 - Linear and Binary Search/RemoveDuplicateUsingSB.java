import java.util.HashSet;
import java.util.Scanner;
public class RemoveDuplicateUsingSB {
    public static void main(String[] args) {
        HashSet <Character> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        StringBuilder sb = new StringBuilder();
        sb.append(sc.nextLine());
        for (int i = 0; i < sb.length(); i++) {
            if (set.contains(sb.charAt(i))) {
                sb.deleteCharAt(i);
                i--;
            } else {
                set.add(sb.charAt(i));
            }
        }
        System.out.println("String after removing duplicates: " + sb);
    }
}
