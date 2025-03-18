package Sorting_Algorithms;

public class QuickSort {
    public static void quickSort(Product[] products, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(products, low, high);
            quickSort(products, low, pivotIndex - 1);
            quickSort(products, pivotIndex + 1, high);
        }
    }

    private static int partition(Product[] products, int low, int high) {
        int pivot = products[high].price;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (products[j].price < pivot) {
                i++;
                swap(products, i, j);
            }
        }
        swap(products, i + 1, high);
        return i + 1;
    }

    private static void swap(Product[] products, int i, int j) {
        Product temp = products[i];
        products[i] = products[j];
        products[j] = temp;
    }
}
