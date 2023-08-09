package week3;
public class MyQueue {
	private  int front, tail, size;
	private final int INIT_SIZE = 4;
	private final int maxSize;
	private final Integer [] data;
	// constructors
	public  MyQueue(){
		maxSize=INIT_SIZE;
		front = 0;
		tail = 0;
		size = 0;
		data = new Integer[maxSize];
	}
	public  MyQueue(int maxSize){
		this.maxSize = maxSize;
		front = 0;
		tail = 0;
		size = 0;
		data = new Integer[maxSize];
	}
	// check if the queue is empty
	public  boolean isEmpty(){
		return size == 0;
	}
	// enqueue new element into the queue
	public  boolean enqueue(int newValue){
		boolean ans = true;
		if (size == maxSize){
			ans = false;
			System.out.println("queue is full");
		}
		// if tail == _maxSize-1 -> tail=0
		else{
			data[tail] = newValue;
			tail = (tail + 1)%maxSize;
			size = size + 1;
		}
		return ans;
	}
	// remove the element from the queue
	public Integer dequeue(){
		Integer temp = null;
		if (isEmpty()){
			System.out.println("queue is empty");
		}
		else{
			temp = data[front];
			// if front==_maxSize-1 -> front=0
			front = (front + 1)%maxSize;
			size = size - 1;
		}
		return temp;
	}
	// return the number of elements of the queue
	public int size(){
		return size;
	}
	public String toString(){
		String ans = "[";
		for (int i=0; i<size-1; i++){
			ans = ans + data[(i+front)%maxSize] + ", ";
		}
		ans = ans + data[(size-1+front)%maxSize] + "]";
		return ans;
	}
	// the main
	public static void main(String[] args) {
		MyQueue q = new  MyQueue();
		for (int i=0; i<=5; i=i+1){
			if (q.enqueue(i*2)){
				System.out.println("insert "+i*2+", front= "+q.front + ", tail= "+q.tail);		
			}
		}
		System.out.println(q);
		// remove 2 elements: 0,2
		q.dequeue();
		System.out.println("remove 0: front= "+q.front + ", tail= "+q.tail);		
		System.out.println(q);
		q.dequeue();
		System.out.println(q);
		if(q.enqueue(99))
			System.out.println("insert 99: front= "+q.front + ", tail= "+q.tail);		
		System.out.println(q);
		if(q.enqueue(999))
			System.out.println("insert 999: front= "+q.front + ", tail= "+q.tail);
		System.out.println(q);
	}
}
