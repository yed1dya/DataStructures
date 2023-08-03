package week1;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 6, 2, 9};
        countingSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void countingSort(int[] arr) {
        int min = min(arr), max = max(arr);
        int[] countArr = new int[max-min+1];
        for(int value : arr){
            countArr[value - min]++;
        }
        int index = 0;
        for(int i=0; i<max-min+1; i++){
            while (countArr[i] > 0){
                arr[index++] = i+min;
                countArr[i]--;
            }
        }
    }

    public static void countingSort2(int[] arr){
        int min = min(arr), max = max(arr);
        int len = max-min+1;
        int[] countArr = new int[len];
        for(int value : arr){
            countArr[value - min]++;
        }
        for(int i=1; i<len; i++){
            countArr[i] += countArr[i-1];
        }
        int[] temp = new int[len];
        for(int i=arr.length-1; i>=0; i--){
            int current = arr[i];
            int position = countArr[current-min]-1;
            temp[position] = current;
            countArr[current-min]--;
        }
        System.arraycopy(temp,0, arr, 0, arr.length);
    }

    public static int min(int[] arr){
        int ans = 0;
        if(arr!=null && arr.length>0){
            ans = arr[0];
            for (int j : arr) {
                ans = Math.min(ans, j);
            }
        }
        return ans;
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
