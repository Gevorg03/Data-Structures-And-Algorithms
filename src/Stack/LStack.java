package Stack;

import java.util.Stack;

public class LStack<T> implements MyStack<T> {

    private static class Node<T> {
        Node<T> next;
        T data;
        Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> top;
    private int size;

    public LStack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(T data) {
        top = new Node<T>(data, top);
        ++size;
    }

    @Override
    public void pop() {
        if (!empty()){
            top = top.next;
            --size;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size==0;
    }

    @Override
    public T top() {
        assert !empty();
        return (T) top.data;
    }

    @Override
    public void clear() {
        while (!empty()){
            pop();
        }
    }

    @Override
    public void print() {
        while (size > 0) {
            System.out.print(top.data + " ");
            --size;
            top = top.next;
        }
    }
}
