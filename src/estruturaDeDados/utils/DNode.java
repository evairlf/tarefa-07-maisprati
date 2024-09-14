package estruturaDeDados.utils;

public class DNode<E> {
    protected E element;
    protected DNode<E> prev;
    protected DNode<E> next;

    public DNode(E element) {
        this.element = element;
        this.prev = this.next = null;
    }

    public E getElement() {
        return element;
    }

    public DNode<E> getPrevious() {
        return prev;
    }

    public DNode<E> getNext() {
        return next;
    }

    public void setElement(E e) {
        this.element = e;
    }

    public void setPrevious(DNode<E> prev) {
        this.prev = prev;
    }

    public void setNext(DNode<E> next) {
        this.next = next;
    }
}
