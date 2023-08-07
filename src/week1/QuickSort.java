package week1;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = {4,6,9,8,5,3,2,1,7};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if(end<=start) return; // base
        int pivot = partition(arr, start, end); // sorts each side according to pivot point - number at last position
        quickSort(arr, start, pivot-1); // recursive call on left side
        quickSort(arr, pivot+1, end); // recursive call on right side
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end]; // set last element as pivot
        int i = start-1; // set i to one before beginning
        for(int j=start; j<=end; j++){
            // put all elements smaller than pivot before pivot
            if(arr[j]<pivot){
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        // put pivot in the middle
        i++;
        int t = arr[i];
        arr[i] = arr[end];
        arr[end] = t;
        return i;
    }

}
