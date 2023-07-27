/**
 * @author 207404997
 */
public class Ex1 {
    public static void main(String[] args) {
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
     * @param arr array to search
     * @param k target integer
     * @return String of the first and last indexes of k in arr
     */
    public static String rangeOfK(int[] arr, int k){
        int start = -1, end = -1;
        if(arr!=null && arr.length!=0) {
            start = findFirst(arr, k);
            end = findLast(arr, k);
        }
        return "[" + start + "," + end + "]";
    }

    /**
     * @param arr array to search
     * @param k target integer
     * @return first index of k in arr
     */
    public static int findFirst(int[] arr, int k){
        int low = 0, high = arr.length-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid]==k && (mid==0 || arr[mid-1] < k)) return mid;
            else if(k>arr[mid]) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }

    /**
      * @param arr array to search
     * @param k target integer
     * @return last index of k in arr
     */
    public static int findLast(int[] arr, int k){
        int low = 0, high = arr.length-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid]==k && (mid==high || arr[mid+1] > k)) return mid;
            else if(k<arr[mid]) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}
