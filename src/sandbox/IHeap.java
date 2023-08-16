package sandbox;

public interface IHeap<T extends Comparable<T>> {
    void insert(T data);
    T removeRoot();
    void sort();
}
