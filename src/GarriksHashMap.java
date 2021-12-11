import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GarriksHashMap<K, V> implements HashMapInterface<K, V> {
    private final int MINIMAL_LEN_CAUSING_REPLACEMENT = 13;
    private final int DEFAULT_CAPACITY = 16;
    private final double DEFAULT_LOAD_FACTOR = 0.75;
    private GarriksCoolerLinkedList<K, V>[] array;
    private int capacity;
    private double loadFactor;
    private int len;

    public GarriksHashMap() {
        createNewHashMap();
    }

    @Override
    public int size() {
        return len;
    }

    @Override
    public boolean isEmpty() {
        return len == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int bucket = getBucketNum(key);
        if (array[bucket] != null) {
            for (GarriksNode<K, V> node : array[bucket]) {
                if (node.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public boolean containsValue(Object value) {
        for (GarriksLinkedList<K, V> bucket : array) {
            if (bucket != null) {
                for (GarriksNode<K, V> node : bucket) {
                    if (node.getItem().equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public Collection<V> values() {
        List<V> result = new ArrayList<>();
        for (GarriksLinkedList<K, V> bucket : array) {
            if (bucket != null) {
                for (GarriksNode<K, V> node : bucket) {
                    result.add(node.getItem());
                }
            }
        }
        return result;
    }

    @Override
    public V put(K key, V value) {
        checkSize();
        int bucket = getBucketNum(key);
        createBucket(bucket);
        array[bucket].addMap(key, value);
        len++;
        return value;
    }

    @Override
    public V get(Object key) {
        int bucket = getBucketNum(key);
        return array[bucket].getByKey(key);
    }

    @Override
    public V remove(Object key) {
        checkSize();
        int bucket = getBucketNum(key);
        V result = array[bucket].getByKey(key);
        array[bucket].remove(result);
        if (array[bucket].size() == 0) {
            array[bucket] = null;
        }
        len--;
        return result;
    }

    @Override
    public void clear() {
        createNewHashMap();
    }

    private int getBucketNum(Object key) {
        return Math.abs(key.hashCode() % capacity);
    }

    private void checkSize() {
        if (len > loadFactor * capacity) {
            capacity *= 2;
            replacementArray();
        }
        if (len > MINIMAL_LEN_CAUSING_REPLACEMENT && capacity > len * loadFactor / 2) {
            capacity /= 2;
            replacementArray();
        }
    }

    private void replacementArray() {
        GarriksCoolerLinkedList<K, V>[] newArray = new GarriksCoolerLinkedList[capacity];
        for (GarriksCoolerLinkedList<K, V> bucket : array) {
            if (bucket == null) {
                continue;
            }
            for (GarriksNode<K, V> node : bucket) {
                if (newArray[getBucketNum(node.getKey())] == null) {
                    newArray[getBucketNum(node.getKey())] = new GarriksCoolerLinkedList<>();
                }
                int bucketIndex = getBucketNum(node.getKey());
                K currKey = node.getKey();
                V currItem = node.getItem();
                newArray[bucketIndex].addMap(currKey, currItem);
            }
        }
        array = newArray;
    }

    private void createBucket(int index) {
        if (array[index] == null) {
            array[index] = new GarriksCoolerLinkedList<>();
        }
    }

    private void createNewHashMap() {
        array = new GarriksCoolerLinkedList[16];
        capacity = DEFAULT_CAPACITY;
        loadFactor = DEFAULT_LOAD_FACTOR;
        len = 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (GarriksLinkedList<K, V> bucket : array) {
            result.append(bucket).append("\n");
        }
        return result.toString();
    }

}
