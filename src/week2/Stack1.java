package week2;
import java.util.ArrayList;

public class Stack1<T> {
    protected ArrayList<T> stack;
    protected int size;
    public Stack1(){
        stack = new ArrayList<>();
        size = 0;
    }
    public boolean push(T data){
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

    public boolean tryPop(){
        if(size==0) return false;
        this.pop();
        return true;
    }
    public String toString(){
        StringBuilder ans = new StringBuilder();
        while (this.size>0){
            ans.append(this.pop()).append(", ");
        }
        if(ans.toString().endsWith(", ")){
            ans = new StringBuilder(ans.substring(0, ans.length() - 2));
        }
        return ans.toString();
    }
}
