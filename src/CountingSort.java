import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 6, 2, 9};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void countingSort(int[] arr){
        int[] count = new int[10];
        for(int i : arr){
            count[i]++;
        }
        for(int i=1; i<9; i++){
            count[i] += count[i-1];
        }
        int[] sorted = new int[10];
        for(int i=0; i<9; i++){
            sorted[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }
        for(int i=1; i<10; i++){
            arr[i] = sorted[i];
        }
    }

}
