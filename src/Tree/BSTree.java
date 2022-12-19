package Tree;

public class BSTree<T extends Comparable<T>> extends Tree<T> {
    public BSTree() {

    }

    public void insert(T data) {
        this.root = insertHelper(this.root, data);
    }

    private Node<T> insertHelper(Node<T> ptr, T data) {
        if (ptr == null)
            ptr = new Node<T>(data);
        else if (data.compareTo(ptr.data) > 0)
            ptr.right = insertHelper(ptr.right, data);
        else if (data.compareTo(ptr.data) < 0)
            ptr.left = insertHelper(ptr.left, data);
        return ptr;
    }

    public void insertIter(T data) {
        if (this.root == null) {
            this.root = new Node<T>(data);
            return;
        }
        Node<T> ptr = this.root;
        Node<T> parent = null;

        while (ptr != null) {
            parent = ptr;
            if (data.compareTo(ptr.data) > 0)
                ptr = ptr.right;
            else if (data.compareTo(ptr.data) < 0)
                ptr = ptr.left;
            else
                System.out.println(data + " The value is already present on the tree");
        }

        if (data.compareTo(parent.data) > 0)
            parent.right = new Node<T>(data);
        else
            parent.left = new Node<T>(data);
    }

    public boolean contains(T data) {
        return find(this.root, data) != null;
    }

    private Node<T> find(Node<T> ptr, T data) {
        if (ptr == null)
            return null;

        if (data.compareTo(ptr.data) < 0)
            return find(ptr.left, data);
        else if (data.compareTo(ptr.data) > 0) {
            return find(ptr.right, data);
        }
        return ptr;
    }

    public T findMin() {
        return findMinNode(this.root).data;
    }

    private Node<T> findMinNode(Node<T> ptr) {
        if (ptr == null)
            return null;
        if (ptr.left == null)
            return ptr;
        return findMinNode(ptr.left);
    }

    public void deleteVal(T data) {
        this.root = deleteValHelper(this.root, data);
    }

    private Node<T> deleteValHelper(Node<T> ptr, T data) {
        if (ptr == null)
            return null;

        if (data.compareTo(ptr.data) < 0) {
            ptr.left = deleteValHelper(ptr.left, data);
        } else if (data.compareTo(ptr.data) > 0) {
            ptr.right = deleteValHelper(ptr.right, data);
        } else {
            if (ptr.left == null && ptr.right == null)
                return null;
            if (ptr.left == null)
                return ptr.right;
            if (ptr.right == null)
                return ptr.left;
            Node<T> minP = findMinNode(ptr.right);
            ptr.data = minP.data;
            ptr.right = deleteValHelper(ptr.right, minP.data);
        }
        return ptr;
    }
}
