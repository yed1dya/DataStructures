package week3;

import java.util.Arrays;

public class CountingSort {
	public static void countingSort0(int[]a) {
		/* find max and min values */
		int min = a[0], max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < min) min = a[i];
			else if (a[i] > max) max = a[i];
		}
		int range = max - min + 1;
		/* make count/frequency array for each element */
		int []freq = new int[range];
		for (int value : a) {
			int index = value - min;
			freq[index]++;
		}
		/* modify original array */
		int k = 0;
		for (int i = 0; i < freq.length; i++) {
			for (int j = 0; j < freq[i]; j++) {
				a[k++] = i + min;
			}
		}		
	}
	public static void checkCounting0(){
		int []a0 = {4,8,4,2,9,9,6,2,9};
		countingSort0(a0);
		System.out.println(Arrays.toString(a0));

		int[]a2 = {877, 567, 9876, 111,8};
		countingSort0(a2);
		System.out.println(Arrays.toString(a2));
		int[]a1 = {877, 567, 3456, 876, 467, 26, 934, 9876, 1, 4567,90,100,0};
		countingSort0(a1);
		System.out.println(Arrays.toString(a1));
		int[]a3 = {1,2,3,4,5,6};
		countingSort0(a3);
		System.out.println(Arrays.toString(a3));
		int[]a4 = {9,8,7,6,5,4,3,2,1,0};
		countingSort0(a4);
		System.out.println(Arrays.toString(a4));

	}
	public static void countingSort1(int[] a) {//O(n+k)
		/* find max and min values */
		int N = a.length;
		int max = a[0], min = a[0];
		for (int i = 1; i < N; i++){
			if (a[i] > max) max = a[i];
			if (a[i] < min)  min = a[i];
		}
		int range = max - min + 1;
		/* make count/frequency array for each element */
		int []count = new int[range];
		for (int i = 0; i < a.length; i++)
			count[a[i] - min]++;
		/* modify count so that positions in final array is obtained */
		for (int j = 1; j < range; j++)
			count[j] = count[j] + count[j-1];

		/* modify original array */
		for (int i = 0, j = 0; j < range; j++){
			while(i < count[j]) a[i++] = j + min;
		}
	}
	public static void checkCounting1(){
		int []a0 = {4,8,4,2,9,9,6,2,9};
		countingSort1(a0);
		System.out.println(Arrays.toString(a0));

		int[]a2 = {877, 567, 9876, 111,8};
		countingSort1(a2);
		System.out.println(Arrays.toString(a2));
		int[]a1 = {877, 567, 3456, 876, 467, 26, 934, 9876, 1, 4567,90,100,0};
		countingSort1(a1);
		System.out.println(Arrays.toString(a1));
		int[]a3 = {1,2,3,4,5,6};
		countingSort1(a3);
		System.out.println(Arrays.toString(a3));
		int[]a4 = {9,8,7,6,5,4,3,2,1,0};
		countingSort1(a4);
		System.out.println(Arrays.toString(a4));
		//
		int size = 100000000;
		int [] a = MyLibrary.randomIntegerArray(size);
		int[]b = Arrays.copyOf(a, size);
		// java sort
		long timeBefore = System.currentTimeMillis();
		Arrays.sort(a);
		long timeAfter = System.currentTimeMillis();
		double elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("Java Sort time = " + elapse+" seconds, is sorted? "+MyLibrary.isSorted(a));
// counting sort
		timeBefore = System.currentTimeMillis();
		countingSort1(b);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("Counting Sort time = " + elapse+" seconds, is sorted? "+MyLibrary.isSorted(a));

	}

	public static void main(String[] args) {
		checkCounting0();
		checkCounting1();
	}
}
