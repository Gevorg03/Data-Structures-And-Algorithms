package Queue;

public class ArrQueue<T> implements MyQueue<T> {

    private T[] arr;
    private int front;
    private int rear;
    private int maxSize;

    public ArrQueue(T[] arr) {
        this.arr = arr;
        maxSize = arr.length + 1;
        front = 1;
        rear = 0;
    }

    @Override
    public void enqueue(T data) {
        assert !isFull();
        rear = (rear + 1) % maxSize;
        arr[rear] = data;
    }

    @Override
    public void dequeue() {
        assert !empty();
        front = (front + 1) % maxSize;
    }

    @Override
    public T front() {
        assert !empty();
        return arr[front];
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        rear = 0;
        front = 1;
    }

    @Override
    public int size() {
        return (rear - front + 1 + maxSize) % maxSize;
    }

    @Override
    public void print() {
        while (!empty()){
            System.out.print(front());
            dequeue();
        }
    }

    public boolean isFull() {
        return ((rear + 2) % maxSize) == front;
    }
}
