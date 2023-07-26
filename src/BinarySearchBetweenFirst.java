package binarySearch;

public class BinarySearchBetweenFirst {
	public static int binarySearchBetween(int []arr, int value){
		/**
	if value<arr[0] the function returns zero
	if value>arr[end] the function returns  end+1
	if arr[index-1] < value <= arr[index]
	the function returns index,
		 */
		int low = 0, n = arr.length, high = n-1;
		if (value<arr[0]) return 0;
		if (value>arr[n-1])  return n;
		while (low <= high){
			int middle = (low + high)/2;
			if (low == high) {// stop search
				return low;
			}
			else {
				if (arr[middle] == value){//value was found
					return middle;
				}
				if (value < arr[middle]){// value suppose to be left
					high = middle;
				}
				else{// value suppose to be right
					low = middle+1;
				}
			}
		}
		return -1;
	}
	public static void main(String args[]){
		int a[] = {2, 5, 8, 12, 13, 17, 18, 20};
		int ind = binarySearchBetween(a, 1);
		System.out.print("ind(1)="+ind + ", ");
		
		ind = binarySearchBetween(a, 2);
		System.out.print("ind(2)="+ind + ", ");
		
		ind = binarySearchBetween(a, 4);
		System.out.print("ind(4)="+ind + ", ");
		
		ind = binarySearchBetween(a, 5);
		System.out.print("ind(5)="+ind + ", ");
		
		ind = binarySearchBetween(a, 7);
		System.out.print("ind(7)="+ind + ", ");
		
		ind = binarySearchBetween(a, 10);
		System.out.println("ind(10)="+ind + ", ");
		
		ind = binarySearchBetween(a, 12);
		System.out.print("ind(12)="+ind + ", ");
		
		ind = binarySearchBetween(a, 15);
		System.out.print("ind(15)="+ind + ", ");
		
		ind = binarySearchBetween(a, 18);
		System.out.print("ind(18)="+ind + ", ");
		
		ind = binarySearchBetween(a, 19);
		System.out.print("ind(19)="+ind + ", ");
		
		ind = binarySearchBetween(a, 20);
		System.out.print("ind(20)="+ind + ", ");
		
		ind = binarySearchBetween(a, 21);
		System.out.println("ind(21)="+ind + ", ");
	}
}
/**
ind(1)=0, ind(2)=0, ind(4)=1, ind(5)=1, ind(7)=2, ind(10)=3, 
ind(12)=3, ind(15)=5, ind(18)=6, ind(19)=7, ind(20)=7, ind(21)=8, 
*/