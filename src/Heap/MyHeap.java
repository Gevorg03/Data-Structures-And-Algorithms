package Heap;

public interface MyHeap<T extends Comparable<T> > {
    void insert(T data);

    void remove();

    T get();

    boolean empty();

    void print();
}
