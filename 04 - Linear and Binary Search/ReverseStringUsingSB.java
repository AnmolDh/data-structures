import java.util.Scanner;
public class ReverseStringUsingSB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        
        StringBuilder sb = new StringBuilder();
        sb.append(sc.nextLine());
        System.out.println("Reversed string: " + sb.reverse());

        String reversedString = sb.toString();
        System.out.println("Reversed string: " + reversedString);

    }
}
