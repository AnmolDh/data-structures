public class RotationPointFinder {
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // If the middle element is greater than the rightmost element,
            // the smallest element is in the right half.
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else { // Otherwise, it's in the left half (including mid).
                right = mid;
            }
        }
        // When left == right, we've found the smallest element.
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int rotationIndex = findRotationPoint(arr);
        System.out.println("Rotation point index: " + rotationIndex);
        System.out.println("Rotation point value: " + arr[rotationIndex]);
    }
}
