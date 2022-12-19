package Heap;

import java.util.Collections;
import java.util.Vector;

public class Heap<T extends Comparable<T>> implements MyHeap<T> {
    private Vector<T> m_data = new Vector<>();

    @Override
    public void insert(T data) {
        m_data.add(data);
        heapifyUp(m_data.size() - 1);
    }

    @Override
    public void remove() {
        assert !empty();
        m_data.set(0, m_data.lastElement());
        m_data.remove(m_data.lastElement());
        heapifyDown(0);
    }

    @Override
    public T get() {
        assert !empty();
        return m_data.firstElement();
    }

    @Override
    public boolean empty() {
        return m_data.isEmpty();
    }

    @Override
    public void print() {
        for (T el : m_data) {
            System.out.print(el + " ");
        }
    }

    private int leftIndex(int i) {
        final int index = 2 * i + 1;
        return index < m_data.size() ? index : -1;
    }

    private int rightIndex(int i) {
        final int index = 2 * i + 2;
        return index < m_data.size() ? index : -1;
    }

    private int parentIndex(int i) {
        return i != 0 ? (i - 1) / 2 : -1;
    }

    private void heapifyUp(int i) {
        if (i == -1)
            return;
        final int par = parentIndex(i);
        if (par == -1)
            return;
        if (m_data.get(i).compareTo(m_data.get(par)) > 0) {
            Collections.swap(m_data, m_data.indexOf(m_data.get(i)), m_data.indexOf(m_data.get(par)));
            heapifyUp(par);
        }
    }

    private void heapifyDown(int i) {
        if (i == -1)
            return;
        int maxChildIndex = leftIndex(i);

        if (maxChildIndex == -1)
            return;
        final int rIndex = rightIndex(i);
        if (rIndex != -1 && m_data.get(rIndex).compareTo(m_data.get(maxChildIndex)) > 0) {
            maxChildIndex = rIndex;
        }
        if (m_data.get(i).compareTo(m_data.get(maxChildIndex)) < 0) {
            Collections.swap(m_data, m_data.indexOf(m_data.get(i)), m_data.indexOf(m_data.get(maxChildIndex)));
            heapifyDown(maxChildIndex);
        }
    }
}
