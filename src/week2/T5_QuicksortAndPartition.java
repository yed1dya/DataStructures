package week2;

import java.util.Arrays;

public class T5_QuicksortAndPartition {
    public static void main(String[] args) {
        int[] a = {-3,6,12,4,-7,45,-6,-3,-1,2,3,10,1,2,3,4,5};
        Q1(a);
        System.out.println(Arrays.toString(a));
        int[] b = {0,3,6,2,87,43,234,32,11,9,54,12};
        System.out.println(Q5(b));
        System.out.println(Arrays.toString(b));
    }
    public static int Q5(int[] arr){
        countingSort(arr, 256);
        if(arr.length%2==1){
            return arr[(arr.length/2)];
        }
        return (arr[(arr.length/2)-1]+arr[(arr.length/2)])/2;
    }
    public static void countingSort(int[] arr, int range){
        int[] indexArr = new int[range];
        int[] ans = new int[arr.length];
        for (int i : arr){
            indexArr[i]++;
        }
        for(int i=1; i< indexArr.length; i++){
            indexArr[i]+=indexArr[i-1];
        }
        for(int i=arr.length-1; i>=0; i--){
            int place = indexArr[arr[i]]-1;
            ans[place] = arr[i];
            indexArr[arr[i]]--;
        }
        System.arraycopy(ans,0, arr, 0, arr.length);
    }
    public static void Q2(int[] arr){
        if(arr==null || arr.length<2) return;
        int a=arr[0], b=arr[1], i=1, aCount=0, bCount=0;
        while (b==a && i<arr.length){
            b=arr[i++];
        }
        for(int number : arr){
            if(number==a) aCount++;
            else bCount++;
        }
    }
    public static void Q1(int[] arr){
        int evenCount=0, oddCount=0;
        for(int i : arr){
            if(i%2==0) evenCount++;
            else oddCount++;
        }
        int[] evens = new int[evenCount];
        int[] odds = new int[oddCount];
        evenCount=0; oddCount=0;
        for(int i : arr){
            if(i%2==0) evens[evenCount++] = i;
            else odds[oddCount++] = i;
        }
        int j=0;
        for(int i : evens){
            arr[j++] = i;
        }
        for(int i : odds){
            arr[j++] = i;
        }
    }
}
