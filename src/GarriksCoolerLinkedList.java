public class GarriksCoolerLinkedList<K, E> extends GarriksLinkedList<K, E> {

    public E getByKey(Object key) {
        for (GarriksNode<K, E> node : this) {
            if (node.getKey().equals(key)) {
                return node.getItem();
            }
        }
        return null;
    }

    public K getKey(int index) {
        return getNode(index).getKey();
    }

    public void addMap(K key, E element) {
        for (GarriksNode<K, E> node : this) {
            if (node.getKey().equals(key)) {
                node.setKey(key);
                return;
            }
        }
        add(element, key);
    }

    public boolean add(E o, K key) {
        GarriksNode<K, E> prevNode = tail.getPrev();
        GarriksNode<K, E> newNode = new GarriksNode<>(o, key, tail, prevNode);
        prevNode.setNext(newNode);
        tail.setPrev(newNode);
        len++;
        return true;
    }

}
