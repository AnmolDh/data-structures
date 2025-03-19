public class FirstLastOccurrence {
    
    // Find the first occurrence of target in a sorted array.
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;         // record the current index
                right = mid - 1;        // continue searching on the left side
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else { // arr[mid] > target
                right = mid - 1;
            }
        }
        return result;
    }
    
    // Find the last occurrence of target in a sorted array.
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;         // record the current index
                left = mid + 1;         // continue searching on the right side
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else { // arr[mid] > target
                right = mid - 1;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);
        
        if(first == -1) {
            System.out.println("Target not found");
        } else {
            System.out.println("First occurrence: " + first);
            System.out.println("Last occurrence: " + last);
        }
    }
}
