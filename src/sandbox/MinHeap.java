package sandbox;

public class MinHeap <T extends Comparable<T>> extends Heap<T> {
    @Override
    protected void fixUp() {
        int index = position, parent = parent(index);
        while(parent>=0 && heap[index].compareTo(heap[parent])<0){
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
            int child = right>end ? left : heap[left].compareTo(heap[right])<0 ? left : right;
            if(heap[index].compareTo(heap[child])<0) break;
            swap(index, child);
            index = child;
        }
    }
    @Override
    public T removeRoot() {
        return null;
    }
}
