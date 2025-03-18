import Sorting_Algorithms.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Exam[] students = new Exam[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter exam percentage: ");
            float percentage = sc.nextFloat();
            sc.nextLine();
            students[i] = new Exam(name, percentage);
        }

        Algorithm.selectionSort(students);

        System.out.println("\nSorted Exam Scores:");
        for (Exam student : students) {
            System.out.println(student);
        }
    }
}