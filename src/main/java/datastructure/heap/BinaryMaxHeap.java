package datastructure.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aysen on 10/25/16.
 */
public class BinaryMaxHeap<T extends Comparable> implements Heap<T> {

    List<T> heap;


    public BinaryMaxHeap() {
        heap = new ArrayList<T>();
        heap.add(null);
    }


    public void insert(T key) {
        heap.add(key);
        heapUp(heap.size() - 1);
    }

    public T getHead() {
        return heap.get(1);
    }

    public T ExtactHead() {
        T max = heap.get(1);
        int lastIndex = heap.size() - 1;
        heap.set(1, heap.get(lastIndex));
        heap.remove(lastIndex);
        heapDown(1);
        return max;
    }

    @Override
    public int size() {
        return heap.size();
    }


    private void heapDown(int index) {
        if (!isLeafIndex(index)) {
            int biggerChild = getIndexOfBiggerChild(index);

            if (heap.get(index).compareTo(heap.get(biggerChild)) < 0) {
                swapIndices(index, biggerChild);
                heapDown(biggerChild);
            }
        }

    }

    private void swapIndices(int firstIndex, int secondIndex) {
        T firstValue = heap.get(firstIndex);
        heap.set(firstIndex, heap.get(secondIndex));
        heap.set(secondIndex, firstValue);
    }

    private int getIndexOfBiggerChild(int i) {

        if (hasOneChild(i)) {
            return i * 2;
        }
        T firstChild = heap.get(i * 2);
        T secondChild = heap.get(i * 2 + 1);
        if (firstChild.compareTo(secondChild) >= 0) {
            return i * 2;
        } else {
            return i * 2 + 1;
        }
    }

    private boolean hasOneChild(int i) {
        return i * 2 == (heap.size() - 1);
    }


    private boolean isLeafIndex(int index) {
        return index * 2 > (heap.size() - 1);
    }


    private void heapUp(int index) {
        int parentIndex = index / 2;
        if (index != 1 && heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
            swapIndices(parentIndex, index);
            heapUp(parentIndex);
        }
    }
}
