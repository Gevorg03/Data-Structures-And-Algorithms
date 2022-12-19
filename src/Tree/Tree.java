package Tree;

import java.util.*;

public class Tree<T extends Comparable<T>> implements MyTree<T> {
    protected Node<T> root;

    public Tree(Node<T> root) {
        this.root = root;
    }

    public Tree() {
    }


    @Override
    public void preorder() {
        preOrderHelper(root);
    }

    @Override
    public void inorder() {
        inOrderHelper(root);
    }

    @Override
    public void postorder() {
        postOrderHelper(root);
    }

    @Override
    public void preorderIter() {
//        Stack<Node<T>> nodeStack = new Stack<Node<T>>();
//        Node<T> ptr = root;

//        while (true) {
//            while (ptr != null) {
//                System.out.print(ptr.data + " ");
//                if (ptr.right != null) {
//                    nodeStack.push(ptr.right);
//                }
//                ptr = ptr.left;
//            }
//
//            if (nodeStack.empty())
//                return;
//
//            ptr = nodeStack.peek();
//            nodeStack.pop();
//        }

        if (root == null)
            return;

        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            Node<T> ptr = stack.pop();
            System.out.print(ptr.data + " ");

            if (ptr.right != null) {
                stack.push(ptr.right);
            }

            if (ptr.left != null) {
                stack.push(ptr.left);
            }
        }
    }

    @Override
    public void inorderIter() {
        Stack<Node<T>> nodeStack = new Stack<>();
        Node<T> ptr = root;

        while (true) {
            while (ptr != null) {
                nodeStack.push(ptr);
                ptr = ptr.left;
            }

            if (nodeStack.empty())
                return;

            ptr = nodeStack.peek();
            nodeStack.pop();
            System.out.print(ptr.data + " ");
            ptr = ptr.right;
        }
    }

    @Override
    public void postorderIter() {
        Stack<Node<T>> nodeStack = new Stack<>();
        Node<T> ptr = root;

        while (true) {
            while (ptr != null) {
                if (ptr.right != null) {
                    nodeStack.push(ptr.right);
                }
                nodeStack.push(ptr);
                ptr = ptr.left;
            }

            if (nodeStack.empty())
                return;

            ptr = nodeStack.peek();
            nodeStack.pop();

            if (ptr.right != null && !nodeStack.empty() && nodeStack.peek() == ptr.right) {
                nodeStack.pop();
                nodeStack.push(ptr);
                ptr = ptr.right;
            } else {
                System.out.print(ptr.data + " ");
                ptr = null;
            }
        }
    }

    @Override
    public void levelorder() {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> tmp = queue.remove();
            System.out.print(tmp.data + " ");

            if (tmp.left != null)
                queue.add(tmp.left);

            if (tmp.right != null)
                queue.add(tmp.right);
        }
    }

    @Override
    public int width() {
        int w = 1;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            if (count > w)
                w = count;
            for (int i = 0; i < count; ++i) {
                Node<T> tmp = queue.remove();
                if (tmp.left != null)
                    queue.add(tmp.left);
                if (tmp.right != null)
                    queue.add(tmp.right);
            }
        }
        return w;
    }

    @Override
    public int height() {
        return heightHelper(root) - 1;
    }

    @Override
    public int countOfLeaves() {
        return countOfLeavesHelper(root);
    }

    @Override
    public int countOfNodes() {
        return countOfNodesHelper(root);
    }

    @Override
    public void clear() {
        clearHelper(root);
        root = null;
    }

    private void preOrderHelper(Node<T> ptr) {
        if (ptr == null)
            return;
        System.out.print(ptr.data + " ");
        preOrderHelper(ptr.left);
        preOrderHelper(ptr.right);
    }

    private void inOrderHelper(Node<T> ptr) {
        if (ptr == null)
            return;
        inOrderHelper(ptr.left);
        System.out.print(ptr.data + " ");
        inOrderHelper(ptr.right);
    }

    private void postOrderHelper(Node<T> ptr) {
        if (ptr == null)
            return;
        postOrderHelper(ptr.left);
        postOrderHelper(ptr.right);
        System.out.print(ptr.data + " ");
    }

    private int countOfNodesHelper(Node<T> ptr) {
        if (ptr == null)
            return 0;
        return 1 + countOfNodesHelper(ptr.left) + countOfNodesHelper(ptr.right);
    }

    @Override
    public int countOfInternalNodes() {
        return countOfNodes() - countOfLeaves();
    }

    private int countOfLeavesHelper(Node<T> ptr) {
        if (ptr == null)
            return 0;
        if (ptr.left == null && ptr.right == null)
            return 1;
        return countOfLeavesHelper(ptr.left) + countOfLeavesHelper(ptr.right);
    }

    private int heightHelper(Node<T> ptr) {
        if (ptr == null)
            return 0;
        return 1 + Math.max(heightHelper(ptr.left), heightHelper(ptr.right));
    }

    private void clearHelper(Node<T> ptr) {
        if (ptr == null)
            return;
        clearHelper(ptr.left);
        clearHelper(ptr.right);
    }
}
