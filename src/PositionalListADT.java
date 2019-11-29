public interface PositionalListADT<E> {

    int size();
    boolean isEmpty();
    Position<E> first();
    Position<E> last();
    Position<E> before(Position<E> position) throws IllegalArgumentException;   //what comes before position
    Position<E> after(Position<E> position) throws IllegalArgumentException;       //what comes after
    Position<E> addFirst(E element);            //add to start of positional list
    Position<E> addLast(E element);             //add to end
    Position<E> addBefore(Position<E> position, E element) throws IllegalArgumentException;         //add element before given position
    Position<E> addAfter(Position<E> position, E element) throws IllegalArgumentException;         //add element after given position
    E set(Position<E> position, E element) throws IllegalArgumentException;             // where to set the given element
    E remove(Position<E> position) throws IllegalArgumentException;
}
