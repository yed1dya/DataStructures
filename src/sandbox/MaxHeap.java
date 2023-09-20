package sandbox;

public class MaxHeap<T extends Comparable<T>> extends Heap<T> {
    public static void main(String[] args) {
        MaxHeap<Integer> h = new MaxHeap<>();
        h.insert(4);
        h.insert(3);
        h.insert(44);
        h.insert(23);
        System.out.println(h.isMaxHeap());
    }
    protected void fixUp(){
        int index = position, parent = parent(index);
        while(parent>=0 && heap[index].compareTo(heap[parent])>0){
            swap(index, parent);
            index = parent;
            parent = parent(index);
        }
    }

    @Override
    protected void fixDown(int end) {
        if(end==-1) return;
        int index = 0;
        while (index<=end){
            int left = left(index), right = right(index);
            if(left>end) break;
            int child = right>end ? left : heap[left].compareTo(heap[right])>0 ? left : right;
            if(heap[index].compareTo(heap[child])>0) break;
            swap(index, child);
            index = child;
        }
    }

    @Override
    public T removeRoot() {
        if(isEmpty()) return null;
        T ans = heap[0];
        heap[0] = heap[position--];
        heap[position+1] = null;
        return ans;
    }

    public boolean isMaxHeap(){
        for(int i=0; i<parent(heap.length-1); i++){
            T c = heap[i], left = heap[left(i)], right = heap[right(i)];
            if(c.compareTo(left)<0 || c.compareTo(right)<0) return false;
        }
        return true;
    }
}
