package week1;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {9,1,8,2,7,3,6,4,5};
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            int min = i;
            for(int j = i; j < arr.length; j++){
                if(arr[min]>arr[j]) min = j;
            }
            int t = arr[i];
            arr[i] = arr[min];
            arr[min] = t;
        }
    }
}
