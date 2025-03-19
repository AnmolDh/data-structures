import java.util.Arrays;

public class SearchChallenge {

    // Linear Search: Find the first missing positive integer.
    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;
        // Step 1: Replace non-positive numbers and numbers greater than n with n+1.
        // (n+1 is outside the range [1, n], so it won't affect the marking process.)
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = n + 1;
            }
        }
        
        // Step 2: Use the indices of the array to mark which numbers are present.
        // For each number in the array, mark the corresponding index as negative.
        for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]);
            if (val <= n) {
                // Mark index (val - 1) as negative to indicate that val is present.
                arr[val - 1] = -Math.abs(arr[val - 1]);
            }
        }
        
        // Step 3: The first index that has a positive value indicates the missing number.
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        // If every number from 1 to n is present, the missing number is n+1.
        return n + 1;
    }

    // Binary Search: Given a sorted array, find the index of the target value.
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid; // Target found.
            } else if (arr[mid] < target) {
                left = mid + 1; // Search right half.
            } else {
                right = mid - 1; // Search left half.
            }
        }
        return -1; // Target not found.
    }

    public static void main(String[] args) {
        // Part 1: Linear Search for the first missing positive integer.
        int[] numbers = {3, 4, -1, 1};
        // Copy the array because firstMissingPositive modifies it.
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        int missing = firstMissingPositive(numbersCopy);
        System.out.println("First missing positive: " + missing);
        
        // Part 2: Binary Search to find the index of a given target number.
        // For binary search, we need a sorted array.
        int target = 4;
        int[] sortedNumbers = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedNumbers);
        System.out.println("Sorted array: " + Arrays.toString(sortedNumbers));
        int index = binarySearch(sortedNumbers, target);
        System.out.println("Index of " + target + " in sorted array: " + index);
    }
}
