package week2;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;

public class T7_Queue {
    public static void main(String[] args) {

    }
    public static boolean palindrome(String str){
        if(str==null || str.isEmpty()) return false;
        if(str.length()==1) return true;
        Queue<Character> q = new Queue<Character>() {
            @Override
            public boolean add(Character character) {
                return false;
            }

            @Override
            public boolean offer(Character character) {
                return false;
            }

            @Override
            public Character remove() {
                return null;
            }

            @Override
            public Character poll() {
                return null;
            }

            @Override
            public Character element() {
                return null;
            }

            @Override
            public Character peek() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Character> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Character> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        Stack1<Character> s = new Stack1<>();
        for(int i=0; i<str.length(); i++){
            char temp = str.charAt(i);
            q.add(temp);
            s.push(temp);
        }
        while (!q.isEmpty() && s.size()!=0){
            if(!Objects.equals(q.remove(), s.pop())) return false;
        }
        return true;
    }
    private int front, tail, size;
    private final int INIT_SIZE = 4;
    private final int maxSize;
    private final Integer[] data;
    public T7_Queue(){
        maxSize = INIT_SIZE;
        front = 0;
        tail = 0;
        size = 0;
        data = new Integer[maxSize];
    }
    public T7_Queue(int maxSize){
        this.maxSize = maxSize;
        front = 0;
        tail = 0;
        size = 0;
        data = new Integer[maxSize];
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean enqueue(int newValue){
        if(size==maxSize) return false;
        data[tail] = newValue;
        // same as writing:
        //tail = tail+1==maxSize ? 0 : tail+1;
        tail = (tail+1)%maxSize;
        size++;
        return true;
    }
    public Integer dequeue(){
        if(size==0) return null;
        Integer ans = data[front];
        front = (front+1)%maxSize;
        size--;
        return ans;
    }
    public int size(){
        return size;
    }
    public String toString(){
        String ans = "[";
        for(int i=0; i<size-1; i++){
            ans += data[(front+i)%maxSize] + ", ";
        }
        ans+=data[(front+size-1)%maxSize] + "]";
        return ans;
    }
    public boolean contains(Integer item){
        for(Integer i : data){
            if(Objects.equals(item, i)) return true;
        }
        return false;
    }
    public Integer elementAt(int i){
        if(i<0 || i>=size) return null;
        return data[i+front-1];
    }

}