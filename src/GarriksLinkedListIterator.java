import java.util.Iterator;
import java.util.NoSuchElementException;

public class GarriksLinkedListIterator<T, E> implements Iterator<GarriksNode<T, E>> {

    private GarriksNode<T, E> currElem;

    public GarriksLinkedListIterator(GarriksLinkedList<T, E> arr) {
        this.currElem = arr.getHead();
    }

    @Override
    public boolean hasNext() {
        return currElem.getNext().getItem() != null;
    }

    @Override
    public GarriksNode<T, E> next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException("Garriks iterator can't see more elements :)");
        }
        currElem = currElem.getNext();
        return currElem;
    }
}
