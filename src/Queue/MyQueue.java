package Queue;

public interface MyQueue<T> {
    void enqueue(T data);

    void dequeue();

    T front();

    boolean empty();

    void clear();

    int size();

    void print();

}
