package Sorting_Algorithms;

public class Algorithm {
    public static StudentAge[] countSort(StudentAge[] inputArray, int max) {
        int N = inputArray.length;
        int[] countArray = new int[max + 1];
        StudentAge[] outputArray = new StudentAge[N];

        // Count occurrences of each age
        for (int i = 0; i < N; i++) {
            countArray[inputArray[i].age]++;
        }

        for (int i = 1; i <= max; i++) {
            countArray[i] += countArray[i - 1];
        }

        for (int i = N - 1; i >= 0; i--) {
            int age = inputArray[i].age;
            outputArray[countArray[age] - 1] = inputArray[i];
            countArray[age]--;
        }

        return outputArray;
    }
}
