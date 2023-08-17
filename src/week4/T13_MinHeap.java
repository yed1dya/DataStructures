package week4;

public class T13_MinHeap {
    private int[] heap;
    private int size;
    public T13_MinHeap(int[] arr){
        heap = new int[arr.length];
        System.arraycopy(arr, 0, heap, 0, arr.length);
    }
    private int parent(int i){
        return (i-1)/2;
    }
    private int left(int i){
        return i*2+1;
    }
    private int right(int i){
        return i*2+2;
    }
    private int lastParent(int[] arr){
        return arr.length/2-1;
    }
    private void minHeapify(int[] arr, int p, int size){
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
        int size = arr.length;
        for(int i=0; i<lastParent(arr); i++){
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
    private void swap(int[] arr, int x, int y){
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
        resize();
        size++;
        heap[size-1] = Integer.MAX_VALUE;
        decreaseKey(heap, size-1, k);
    }
    private void resize(){
        System.arraycopy(heap, 0, new int[size*2], 0, size);
    }
}
