package week4;

public class IntHeap {
    int[] heap;
    int size;
    void minHeapify(int[] arr, int v, int size){
        int small, left = left(v), right = right(v);
        // set small to smallest child (or self)
        small = (right < size && arr[right] < arr[v]) ? right :
                (left<size && arr[left]<arr[v]) ? left : v;
        if(small!=v){
            swap(arr, v, small);
            minHeapify(arr, small, size);
        }
    }
    public void buildMinHeap(int[] arr){
        buildMinHeap(arr, arr.length);
    }
    private void buildMinHeap(int[] arr, int size){
        for(int i=(size/2)-1; i>=0; i--){
            minHeapify(arr, i, size);
        }
    }
    private void swap(int[] a, int x, int y){
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }
    public void heapSort(int[] a){
        buildMinHeap(a);
        int size = a.length;
        for(int i=size-1; i>=1; i--){
            swap(a, 0, i);
            size--;
            minHeapify(a, 0, size);
        }
    }
    protected void decreaseKey(int[] a, int i, int key){
        if(key>=a[i]) return;
        a[i] = key;
        while (i>0 && a[parent(i)]>a[i]){
            swap(a, i, parent(i));
            i = parent(i);
        }
    }
    public void insert(int key){
        if(size==heap.length){
            resize();
        }
        heap[size++] = Integer.MAX_VALUE;
        decreaseKey(heap, size-1, key);
    }

    private void resize() {
        System.arraycopy(heap, 0, new int[size*2], 0, size);
    }

    protected int parent(int i){ return (i-1)/2; }
    protected int left(int i){ return i*2+1; }
    protected int right(int i){ return i*2+2; }
    public int size(){
        return size;
    }
}
