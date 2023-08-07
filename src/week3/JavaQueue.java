package week3;

import java.util.concurrent.ArrayBlockingQueue;

public class JavaQueue {
	/**
	 * FIFO blocking queue where the elements are stored in an fixed size array.
	 * The array buffer is circular, sometimes called a squirrel cage 
	 * buffer. When the array fills up it wraps around to the beginning 
	 * being careful not to overwrite existing elements. 
	 * If all goes well, the oldest elements are popped off in time 
	 * to create room for new elements, hot on their heels.
	 */

	public static void main(String[] args) {
		ArrayBlockingQueue<String> q = new ArrayBlockingQueue<String>(3);
		System.out.print(q.offer("a")+", ");
		System.out.print(q.offer("b")+", ");
		System.out.println(q.offer("c"));
		System.out.println(q.offer("d"));
		while(!q.isEmpty()) {
			System.out.print(q.poll()+", ");
		}
		System.out.println();
		System.out.println(q.poll()+", ");
		//
		System.out.print(q.add("a")+", ");
		System.out.print(q.add("b")+", ");
		System.out.println(q.add("c"));
		System.out.println(q.add("d"));// throws exception
		// q.put()
		// Inserts the specified element at the tail of this queue,
		// waiting for space to become available if the
		// queue is full.;
	}
}
