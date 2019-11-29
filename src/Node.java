public class Node<E> implements Position<E> {

    private E element;
    private Node<E> prev;
    private Node<E> next;

    public Node(E element, Node<E> previous, Node<E> next){
        this.element = element;
        prev = previous;
        this.next = next;
    }

    @Override
    public E getElement() throws IllegalStateException {
        if(next == null){
            throw new IllegalStateException("Next is not valid");
        }
        return element;
    }

    public Node<E> getPrev(){
        return prev;
    }

    public Node<E> getNext(){
        return next;
    }

    public void setElement(E element){
        this.element = element;
    }

    public void setPrev(Node<E> prev){
        this.prev = prev;
    }

    public void setNext(Node<E> next){
        this.next = next;
    }

}
