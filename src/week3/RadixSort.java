package week3;
import java.util.Arrays;

public class RadixSort {//for integer numbers
	//O(n)+O(n*log(max)+O(base))=O(n*log(max))
	public static void radixSort( int[] a){
		int i, max = a[0], exp = 1, n = a.length;
		int base = 10;
		int[] temp = new int[n];
		for (i = 1; i < n; i++){ // O(n)
			if (a[i] > max) max = a[i];
		}
		while (max/exp > 0){ // O(log10(max)
			int[] bucket = new int[base];
			for (i = 0; i < n; i++){ // O(n)
				int index = (a[i] / exp) % base;
				bucket[index]++;
			}
			//.out.println("frequency: "+Arrays.toString(bucket));
			for (i = 1; i < base; i++){  // O(base)
				bucket[i] = bucket[i] + bucket[i - 1];
			}
			//System.out.println("cumulative frequency: "+Arrays.toString(bucket));
			for (i = n - 1; i >= 0; i--){
				//temp[--bucket[(a[i] / exp) % base]] = a[i];
				int j = (a[i] / exp) % base;
				temp[--bucket[j]] = a[i];
				//System.out.println("i = " + i + ", bucket: " + Arrays.toString(bucket));
				//System.out.println("i = " + i + ", temp: " + Arrays.toString(temp));
			}
			//System.out.println(Arrays.toString(temp));
			for (i = 0; i < n; i++)
				a[i] = temp[i];
			exp = exp * base;        
		}
	}
	
	public static void radixSortWrong( int[] a){//O(n)+O(n*log(k))=O(n*log(k))
		int i, max = a[0], exp = 1, n = a.length;
		int base = 10;
		int[] temp = new int[n];
		for (i = 1; i < n; i++){
			if (a[i] > max) max = a[i];
		}
		while (max/exp > 0){
			int[] bucket = new int[base];
			for (i = 0; i < n; i++){
				int index = (a[i] / exp) % base;
				bucket[index]++;
			}
			for (i = 1; i < base; i++){
				bucket[i] = bucket[i] + bucket[i - 1];
			}
			for (i = 0; i < n; i++){//for (i = n - 1; i >= 0; i--){
				//temp[--bucket[(a[i] / exp) % base]] = a[i];
				int ind1 = (a[i] / exp) % base;
				bucket[ind1] = bucket[ind1] - 1;
				int ind2 = bucket[ind1];
				temp[ind2] = a[i];
			}
			System.out.println(Arrays.toString(temp));
			for (i = 0; i < n; i++)
				a[i] = temp[i];
			exp = exp * base;        
		}
	}
	public static void checkRadix(){
		int[]a = {493, 812, 715 ,212};
		radixSort(a);
		System.out.println(Arrays.toString(a));
		
		int[]a1 = {877, 567, 3456};
		radixSort(a1);
		System.out.println(Arrays.toString(a1));
		
		int[]a2 = {329,457,657,839,436,720,355};
		radixSort(a2);
		System.out.println(Arrays.toString(a2));

		int[]a3 = {9,7,7,9,6,0,5};
		radixSort(a3);
		System.out.println(Arrays.toString(a3));
		//////////
		int[]a4 = {877, 567, 9456};
		radixSort(a4);
		System.out.println(Arrays.toString(a4));
		int size = 100000000;
		int [] a5 = MyLibrary.randomIntegerArray(size);

	}
	public static void checkRadixReverse(){
		//int[]a1 = {877, 567, 3456};
		int[]a1 = {8, 5, 10};
		radixSortWrong(a1);
		System.out.println(Arrays.toString(a1));
		/*
		 *  [3456, 567, 877]
			[3456, 567, 877]
			[3456, 567, 877]
			[877, 567, 3456]
		 */
	}
	
	public static void checkRadixTime(){
		int size = 100000000;
		int [] a = MyLibrary.randomIntegerArray(size);
		int[]b = Arrays.copyOf(a, size);
		long  timeBefore,timeAfter;
		double elapse;
// java sort
		timeBefore = System.currentTimeMillis();
		Arrays.sort(a);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("Java Sort time = " + elapse+" seconds, is sorted? "+MyLibrary.isSorted(a));
// radix sort
		timeBefore = System.currentTimeMillis();
		radixSort(b);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("Radix Sort time = " + elapse+" seconds, is sorted? "+MyLibrary.isSorted(a));
	}
	public static void main(String[] args) {
		//checkRadixTime();
		int[]a = {4,8,4};
		System.out.println(Arrays.toString(a));
		radixSort(a);
	}
}
