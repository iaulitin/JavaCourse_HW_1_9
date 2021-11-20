public interface LinkedListInterface<E> {

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    boolean add(E e);

    void add(int index, E element);

    E get(int index);

    int indexOf(Object o);

    E set(int index, E element);

    E remove(int index);

    boolean remove(Object o);

    void clear();

}
