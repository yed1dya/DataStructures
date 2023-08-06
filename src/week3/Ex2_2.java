package week3;

public class Ex2_2 {
    public static void main(String[] args) {
        // test case of values
        int[] data = {45, -2, -45, 78, 30, -42, 10, 19, 73, 93};
        mergeSort3(data);
        System.out.println("After 3 way merge sort: ");
        for (int d : data) System.out.print(d + " ");
    }
    public static void mergeSort3(int[] arr){
        if(arr==null || arr.length<2) return;;
        int length = arr.length;
    }
}
