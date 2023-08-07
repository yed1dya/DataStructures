package week3;

import java.util.LinkedList;
// LinkedList maintains references to the
// Head and Tail elements, which you can get
// by getFirst() and getLast() respectively.
public class MyQueueGen<T> {
	private final int maxSize;
	private LinkedList<T> data;
	// constructors
	public MyQueueGen(){
		maxSize= -1;
		data = new LinkedList<T>();
	}
	public MyQueueGen(int maxSize){
		this.maxSize= maxSize;
		data = new LinkedList<T>();
	}
	// check if the queue is empty
	public  boolean isEmpty(){
		return data.isEmpty();
	}
	// enqueue new element into the queue
	public  boolean enqueue(T newValue){
		boolean ans = true;
		if (data.size() == maxSize){
			ans = false;
			System.out.println("queue is full");
		}
		else{
			//we use offer(E e) to append an element
			// to the end of the queue; throws exception
			data.offer(newValue);
		}
		return ans;
	}
	// remove the element from the queue
	public T dequeue(){
		T temp = null;
		if (isEmpty()){
			System.out.println("queue is empty");
		}
		else{
			//we use poll() to dequeue and retrieve
			// the head (first element) of the queue.
			temp = data.poll();
		}
		return temp;
	}
	// return the number of elements of the queue
	public int size(){
		return data.size();
	}
	public String toString(){
		return data.toString();
	}
	// the main
	public static void main(String[] args) {
		MyQueueGen<Integer> q = new MyQueueGen<>();
		for (int i=0; i<=5; i=i+1){
			if (q.enqueue(i*2)){
				System.out.println("insert "+i*2);
			}
		}
		System.out.println(q);
		// remove 2 elements: 0,2
		q.dequeue();
		System.out.println(q);
		q.dequeue();
		System.out.println(q);
		if(q.enqueue(99))
			System.out.println(q);
		if(q.enqueue(999))
			System.out.println(q);
	}
}
