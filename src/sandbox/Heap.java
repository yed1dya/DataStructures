package sandbox;
import java.util.Arrays;

public abstract class Heap<T extends Comparable<T>> implements IHeap<T> {
    protected T[] heap;
    protected int position = -1;
    public Heap(){
        heap = (T[]) new Comparable[2];
    }
    @Override
    public void insert(T data){
        if(full()) resize(heap.length * 2);
        heap[++position] = data;
        fixUp();
    }
    public void sort(){
        for(int i=0; i<=position; i++){
            swap(0, position);
            fixDown(position-1);
        }
        Arrays.stream(heap).forEach(System.out::println);
    }
    protected abstract void fixUp();
    protected abstract void fixDown(int end);
    protected void swap(int x, int y){
        T t = heap[x];
        heap[x] = heap[y];
        heap[y] = t;
    }
    private boolean full(){
        return position==heap.length-1;
    }
    private void resize(int size){
        System.arraycopy(heap, 0, heap = (T[]) new Comparable[size], 0, size+1);
    }
    protected int parent(int i){ return (i-1)/2; }
    protected int left(int i){ return i*2+1; }
    protected int right(int i){ return i*2+2; }
    protected boolean isEmpty(){ return heap.length==0; }
}
