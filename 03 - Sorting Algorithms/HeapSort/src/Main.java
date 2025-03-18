import java.util.Scanner;
import Sorting_Algorithms.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of applicants: ");
        int n = sc.nextInt();
        sc.nextLine();

        Applicant[] applicants = new Applicant[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter role for applicant " + (i + 1) + ": ");
            String role = sc.nextLine();
            System.out.print("Enter expected salary for applicant " + (i + 1) + ": ");
            float salary = sc.nextFloat();
            sc.nextLine();
            applicants[i] = new Applicant(role, salary);
        }

        Algorithm.heapSort(applicants);

        System.out.println("\nSorted Applicants by Expected Salary:");
        for (Applicant applicant : applicants) {
            System.out.println(applicant);
        }
    }
}