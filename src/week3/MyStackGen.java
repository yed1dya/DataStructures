package week3;

import java.util.ArrayList;
import java.util.Stack;


public class MyStackGen<T> {
	ArrayList<T> items;
	int maxLength, top;

	public MyStackGen(int initLength){
		this.maxLength = initLength;
		this.top = -1;
		items = new ArrayList<>(initLength);
	}
	public MyStackGen(){
		items = new ArrayList<>();
		this.maxLength = -1;
	}
	public boolean push(T newVal){
		boolean ans = true;
		if (items.size() == maxLength){
			System.out.println("Stack Overflow");
			ans = false;
		}
		else
			items.add(newVal);
		return ans;
	}
	public T pop(){
		T result = null;
		if (!items.isEmpty())
			result = items.remove(items.size()-1);
		return result;
	}
	public T top(){
		T result = null;
		if (items.size() > 0) result = items.get(items.size()-1);
		return result;
	}
	public void clear(){
		items.clear();
	}
	public boolean empty(){
		return items.isEmpty();
	}
	public int size(){
		return items.size();
	}
	public String toString(){
		return items.toString();
	}
	public static void main(String[] args) {
		MyStackGen<Integer> st = new MyStackGen<>();
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
			System.out.print("item: "+st.pop()+", ");
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
