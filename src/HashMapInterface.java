import java.util.Collection;

public interface HashMapInterface<K, V> {

    int size();

    boolean isEmpty();

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    Collection<V> values();

    V put(K key, V value);

    V get(Object key);

    V remove(Object key);

    void clear();

}
