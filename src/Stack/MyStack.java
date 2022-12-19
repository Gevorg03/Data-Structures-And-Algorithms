package Stack;

public interface MyStack<T> {
    void push(T data);

    void pop();

    int size();

    boolean empty();

    T top();

    void clear();

    void print();
}
