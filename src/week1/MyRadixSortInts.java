package week1;

import java.util.Arrays;

public class MyRadixSortInts {
    public static void main(String[] args) {
        int[] arr = {42, 436, -546, -45, 232, 98};
        //countingSort(arr, 10);
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr){
        // if array is empty or length 1, it's sorted:
        if(arr==null || arr.length<2) return;
        int negatives=0, positives=0, length=arr.length;
        // count how many positives and negatives:
        for(int number : arr){
            if(number<0){ negatives++; }
            else { positives++; }
        }
        // create and fill positive and negative arrays:
        int[] negativeArray = new int[negatives];
        int[] positiveArray = new int[positives];
        negatives=0;
        positives=0;
        int negativeMax=0, positiveMax=0;
        for(int number : arr){
            if(number<0){
                negativeArray[negatives++] = -number;
                negativeMax = Math.max(negativeMax, -number);
            }
            else {
                positiveArray[positives++] = number;
                positiveMax = Math.max(positiveMax, number);
            }
        }
        // radix sort on arrays:
        for(int digit=1; negativeMax/digit>0; digit*=10){
            countingSort(negativeArray, digit);
        }
        for(int digit=1; positiveMax/digit>0; digit*=10){
            countingSort(positiveArray, digit);
        }
        // refill original array:
        for(int i=0; i<negatives; i++){
            arr[i] = -negativeArray[negatives-i-1];
        }
        for(int i=negatives; i<length; i++){
            arr[i] = positiveArray[i-negatives];
        }
    }

    public static void countingSort(int[] arr, int digit){
        int length = arr.length;
        int[] indexArr = new int[10];
        int[] temp = new int[length];
        for(int number : arr){
            int index = (number/digit) % 10;
            indexArr[index]++;
        }
        for(int i=1; i<10; i++){
            indexArr[i] += indexArr[i-1];
        }
        for(int i=length-1; i>=0; i--){
            int number = arr[i];
            int index = (number/digit) % 10;
            int position = indexArr[index]-1;
            indexArr[index]--;
            temp[position] = number;
        }
        for(int i=0; i<length; i++){
            arr[i] = temp[i];
        }
    }
}
