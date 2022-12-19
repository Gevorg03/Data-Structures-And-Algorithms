package Queue;

public class LQueue<T> implements MyQueue<T> {
    private static class Node<T> {
        Node<T> next;
        T data;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public LQueue() {
        front = null;// a pointer to the first link node
        rear = null;// a pointer to the last link node
        size = 0;
    }

    @Override
    public void enqueue(T data) {
        if (rear == null) {
            front = rear = new Node<T>(data, null); // if queue is empty
        } else {
            rear.next = new Node<T>(data, null);
            rear = rear.next;
        }
        ++size;
    }

    @Override
    public void dequeue() {
        if (!empty()) {
            front = front.next;
        }
        --size;
    }

    @Override
    public T front() {
        assert !empty();
        return front.data;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public void clear() {
        while (!empty()) {
            dequeue();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        Node<T> curr = front;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
