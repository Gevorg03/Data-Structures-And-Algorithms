package Stack;

public class ArrStack<T> implements MyStack<T> {

    private T[] arr;
    int size;
    int topIndex;

    public ArrStack(T[] arr) {
        size = arr.length;
        this.arr = arr;
        topIndex = 0;
    }

    @Override
    public void push(T data) {
        if (topIndex >= size) {
            System.out.println("The stack is full");
            return;
        }
        arr[topIndex++] = data;
    }

    @Override
    public void pop() {
        if (!empty()) {
            size--;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public T top() {
        assert !empty();
        return arr[topIndex - 1];
    }

    @Override
    public void clear() {
        while (!empty()) {
            pop();
        }

        topIndex = 0;
    }

    @Override
    public void print() {
        for (int i = topIndex - 1; i >= 0; --i) {
            System.out.print(arr[i] + " ");
        }
    }
}
