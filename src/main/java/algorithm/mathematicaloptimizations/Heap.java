package algorithm.mathematicaloptimizations;

/**
 * Created by aysen on 10/28/16.
 */
public interface Heap<T> {
    public void insert(T key);

    public T getHead();

    public T ExtactHead();

    public int size();


}
