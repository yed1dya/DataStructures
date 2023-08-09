package exe;
/**
 * @author 207404997_325168870
 */
public class Ex1 {
    public static void main(String[] args) {
        // a variety of arrays, to tests the function thoroughly:
        int[] a = {1,1,1,2,2,3,3,3,3,3,3,4,5,7,8,10,10,10};
        int[] b = {1,1,1,1,1,1,1,1,1,1,1};
        int[] c = {3};
        int[] d = {};
        int[] e = null;
        System.out.println(rangeOfK(a, 3));
        System.out.println(rangeOfK(a, 8));
        System.out.println(rangeOfK(a, 6));
        System.out.println(rangeOfK(b, 1));
        System.out.println(rangeOfK(b, 2));
        System.out.println(rangeOfK(c, 1));
        System.out.println(rangeOfK(c, 3));
        System.out.println(rangeOfK(d, 1));
        System.out.println(rangeOfK(e, 3));
    }

    /**
     * finds the range of 'k' in 'arr'
     * uses 2 binary search helper functions.
     * @param arr array to search
     * @param k target integer
     * @return String of the first and last indexes of k in arr
     */
    public static String rangeOfK(int[] arr, int k){
        int start = -1, end = -1; // set default values
        if(arr!=null && arr.length!=0) { // base cases should always return [-1,-1]
            start = findFirst(arr, k); // helper function to find index of first occurrence
            end = findLast(arr, k); // helper function to find index of last occurrence
        }
        return "[" + start + "," + end + "]"; // return updated values
    }

    /**
     * uses binary search.
     * @param arr array to search
     * @param k target integer
     * @return first index of k in arr
     */
    public static int findFirst(int[] arr, int k){
        int low = 0, high = arr.length-1; // set range to search
        while(low <= high){ // stopping condition
            int mid = (low + high)/2; // choose middle index
            if(arr[mid]==k && (mid==0 || arr[mid-1] < k)) return mid; // if found the desired value, and there is no other occurrence of the value
            else if(k>arr[mid]) low = mid+1; // if value is above current point
            else high = mid-1; // if value is below current point (or exists another occurrence of the value, further left)
        }
        return -1; // default return
    }

    /**
     * uses binary search.
     * @param arr array to search
     * @param k target integer
     * @return last index of k in arr
     */
    public static int findLast(int[] arr, int k){
        int low = 0, high = arr.length-1; // set range to search
        while(low <= high){ // stopping condition
            int mid = (low + high)/2; // choose middle index
            if(arr[mid]==k && (mid==high || arr[mid+1] > k)) return mid; // if found the desired value, and there is no other occurrence of the value
            else if(k<arr[mid]) high = mid-1; // if value is below current point
            else low = mid+1; // if value is above current point (or exists another occurrence of the value, further right)
        }
        return -1;
    }
}
