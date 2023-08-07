package week3;

import java.util.Stack;


public class MyStack {
	final int MAX_SIZE = 5;
	Integer [] items;
	int current, max;
	
	public MyStack(int max){
		this.max = max;
		items = new Integer[max];
		current = 0;
	}
	public MyStack(){
		max = MAX_SIZE;
		items = new Integer[max];
		current = 0;
	}
	public boolean push(int newVal){
		boolean ans = true;
		if (current == max) ans = false;
		else  items[current++] = newVal;
		return ans;
	}
	public Integer pop(){
		Integer result = null;
		if (current > 0) result = items[--current];
		return result;
	}
	public Integer top(){
		Integer result = null;
		if (current > 0 )result = items[current-1];
		return result;
	}
	public void clear(){
		current = 0;
	}
	public boolean empty(){
		return (current==0);
	}
	public int size(){
		return current;
	}
	public String toString(){
		String result = "";
		for (int i=0; i<current; i++){
			result = result + items[i]+", ";
		}
		return result;
	}
	public static void main(String[] args) {
		MyStack st = new MyStack();
		System.out.println("isEmpty()? "+st.empty());
		System.out.println(st.push(11));
		System.out.println(st.push(12));
		System.out.println("top = "+st.top());
		
		System.out.println("size = "+st.size());
		System.out.println("isEmpty()? "+st.empty());
		System.out.println(st.push(13));
		System.out.println(st.push(14));
		System.out.println(st.push(15));
		System.out.println(st.push(16));
		System.out.println("size = "+st.size());
		System.out.println("stack: "+st.toString());
		while(!st.empty()){
			System.out.print("item: "+st.pop() + ", ");
		}
		System.out.println();
		System.out.println("isEmpty()? "+st.empty());
		System.out.println("size = "+st.size());
		//////
		Stack<Integer> stj = new Stack<Integer>();
		stj.add(1);
		stj.add(2);
		stj.add(3);
		while(!stj.empty())
			System.out.print(stj.pop()+", ");
		System.out.println();
	}
}
