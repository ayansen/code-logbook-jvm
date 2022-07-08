package algorithm.mathematicaloptimizations.lists;

import java.util.Objects;

public class Pair<U, V> {

    /**
     * The first element of this <code>Pair</code>
     */
    private U key;

    /**
     * The second element of this <code>Pair</code>
     */
    private V value;

    /**
     * Constructs a new <code>Pair</code> with the given values.
     *
     * @param key  the key
     * @param value the value
     */
    public Pair(U key, V value) {

        this.key = key;
        this.value = value;
    }

    public U getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}

