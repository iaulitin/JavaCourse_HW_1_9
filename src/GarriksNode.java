import java.util.Iterator;

public class GarriksNode<K, E> {
    private E item;
    private K key;
    private GarriksNode<K, E> next;
    private GarriksNode<K, E> prev;

    public GarriksNode(E item, GarriksNode<K, E> next, GarriksNode<K, E> prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }

    public GarriksNode(E item, K key, GarriksNode<K, E> next, GarriksNode<K, E> prev) {
        this.item = item;
        this.key = key;
        this.next = next;
        this.prev = prev;
    }

    public GarriksNode<K, E> getNext() {
        return next;
    }

    public void setNext(GarriksNode<K, E> newNext) {
        next = newNext;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E newItem) {
        item = newItem;
    }

    public GarriksNode<K, E> getPrev() {
        return prev;
    }

    public void setPrev(GarriksNode<K, E> prev) {
        this.prev = prev;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public String toString() {
        return (String) item;
    }

}
