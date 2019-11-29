public class LinkedPositionalList<E> implements PositionalListADT<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public LinkedPositionalList(){
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.setNext(tail);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Position first() {
        return position(head.getNext());
    }

    @Override
    public Position last() {
        return position(tail.getPrev());
    }

    private Position<E> position(Node<E> node) {
        if(node == head || node == tail){
            return null;
        }
        return node;
    }

    @Override
    public Position<E> before(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validate(position);
        return position(node.getPrev());
    }

    private Node<E> validate(Position<E> position) {
        if(!(position instanceof Node)){
            throw new IllegalArgumentException("Invalid position");
        }
        Node<E> node = (Node<E>) position;
        if(node.getNext() == null){
            throw new IllegalArgumentException("Position no longer in the list");
        }
        return node;
    }

    @Override
    public Position<E> after(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validate(position);
        return position(node.getNext());
    }

    @Override
    public Position<E> addFirst(E element) {
        return addBetween(element, head, head.getNext());
    }

    private Position<E> addBetween(E element, Node<E> head, Node<E> next) {
        Node<E> newest = new Node<>(element, head, next);
        head.setNext(newest);
        next.setPrev(newest);
        size++;
        return newest;
    }

    @Override
    public Position<E> addLast(E element) {
        return addBetween(element, tail, tail);
    }

    @Override
    public Position<E> addBefore(Position<E> position, E element) throws IllegalArgumentException {
        Node<E> node = validate(position);
        return addBetween(element, node.getPrev(), node);
    }

    @Override
    public Position<E> addAfter(Position<E> position, E element) throws IllegalArgumentException {
        Node<E> node = validate(position);
        return addBetween(element, node, node.getNext());
    }

    @Override
    public E set(Position<E> position, E element) throws IllegalArgumentException {
        Node<E> node = validate(position);
        E temp = node.getElement();             //get node originally stored at this position
        node.setElement(element);               //replace it with what was passed in
        return temp;                            //return node content that was overridden
    }

    @Override
    public E remove(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validate(position);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E temp = node.getElement();
        node.setElement(null);
        node.setNext(null);
        node.setPrev(null);
        return temp;
    }

}
