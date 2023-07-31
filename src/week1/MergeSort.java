package week1;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {2, 8, 9, 13, 14}, b = {1, 5, 8, 10, 12}, c = {3, 8, 1, 9, 4, 5, 3, 7};
        mergeSort(c);
        System.out.println(Arrays.toString(c));
    }

    public static void mergeSort(int[] arr){
        int len = arr.length;
        if(len < 2) return;
        int mid = len/2;
        int[] left = new int[mid];
        int[] right = new int[len-mid];
        for(int i=0; i<mid; i++) left[i] = arr[i];
        for(int i=mid; i<len; i++) right[i-mid] = arr[i];
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        int i=0, j=0, k=0;
        while (i<n1 && j<n2){
            arr[k++] = a[i]<b[j] ? a[i++] : b[j++];
        }
        while (i<n1){
            arr[k++] = a[i++];
        }
        while(j<n2){
            arr[k++] = b[j++];
        }
    }
}
