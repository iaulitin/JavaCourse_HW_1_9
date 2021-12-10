import java.util.Iterator;

public class GarriksLinkedList<T, E> implements LinkedListInterface<E>, Iterable<GarriksNode<T, E>> {


    protected final GarriksNode<T, E> head;
    protected final GarriksNode<T, E> tail;
    protected int len;

    public GarriksLinkedList() {
        this.head = new GarriksNode<>(null, null, null);
        this.tail = new GarriksNode<>(null, null, head);
        this.head.setNext(this.tail);
        this.len = 0;
    }

    public GarriksNode<T, E> getHead() {
        return head;
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
    public boolean contains(Object o) {

        if (isEmpty()) {
            return false;
        }

        GarriksNode<T, E> currNode = head.getNext();

        if (currNode.getItem().getClass() != o.getClass()) {
            return false;
        }

        while (currNode.getItem() != null && !currNode.getItem().equals(o)) {
            currNode = currNode.getNext();
        }
        return currNode.getItem() != null && currNode.getItem().equals(o);
    }

    @Override
    public boolean add(E o) {
        GarriksNode<T, E> prevNode = tail.getPrev();
        GarriksNode<T, E> newNode = new GarriksNode<>(o, tail, prevNode);
        prevNode.setNext(newNode);
        tail.setPrev(newNode);
        len++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        GarriksNode<T, E> currNode = index == 0 ? head : getNode(index - 1);
        GarriksNode<T, E> nextNode = currNode.getNext();
        GarriksNode<T, E> newNode = new GarriksNode<>(element, nextNode, currNode);
        currNode.setNext(newNode);
        nextNode.setPrev(newNode);
        len++;
    }


    @Override
    public E get(int index) {
        return getNode(index).getItem();
    }


    @Override
    public int indexOf(Object o) {
        GarriksNode<T, E> currNode = head;
        for (int i = 0; i < len; i++) {
            currNode = currNode.getNext();
            if (o.equals(currNode.getItem())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E set(int index, E element) {
        getNode(index).setItem(element);
        return element;
    }

    @Override
    public E remove(int index) {
        GarriksNode<T, E> currItem = getNode(index);
        GarriksNode<T, E> prevItem = currItem.getPrev();
        GarriksNode<T, E> nextItem = currItem.getNext();
        prevItem.setNext(nextItem);
        nextItem.setPrev(prevItem);
        len--;
        return currItem.getItem();
    }

    @Override
    public boolean remove(Object o) {
        GarriksNode<T, E> currItem = getNode(o);
        if (currItem.equals(tail) || currItem.equals(head)) {
            return false;
        }
        GarriksNode<T, E> prevItem = currItem.getPrev();
        GarriksNode<T, E> nextItem = currItem.getNext();
        prevItem.setNext(nextItem);
        nextItem.setPrev(prevItem);
        len--;
        return true;
    }

    @Override
    public void clear() {
        head.setNext(tail);
        tail.setPrev(head);
        len = 0;
    }

    public Iterator<GarriksNode<T, E>> iterator() {
        return new GarriksLinkedListIterator<>(this);
    }

    protected GarriksNode<T, E> getNode(int index) {
        if (index >= len || index < 0) {
            throw new IndexOutOfBoundsException(String.format("Attempt to get the index %d, in range 0..%d", index, len));
        }
        GarriksNode<T, E> currNode = head;
        for (int i = 0; i < index + 1; i++) {
            currNode = currNode.getNext();
        }
        return currNode;
    }

    protected GarriksNode<T, E> getNode(Object o) {
        GarriksNode<T, E> currNode = head;
        for (int i = 0; i < len; i++) {
            if (currNode.getItem().equals(o)) {
                return currNode;
            }
            currNode = currNode.getNext();
        }
        return currNode;
    }



    @Override
    public String toString() {
        GarriksNode<T, E> currElem = head;
        StringBuilder result = new StringBuilder("head <-> ");
        for (int i = 0; i < len; i++) {
            currElem = currElem.getNext();
            result.append(currElem.getItem()).append(" <-> ");
        }
        result.append("tail");

        return result.toString();
    }

}
