package week1;

import java.util.Arrays;

public class BinarySearchFirst {
	/**
	 * Binary search by induction
	 * @param arr - sorted array of integer numbers
	 * @param value to search
	 * @return index of value if found, otherwise return -1
	 */
	public static int binarySearchInducion(int []arr,int value){
		if (value<arr[0])  return -1;
		if (value>arr[arr.length-1]) return -arr.length-1;
		int low = 0, high = arr.length-1;
		int middle = (low + high)/2;
		while (low <=high){
			middle = (low + high)/2;
			if (arr[middle] == value){//value was found
				return middle;
			}
			// value suppose to be left
			if (value < arr[middle]){
				high = middle-1;
			}
			// value suppose to be right
			else{
				low = middle+1;
			}
		}
		return -1;
	}
	public static int binary_search_recurs(int arr[],int low,int high,int value){
		if (low <= high){
			int mid = (low+high)/2;
			if (value==arr[mid])   return mid;//value was found
			// value suppose to be on left
			else if (value<arr[mid]) return binary_search_recurs(arr, low, mid-1,value);
			// value suppose to be on right
			else return binary_search_recurs(arr, mid+1, high,value);
		}
		else return -1;
	}
	public static int binarySearchRecursive(int arr[], int value){
		if (value<arr[0])  return -1;
		if (value>arr[arr.length-1]) return -arr.length-1;
		return binary_search_recurs(arr, 0, arr.length-1,value);
	}
	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 6, 7};
		System.out.print(binarySearchInducion(arr,1)+", ");
		System.out.print(binarySearchInducion(arr,2)+", ");
		System.out.print(binarySearchInducion(arr,3)+", ");
		System.out.print(binarySearchInducion(arr,4)+", ");
		System.out.print(binarySearchInducion(arr,5)+", ");
		System.out.print(binarySearchInducion(arr,6)+", ");
		System.out.println(binarySearchInducion(arr,7)+", ");
		
		int size = 1000000;
		int []arr2 = MyLibrary.randomIntArrayOfDiffNumbers(size);
		Arrays.sort(arr2);
		long start = System.nanoTime();
		int ind = binarySearchInducion(arr2,arr2[size-1]);
		long end = System.nanoTime();
		System.out.println("index = "+ind+", time = "+(end-start)+"ns");
		
		start = System.nanoTime();
		ind = binarySearchInducion(arr2,arr2[0]);
		end = System.nanoTime();
		System.out.println("index = "+ind+", time = "+(end-start)+"ns");
		
		System.out.println("arr2[size/2 = "+arr2[size/2]);
		start = System.nanoTime();
		ind = binarySearchInducion(arr2,arr2[size/2]);
		end = System.nanoTime();
		System.out.println("index = "+ind+", time = "+(end-start)+"ns");
		
		start = System.nanoTime();
		ind = Arrays.binarySearch(arr2,arr2[0]);
		end = System.nanoTime();
		System.out.println("index = "+ind+", time = "+(end-start)+"ns");

	}
}
