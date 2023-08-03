package week2;
import java.util.Stack;
import java.util.ArrayList;

public class MyStackArrayList<T> {
    private final int MAX_SIZE = 100;
    private ArrayList<T> stack;
    private int size;
    public MyStackArrayList(){
        stack = new ArrayList<>();
        size = 0;
    }
    public boolean push(T data){
        if(size==MAX_SIZE) return false;
        stack.add(data);
        size++;
        return true;
    }
    public T peek(){
        if(size==0) return null;
        return stack.get(size-1);
    }
    public T pop(){
        if(size==0) return null;
        return stack.remove(--size);
    }
    public int size(){
        return size;
    }

    public void clear(){
        stack.clear();
        size = 0;
    }
}
