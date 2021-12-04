import java.util.Collection;

public class GarriksHashMap<K, V> implements HashMapInterface<K, V> {
    private GarriksLinkedList<K, V>[] array;
    private int capacity;
    private double loadFactor;

    public GarriksHashMap() {
        this.array = new GarriksLinkedList[16];
        this.capacity = 16;
        this.loadFactor = 0.75;
    }

    @Override
    public int size() {
        int size = 0;
        for (GarriksLinkedList list : array) {
            if (list != null) {
                size += list.size();
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
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

    // хз как делать
    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public V put(K key, V value) {
        checkSize();
        int bucket = getBucketNum(key);
        createBucket(bucket);
        array[bucket].addMap(key, value);
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
        return result;
    }

    @Override
    public void clear() {
        array = new GarriksLinkedList[16];
        capacity = 16;
        loadFactor = 0.75;
    }

    private int getBucketNum(Object key) {
        return Math.abs(key.hashCode() % capacity);
    }

    private void checkSize() {
        if (size() > loadFactor * capacity) {
            capacity *= 2;
            replacementArray();
        }
        if (size() > 13 && capacity > size() * loadFactor / 2) {
            capacity /= 2;
            replacementArray();
        }


    }

    private void replacementArray() {
        GarriksLinkedList<K, V>[] newArray = new GarriksLinkedList[capacity];
        for (GarriksLinkedList<K, V> bucket : array) {
            if (bucket != null) {
                for (GarriksNode<K, V> node : bucket) {
                    if (newArray[getBucketNum(node.getKey())] == null) {
                        newArray[getBucketNum(node.getKey())] = new GarriksLinkedList<>();
                    }
                    newArray[getBucketNum(node.getKey())].addMap(node.getKey(), node.getItem());
                }
            }
        }
        array = newArray;
    }

    private void createBucket(int index) {
        if (array[index] == null) {
            array[index] = new GarriksLinkedList<>();
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (GarriksLinkedList<K, V> bucket : array) {
            result = result + bucket + "\n";
        }
        return result;
    }
}
