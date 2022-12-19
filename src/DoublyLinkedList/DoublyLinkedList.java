package DoublyLinkedList;

public class DoublyLinkedList<T> implements MyDoublyLinkedList<T> {
    private Node<T> head;
    private int size;

    public DoublyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void insert(int pos, T data) {
        assert isValidPosition(pos);
        if (pos == 0) {
            head = new Node<T>(data, head, null);
            if (head.next != null) {
                head.next.prev = head;
            }
        } else {
            Node<T> prev = runTo(pos - 1);
            Node<T> new_node = new Node<T>(data, prev.next, prev);
            prev.next = new_node;
            if (new_node.next != null){
                new_node.next.prev = new_node;
            }
        }
        ++size;
    }

    @Override
    public void delete(int pos) {
        assert isValidPosition(pos);
        assert !isEmpty();
        if (pos == 0) {
            if (head.next == null){
                head = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        } else {
            Node<T> tmp = runTo(pos);
            tmp.prev.next = tmp.next;
            if (tmp.next != null) {
                tmp.next.prev = tmp.prev;
            }
        }
        --size;
    }

    @Override
    public T getVal(int pos) {
        Node<T> tmp = runTo(pos);
        return tmp.data;
    }

    @Override
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
    public int size() {
        return size;
    }

    @Override
    public void print() {
        Node<T> tmp = head;
        while (tmp != null){
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
    }

    boolean isValidPosition(int pos) {
        return pos >= 0 && pos < size;
    }

    Node<T> runTo(int pos){
        assert isValidPosition(pos);
        Node<T> tmp = head;
        for (int i = 0; i < pos; ++i){
            tmp = tmp.next;
        }
        return tmp;
    }
}
