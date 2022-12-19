package SinglyLinkedList;

public interface MyLinkedList<T> {
    void insert(T data, int pos);

    void delete(int pos);

    boolean isEmpty();

    void clear();

    void print();

    int size();
}
