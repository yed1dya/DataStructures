package week3;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class RadixSortTest {

	@Test(timeout=1000)
	public void test1() {
		int size = 100000;
		int[] a = MyLibrary.randomIntegerArray(size);
		int[] b = Arrays.copyOf(a, size);
		//int[] c = Arrays.copyOf(a, size);
		long timeBefore, timeAfter;
		double elapse;
		// java sort
		timeBefore = System.currentTimeMillis();
		Arrays.sort(a);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter - timeBefore) / 1000.0;
		System.out.println("Java Sort time = " + elapse);
		assertTrue(MyLibrary.isSorted(a));
		// radix sort
		timeBefore = System.currentTimeMillis();
		RadixSort.radixSort(b);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter - timeBefore) / 1000.0;
		System.out.println("Radix Sort time = " + elapse);
		assertTrue(MyLibrary.isSorted(b));
	}
	@Test(timeout=500)
	public void test2() {
		int [] a = {877, 567, 3456};
		RadixSort.radixSort(a);
		int[] expected = {567,877,3456};
		assertArrayEquals(expected, a);
	}
	@Test(timeout=500)
	public void test3() {
		int [] a = {567,877,3456};
		RadixSort.radixSort(a);
		int[] expected = {567,877,3456};
		assertArrayEquals(expected, a);
	}
}
