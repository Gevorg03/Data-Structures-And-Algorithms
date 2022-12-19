package Tree;

public interface MyTree<T extends Comparable<T>> {
    void preorder();

    void inorder();

    void postorder();

    void preorderIter();

    void inorderIter();

    void postorderIter();

    void levelorder();

    int width();

    int height();

    int countOfLeaves();

    int countOfNodes();

    void clear();

    int countOfInternalNodes();
}
