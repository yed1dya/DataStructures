package week4;

import java.util.Arrays;

public class T13_MinHeap {
    public static void main(String[] args) {
        T13_MinHeap h = new T13_MinHeap(new int[]{2, 4, 6, 0, 1});
        System.out.println(Arrays.toString(h.heap));
        h.minHeapInsert(-1);
        System.out.println(Arrays.toString(h.heap));
        System.out.println(h.isMinHeap());
        h.buildMinHeap(h.heap);
        System.out.println(Arrays.toString(h.heap));
        System.out.println(h.isMinHeap());
        System.out.println(h.find(4));
        System.out.println(h.find(5));
    }
    private int[] heap;
    private int size;
    public T13_MinHeap(int[] arr){
        heap = new int[arr.length];
        System.arraycopy(arr, 0, heap, 0, arr.length);
        size = arr.length-1;
    }
    private int parent(int i){
        return (i-1)/2;
    }
    private static int left(int i){
        return i*2+1;
    }
    private static int right(int i){
        return i*2+2;
    }
    private static int lastParent(int[] arr){
        return arr.length/2-1;
    }
    private static void minHeapify(int[] arr, int p, int size){
        int left = left(p), right = right(p), small;
        if(left<size && arr[left]<arr[p]){
            small = left;
        }
        else{
            small = p;
        }
        if(right<size && arr[right]<arr[small]){
            small = right;
        }
        if(small != p){
            swap(arr, small, p);
            minHeapify(arr, small, size);
        }
    }
    public void buildMinHeap(int[] arr){
        int size = this.size;
        for(int i=0; i<lastParent(this.heap); i++){
            minHeapify(arr, i, size);
        }
    }
    public void heapSort(int[] arr){
        buildMinHeap(arr);
        int size = arr.length;
        for(int i=size-1; i>=1; i--){
            swap(arr, 0, i);
            minHeapify(arr, 0, --size);
        }
    }
    public int heapExtract(){
        int min = Integer.MAX_VALUE;
        if(heap.length>0){
            min = heap[0];
            heap[0] = heap[--size];
            minHeapify(heap, 0, size);
        }
        return min;
    }
    private static void swap(int[] arr, int x, int y){
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }
    private void decreaseKey(int[] arr, int i, int k){
        if(k < arr[i]){
            arr[i] = k;
            while (i>0 && arr[parent(i)]>arr[i]){
                swap(arr, i, parent(i));
                i = parent(i);
            }
        }
    }
    public void minHeapInsert(int k){
        if(size==heap.length) resize();
        size++;
        heap[size-1] = Integer.MAX_VALUE;
        decreaseKey(heap, size-1, k);
    }
    private void resize(){
        int[] newArr = new int[size*2];
        System.arraycopy(heap, 0, newArr, 0, size);
        heap = newArr;
    }
    public boolean isMinHeap(){
        for(int i=0; i<lastParent(heap); i++){
            int c = heap[i];
            if((left(i)<size && c>heap[left(i)]) || (right(i)<size && c>heap[right(i)])) return false;
        }
        return true;
    }
    // returns index of v
    public int find(int v){
        return find(v, 0);
    }
    private int find(int v, int place){
        if(place>=heap.length || heap[place]>v) return -1;
        if(heap[place]==v) return place;
        return Math.max(find(v,left(place)), find(v, right(place)));
    }
}
