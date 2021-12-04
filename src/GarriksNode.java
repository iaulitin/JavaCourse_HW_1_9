import java.util.Iterator;

public class GarriksNode<T, E> {
    private E item;
    private T key;
    private GarriksNode<T, E> next;
    private GarriksNode<T, E> prev;

    public GarriksNode(E item, GarriksNode<T, E> next, GarriksNode<T, E> prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }

    public GarriksNode(E item, T key, GarriksNode<T, E> next, GarriksNode<T, E> prev) {
        this.item = item;
        this.key = key;
        this.next = next;
        this.prev = prev;
    }

    public GarriksNode<T, E> getNext() {
        return next;
    }

    public void setNext(GarriksNode<T, E> newNext) {
        next = newNext;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E newItem) {
        item = newItem;
    }

    public GarriksNode<T, E> getPrev() {
        return prev;
    }

    public void setPrev(GarriksNode<T, E> prev) {
        this.prev = prev;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public String toString() {
        return (String) item;
    }

}
