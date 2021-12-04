import java.util.Iterator;

public class GarriksLinkedList<T, E> implements LinkedListInterface<E>, Iterable<GarriksNode<T, E>> {


    private final GarriksNode<T, E> head;
    private final GarriksNode<T, E> tail;
    private int len;

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
//        Возможно ли каким-либо образом подобное реализовать?
//        if (o.getClass() != E) {
//            return false;
//        }

        GarriksNode<T, E> currNode = head.getNext();
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

    // метод для добавления узла с ключом
    public void addMap(T key, E element) {
        for (GarriksNode<T, E> node : this) {
            if (node.getKey().equals(key)) {
                node.setItem(element);
                node.setKey(key);
                return;
            }
        }
        GarriksNode<T, E> prevNode = tail.getPrev();
        GarriksNode<T, E> newNode = new GarriksNode<>(element, key, tail, prevNode);
        prevNode.setNext(newNode);
        tail.setPrev(newNode);
        len++;
    }

    @Override
    public E get(int index) {
        return getNode(index).getItem();
    }

    // получение элемента по ключу
    public E getByKey(Object key) {
        for (GarriksNode<T, E> node : this) {
            if (node.getKey().equals(key)) {
                return node.getItem();
            }
        }
        return null;
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
        GarriksNode<T, E> currItem = getNode(indexOf(o));
        GarriksNode<T, E> prevItem = currItem.getPrev();
        GarriksNode<T, E> nextItem = currItem.getNext();
        prevItem.setNext(nextItem);
        nextItem.setPrev(prevItem);
        len--;
        return true;
    }

    @Override
    public void clear() {
        // я же правильно понимаю, что при отсутствии ссылок на объекты (в данном случае ссылок на узлы) эти объекты удаляются из памяти, поэтому можно просто создань новые голову и хвост
        head.setNext(tail);
        tail.setPrev(head);
        len = 0;
    }

    public Iterator<GarriksNode<T, E>> iterator() {
        return new GarriksLinkedListIterator<>(this);
    }

    private GarriksNode<T, E> getNode(int index) {
        if (index >= len || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        GarriksNode<T, E> currNode = head;
        for (int i = 0; i < index + 1; i++) {
            currNode = currNode.getNext();
        }
        return currNode;
    }

    public T getKey(int index) {
        return getNode(index).getKey();
    }

    @Override
    public String toString() {
        GarriksNode<T, E> currElem = head;
        String result = "head -> ";
        for (int i = 0; i < len; i++) {
            currElem = currElem.getNext();
            result = new String(result + currElem.getItem() + " -> ");
        }
        result = new String(result + "tail");
        return result;
    }

}
