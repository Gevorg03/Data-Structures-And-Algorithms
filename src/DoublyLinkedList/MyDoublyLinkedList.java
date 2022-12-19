package DoublyLinkedList;

public interface MyDoublyLinkedList<T> {
    void insert(int pos, T data);

    void delete(int pos);

    T getVal(int pos);

    int find(T val);

    boolean isEmpty();

    void clear();

    int size();

    void print();
}
