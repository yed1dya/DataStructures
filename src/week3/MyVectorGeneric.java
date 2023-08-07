package week3;

public class MyVectorGeneric<T> {
	private int count;
	private final int INIT_SIZE = 10;
	private T [] data;
	////////// iterator
	
	@SuppressWarnings("unchecked")
	public MyVectorGeneric(){
		count = 0;
		data = (T [])(new Object[INIT_SIZE]);
		//data = new T[INIT_SIZE]; ERROR!
	}
	public void add(T value){
		if (count == data.length) resize();
		data[count++] = value;
	}
	@SuppressWarnings("unchecked")
	private void resize(){
		T [] temp = (T [])(new Object[data.length+INIT_SIZE]);
		System.arraycopy(data, 0, temp, 0, data.length);
		data = temp;
	}
	public int size(){return count;}
	
	public T elementAt(int i){
		return data[i];
	}
	public int capacity(){return data.length;}
	
	public String toString(){
		String s = "[";
		for (int i = 0; i<count; i++){
			s = s + data[i] + ", ";
		}
		s  = s + "]";
		return s;
	}
	public static<T> boolean f(T x,T y){
		return x.equals(y);
	}
}
