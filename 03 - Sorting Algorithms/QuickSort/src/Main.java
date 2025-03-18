import Sorting_Algorithms.Product;

import java.util.Scanner;
import static Sorting_Algorithms.QuickSort.quickSort;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter product details: ");
            String name = sc.nextLine();
            int price = sc.nextInt();
            sc.nextLine();
            products[i] = new Product(name, price);
        }

        quickSort(products, 0, n - 1);

        System.out.println("\nSorted Products by Price:");
        for (Product p : products) {
            System.out.println(p.product + " - " + p.price);
        }
    }
}