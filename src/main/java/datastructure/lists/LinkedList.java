package datastructure.lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by aysen on 9/30/16.
 */
public class LinkedList<T> implements List<T> {

    Node<T> head;

    @Override
    public int size() {
        int size = 0;
        Node node = head;
        while (node != null) {
            size = size + 1;
            node = node.next;
        }
        return size;
    }



    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        Node node = head;
        while (node != null) {
            if (node.equals(o)) {
                return true;
            }
            node = node.next;
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return head;
    }

    @Override
    public Object[] toArray() {
        int size = this.size();
        Object[] array = new Object[size];
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            array[i] = node.data;
            node = node.next;
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node<>(t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node node = head;
        while (node != null) {
            if (node.next.data.equals(o)) {
                node.next = node.next.next;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {


        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }


    private class Node<T> implements Iterator<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            return next.data;
        }
    }
}
