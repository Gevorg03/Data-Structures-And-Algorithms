package SinglyLinkedList;

import java.util.Stack;

public class SinglyLinkedList<T> implements MyLinkedList<T> {
    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void insert(T data, int pos) {
        if (pos < 0 || pos > size) {
            System.out.println("You entered a wrong index");
        } else if (pos == 0) {
            head = new Node<T>(data, head);
            ++size;
        } else {
            Node<T> tmp = head;
            for (int i = 0; i < pos - 1; ++i) {
                tmp = tmp.next;
            }
            tmp.next = new Node<T>(data, tmp.next);
            ++size;
        }
    }

    @Override
    public void delete(int pos) {
        if (pos < 0 || pos > size) {
            System.out.println("You entered a wrong index");
        } else if (pos == 0) {
            assert !isEmpty();
            head = head.next;
            --size;
        } else {
            Node<T> tmp = head;
            for (int i = 0; i < pos - 1; ++i) {
                tmp = tmp.next;
            }
            tmp.next = tmp.next.next;
            --size;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            delete(0);
        }
    }

    @Override
    public void print() {
        Node<T> tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    public int find(T val) {
        Node<T> tmp = head;
        for (int i = 0; i < size; ++i){
            if (tmp.data == val){
                return i;
            }
            tmp = tmp.next;
        }
        return -1;
    }

    public T getVal(int pos) {
        Node<T> tmp = head;
        for (int i = 0; i < pos; ++i) {
            tmp = tmp.next;
        }
        return tmp.data;
    }
}
