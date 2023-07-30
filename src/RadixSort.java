import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {34, -55, 65, -35, 0, 32, 456, -156, 464345, 44, 2435};
        int[] a = {32, 456, 156, 464345, 44, 2435};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void radixSort(int[] arr){
        int[] negativeArr = new int[arr.length];
        int[] positiveArr = new int[arr.length];
        int n=0, p=0;
        for (int t : arr) {
            if (t < 0) {
                negativeArr[n++] = -t;
            } else {
                positiveArr[p++] = t;
            }
        }
        int[] temp = new int[n];
        for(int k=0; k<n; k++){
            temp[k] = negativeArr[k];
        }
        negativeArr = new int[n];
        for(int k=0; k<n; k++){
            negativeArr[k] = temp[k];
        }
        temp = new int[p];
        for(int k=0; k<p; k++){
            temp[k] = positiveArr[k];
        }
        positiveArr = new int[p];
        for (int k=0; k<p; k++){
            positiveArr[k] = temp[k];
        }
        int maxNegative = max(negativeArr),
                maxPositive = max(positiveArr);
        for(int exp = 1; maxNegative/exp > 0; exp *= 10){
            countingSort(negativeArr, exp);
        }
        for(int exp = 1; maxPositive/exp > 0; exp *= 10){
            countingSort(positiveArr, exp);
        }
        int i=0, j=0;
        while (i<n){
            arr[n-i-1] = -negativeArr[i++];
        }
        while (j<p){
            arr[i++] = positiveArr[j++];
        }
    }

    public static void countingSort(int[] arr, int exp){
        int[] output = new int[arr.length];
        int[] countArr = new int[10];
        // make index array:
        for(int value : arr){
            countArr[(value/exp)%10]++;
        }
        // make into addition series:
        for(int i=1; i<countArr.length; i++){
            countArr[i] += countArr[i-1];
        }
        // build output array:
        for(int i=arr.length-1; i>=0; i--){
            int current = arr[i];
            int position = countArr[(current/exp) % 10] - 1;
            output[position] = current;
            countArr[(current/exp) % 10]--;
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static int max(int[] arr){
        int ans = 0;
        if(arr!=null && arr.length>0){
            ans = arr[0];
            for (int j : arr) {
                ans = Math.max(ans, j);
            }
        }
        return ans;
    }

}
