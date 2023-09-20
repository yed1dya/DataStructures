package week5;

import java.util.Arrays;

public class MinHeap {
    public static void main(String[] args) {
        MinHeap h = new MinHeap();
        System.out.println(h.extractMin());
        int[] a = new int[]{2,4,6,0,1};
        System.out.println(isMinHeap(a));
        h = new MinHeap(a);
        h.print();
        h.insert(8);
        h.print();
        System.out.println(h.isMinHeap());
        System.out.println(h.find(1,2));
        h.delete(7);
        h.print();
        h.delete(1);
        h.print();
        System.out.println(Arrays.toString(a));
        System.out.println(h.heapMin());
        System.out.println(h.extractMin());
        System.out.println(Arrays.toString(a));
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    int[] heap;
    int size;

    public MinHeap(){
        heap = new int[0];
        size = 0;
    }
    public MinHeap(int[] input){
        if(input==null){
            size = 0;
            heap = new int[0];
        }
        else{
            size = input.length;
            heap = new int[size];
            System.arraycopy(input, 0, heap, 0, size);
            buildMinHeap(size);
        }
    }
    private static int parent(int i){ return (i-1)/2; }
    private static int left(int i){ return (i*2)+1; }
    private static int right(int i){ return (i*2)+2; }
    private int lastParent(){ return size/2-1; }
    private boolean isLeaf(int i){
        return i > (size / 2) && i < size;
    }
    private void swap(int a, int b){
        int t = heap[a];
        heap[a] = heap[b];
        heap[b] = t;
    }

    /**
     * fixes down from node:
     * @param v index of node
     */
    private void minHeapify(int v, int heapSize){
        // Base case: leaf
        if(isLeaf(v)) return;
        // Find the smallest from: node, left, right:
        int s = v, left = left(v), right = right(v);
        // Compare to left:
        if(left<heapSize && heap[left]<heap[v]){
            s = left;
        }
        // Compare s to right:
        if(right<heapSize && heap[right]<heap[s]){
            s = right;
        }
        // Swap and recursive call with smallest:
        if(s != v){
            swap(v, s);
            minHeapify(s, heapSize);
        }
    }

    /**
     * Fix given array into heap structure:
     * Call minHeapify from the last parent, working up
     * @param size of heap
     */
    private void buildMinHeap(int size){
        for(int i=size/2-1; i>=0; i--){
            minHeapify(i, size);
        }
    }

    /**
     * decrease value of node
     * @param i index
     * @param v new value
     */
    private void decreaseKey(int i, int v){
        // only decrease, not increase:
        if(v>heap[i]) return;
        // change value:
        heap[i] = v;
        // swap up:
        while (i>0 && heap[parent(i)]>v){
            swap(i, parent(i));
            i = parent(i);
        }
    }

    /**
     * insert new value:
     * @param v value to insert
     */
    public void insert(int v){
        // if array is full, resize:
        resize();
        // assign new value to last index:
        heap[size] = v;
        // call decreaseKey to swap up as needed:
        decreaseKey(size, v);
        // update heap size:
        size++;
    }
    private void resize(){
        if(size < heap.length-1) return;
        int[] newArr = new int[(size+1)*2];
        System.arraycopy(heap, 0, newArr, 0, size);
        heap = newArr;
    }
    public void print(){
        System.out.print("[");
        for(int i=0; i<size-1; i++){
            System.out.print(heap[i]+", ");
        }
        System.out.println(heap[size-1]+"]");
    }
    private boolean isMinHeap(){
        for(int i=0; i<lastParent(); i++){
            int c = heap[i], r = right(i), l = left(i);
            if((r<size && c>heap[r]) || (l<size && c>heap[l])) return false;
        }
        return true;
    }
    public static boolean isMinHeap(int[] a){
        if(a==null || a.length==0) return true;
        int size = a.length, b = size/2-1;
        for(int i=0; i<=b; i++){
            int c = a[i], r = right(i), l = left(i);
            if((r<size && c>a[r]) || (l<size && c>a[l])) return false;
        }
        return true;
    }

    /**
     * heap sort
     * O(n logn)
     * @param a array to sort
     */
    public static void heapSort(int[] a){
        // null, empty, or array of length 1 is sorted:
        if(a==null || a.length<2) return;
        int heapSize = a.length;
        // create new heap from array - O(n)
        // (constructor will fix it to heap)
        MinHeap t = new MinHeap(a);
        // O(n)
        for (int i=heapSize-1; i>=1; i--){
            // put the smallest element in last place:
            int temp = t.heap[0];
            t.heap[0] = t.heap[i];
            t.heap[i] = temp;
            // decrease size by 1
            heapSize--;
            // heapify - without the last place
            // O(logn)
            t.minHeapify(0, heapSize);
        }
        int len = a.length-1;
        for(int i=0; i<t.heap.length; i++){
            a[len-i] = t.heap[i];
        }
    }

    public int heapMin(){
        if(heap.length==0) return Integer.MAX_VALUE;
        return heap[0];
    }

    public int extractMin(){
        int ans = Integer.MAX_VALUE;
        if(heap.length>0){
            ans = heap[0];
            // put last node in root
            heap[0] = heap[--size];
            // swap down:
            minHeapify(0, size);
        }
        return ans;
    }

    public int find(int v, int i){
        if(heap.length==0 || i>=size || v<heap[i]) return -1;
        if(heap[i]==v) return i;
        return Math.max(find(v,left(i)), find(v,right(i)));
    }

    public void delete(int v){
        int i = find(v, 0);
        if(i<0) return;
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }
}
