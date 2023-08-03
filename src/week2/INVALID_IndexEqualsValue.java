package week2;
// from gpt, doesn't work (roni-1, gpt-0)
public class INVALID_IndexEqualsValue {
    public static boolean hasIndexEqualsValue(int[] arr) {
        // Since the array is sorted in non-decreasing order, we can use binary search
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == mid) {
                return true;
            } else if (arr[mid] < mid) {
                // If arr[mid] < mid, we need to search the right half of the array
                left = mid + 1;
            } else {
                // If arr[mid] > mid, we need to search the left half of the array
                right = mid - 1;
            }
        }

        // If we reach here, it means no such index was found
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = { -2, 0, 2, 3, 6, 7, 9 };
        System.out.println(hasIndexEqualsValue(arr1)); // Output: true (arr[3] = 3)

        int[] arr2 = { -2, 0, 1, 3, 5, 7 };
        System.out.println(hasIndexEqualsValue(arr2)); // Output: false (no such index exists)

        int[] arr3 = {1,1,3,4,5};
        System.out.println(hasIndexEqualsValue(arr3));
    }
}

