public class PeakElementFinder {

    public static int findPeakElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // Invalid input: return -1 if the array is empty.
        }
        
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Check if mid is a peak:
            // For the left boundary, ignore the left neighbor.
            // For the right boundary, ignore the right neighbor.
            if ((mid == 0 || arr[mid] >= arr[mid - 1]) &&
                (mid == arr.length - 1 || arr[mid] >= arr[mid + 1])) {
                return mid; // mid is a peak element.
            }
            // If the left neighbor is greater, then there must be a peak on the left side.
            else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            // Otherwise, the right neighbor is greater, so a peak lies to the right.
            else {
                left = mid + 1;
            }
        }
        
        return left; // Alternatively, we could return -1; this line is never reached if the array is non-empty.
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int peakIndex = findPeakElement(arr);
        System.out.println("Peak element: " + arr[peakIndex] + " at index: " + peakIndex);
    }
}
