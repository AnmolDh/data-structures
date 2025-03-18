package Sorting_Algorithms;

public class Algorithm {
    public static void heapSort(Applicant[] arr) {
        int n = arr.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(Applicant[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left].expectedSalary > arr[largest].expectedSalary) {
            largest = left;
        }

        if (right < n && arr[right].expectedSalary > arr[largest].expectedSalary) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    private static void swap(Applicant[] arr, int i, int j) {
        Applicant temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
