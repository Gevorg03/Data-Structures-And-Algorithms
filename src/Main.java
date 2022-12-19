import DoublyLinkedList.DoublyLinkedList;
import Heap.Heap;
import Stack.ArrStack;
import Tree.Tree;
import Tree.Node;
import Tree.BSTree;

public class Main {
    public static void main(String[] args) {
//        Integer[] arr = new Integer[5];
//        ArrStack<Integer> arrStack = new ArrStack<>(arr);
//        arrStack.push(5);
//        arrStack.push(8);
//        arrStack.push(-1);
//        System.out.println("The stack size is " + arrStack.size());
//        arrStack.pop();
//        System.out.println("Is the stack empty: " + arrStack.empty());
//        arrStack.clear();

//        LStack<Integer> st = new LStack<>();
//        st.push(5);
//        st.push(7);
//        st.push(9);
//        st.pop();
//        System.out.println(st.top());
//        System.out.println(st.empty());
//        st.print();

//        Integer[] arr = new Integer[8];
//        ArrQueue<Integer> arrQueue = new ArrQueue<>(arr);
//        arrQueue.enqueue(5);
//        arrQueue.enqueue(8);
//        arrQueue.enqueue(-1);
//        System.out.println("The stack size is " + arrQueue.size());
//        arrQueue.dequeue();
//        System.out.println("Is the stack empty: " + arrQueue.empty());
//        arrQueue.clear();

//        LQueue<Integer> lQueue = new LQueue<>();
//        lQueue.enqueue(5);
//        lQueue.enqueue(10);
//        lQueue.enqueue(-1);
//        System.out.print("The elements are ");
//        lQueue.print();
//        System.out.println("\nThe front is " + lQueue.front());
//        lQueue.dequeue();
//        System.out.println("The current size is " + lQueue.size());
//        System.out.print("The elements are ");
//        lQueue.print();

//        LinkedList<Integer> lst = new LinkedList<>();
//        lst.insert(3, 0);
//        lst.insert(7, 1);
//        lst.insert(6, 2);
//        lst.insert(4, 2);
//        System.out.println("The size is " + lst.size());
//        lst.insert(5, 3);
//        lst.print();
//        lst.clear();
//        System.out.println("\nIs the list empty: " + lst.isEmpty());

//        DoublyLinkedList<Integer> lst = new DoublyLinkedList<Integer>();
//        lst.insert(0, 1);
//        lst.insert(1, 3);
//        lst.insert(2, 4);
//        lst.insert(1, 2);
//        lst.print();
//        int pos = lst.find(1);
//        System.out.println("\nThe position of 1 is: " + pos);
//        System.out.println("The element at index " + pos + " is: " + lst.getVal(pos));
//        lst.delete(0);
//        lst.print();
//        System.out.println("\nThe second element is " + lst.getVal(1));
//        System.out.println("The position of 4 is " + lst.find(4));
//        System.out.println("\nempty = " + lst.isEmpty());
//        lst.clear();
//        System.out.println("empty = " + lst.isEmpty());

//        Node<Character> j = new Node<Character>('j');
//        Node<Character> i = new Node<Character>('i');
//        Node<Character> g = new Node<Character>('g', j, i);
//        Node<Character> h = new Node<Character>('h');
//        Node<Character> d = new Node<Character>('d', g, h);
//        Node<Character> b = new Node<Character>('b', null, d);
//
//        Node<Character> e = new Node<Character>('e');
//        Node<Character> f = new Node<Character>('f');
//        Node<Character> c = new Node<Character>('c', e, f);
//
//        Node<Character> a = new Node<Character>('a', b, c);
//
//        Tree<Character> tree = new Tree<Character>(a);
//
//        System.out.print("Preorder: ");
//        tree.preorder();
//
//        System.out.print("\nPreorder Iterative: ");
//        tree.preorderIter();
//
//        System.out.print("\nInorder: ");
//        tree.inorder();
//
//        System.out.print("\nInorder Iterative : ");
//        tree.inorderIter();
//
//        System.out.print("\nPostorder: ");
//        tree.postorder();
//
//        System.out.print("\nPostorder Iterative : ");
//        tree.postorderIter();
//
//        System.out.print("\nLevelorder : ");
//        tree.levelorder();
//
//        System.out.print("\nWidth : " + tree.width());
//
//        System.out.print("\nHeight : " + tree.height());
//
//        System.out.print("\ncountOfNodes : " + tree.countOfNodes());
//
//        System.out.print("\ncountOfLeaves : " + tree.countOfLeaves());
//
//        System.out.print("\ncountOfInternalNodes : " + tree.countOfInternalNodes());
//
//        tree.clear();
//
//        System.out.print("\nPostorder: ");
//        tree.postorder();

        Heap<Integer> heap = new Heap<Integer>();
        heap.insert(10);
        heap.insert(7);
        heap.insert(14);
        heap.insert(55);
        heap.insert(9);
        heap.insert(1);
        heap.insert(3);

        System.out.println(heap.get());

        heap.remove();

        System.out.println(heap.get());

        heap.print();

        System.out.println("\nheap sort...");
        while (!heap.empty()) {
            System.out.print(heap.get() + " ");
            heap.remove();
        }
    }
}
