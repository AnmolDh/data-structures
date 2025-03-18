package Sorting_Algorithms;

public class Algorithm {
    public static void selectionSort(Exam[] students) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (students[j].percentage < students[minIndex].percentage) {
                    minIndex = j;
                }
            }
            swap(students, i, minIndex);
        }
    }

    private static void swap(Exam[] students, int i, int j) {
        Exam temp = students[i];
        students[i] = students[j];
        students[j] = temp;
    }
}
