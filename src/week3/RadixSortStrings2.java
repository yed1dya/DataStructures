package week3;

import java.util.Arrays;

public class RadixSortStrings2 {

	// LSD radix sort
    public static void sort(String[] a, int len) {
        int n = a.length;
        int range = 256;   // extend ASCII alphabet size
        String[] temp = new String[n];

        for (int d = len-1; d >= 0; d--) {
            // sort by key-indexed counting on d-th character

            // compute frequency counts
            int[] count = new int[range];
            for (int i = 0; i < n; i++)
                count[a[i].charAt(d)]++;

            // compute cumulates
            for (int r = 1; r < range; r++)
                count[r] = count[r-1] + count[r];

            // move data
            for (int i = 0; i < n; i++){
            	int j = a[i].charAt(d)-1;
            	temp[count[j]++] = a[i];
               // temp[count[a[i].charAt(d)]++] = a[i];
            }
            // copy back
            for (int i = 0; i < n; i++)
                a[i] = temp[i];
        }
    }
	public static void main(String[] args) {
		String[]s = {"yes", "yet", "dad", "zoo", "all", "bad", "bug","big","fat","let","cat"};
		sort(s, 3);
		System.out.println(Arrays.toString(s));
		System.out.println((char)253);
		////////////////////
		double x = Math.pow(10, 10);
		System.out.println(Integer.MAX_VALUE+", "+x);
	}

}
