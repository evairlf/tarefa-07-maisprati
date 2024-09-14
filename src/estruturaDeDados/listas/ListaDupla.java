package estruturaDeDados.listas;

import estruturaDeDados.utils.DNode;

public class ListaDupla<E> {
    DNode<E> head;
    DNode<E> tail;
    int size;

    public ListaDupla() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertFirst(E element) {
        DNode<E> newNode = new DNode<E>(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }

        size++;
    }

    public void insertLast(E element) {
        DNode<E> newNode = new DNode<E>(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }

        size++;
    }

    public void insert(E element, int pos) {
        if (pos < 0  ||  pos > size) {
            throw new IndexOutOfBoundsException();
        }

        if (pos == 0) {
            insertFirst(element);
        }else if (pos == size) {
            insertLast(element);
        }else {
            DNode<E> prev = head;
            for (int i = 0; i < pos-1; i++) {
                prev = prev.getNext();
            }
            DNode<E> newNode = new DNode<E>(element);
            newNode.setPrevious(prev);
            newNode.setNext(prev.getNext());
            prev.getNext().setPrevious(newNode);
            prev.setNext(newNode);
            size++;
        }
    }

    public E removeFirst() {
        if (isEmpty()){
            throw new IndexOutOfBoundsException("Index fora dos limites/inválido.");
        }

        E element = head.getElement();
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.getNext();
            head.setPrevious(null);
        }

        size--;
        return element;
    }

    public E removeLast() {
        if (isEmpty()){
            throw new IndexOutOfBoundsException("Index fora dos limites/inválido.");
        }

        E element = tail.getElement();
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        size--;
        return element;
    }

    public E remove(int pos) {
        if (pos < 0  ||  pos >= size){
            throw new IndexOutOfBoundsException("Index fora dos limites/inválido.");
        }

        if (pos == 0) {
            return removeFirst();
        } else if (pos == size - 1) {
            return removeLast();
        } else {
            DNode<E> prev = head;
            for (int i = 0; i < pos-1; i++){
                prev = prev.getNext();
            }

            E element = prev.getNext().getElement();
            prev.setNext(prev.getNext().getNext());
            prev.getNext().setPrevious(prev);

            size--;

            return element;
        }
    }

    public E get(int pos) {
        if (pos < 0  ||  pos >= size){
            throw new IndexOutOfBoundsException("Index fora dos limites/inválido.");
        }

        DNode<E> current = head;
        for (int i = 0; i < pos; i++){
            current = current.getNext();
        }

        return current.getElement();
    }

    public int search(E element) {
        DNode<E> current = head;
        int i = 0;

        while (current != null) {
            if (element.equals(current.getElement())) {
                return i;
            }
            i++;
            current = current.getNext();
        }

        return -1;
    }

    public void showAllElements() {
        DNode<E> current = this.head;
        while(current != null){
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }

    public void swap(int pos1, int pos2) {
        if(pos1 >= 0 && pos2 >= 0 && pos1 <= this.size && pos2 <= this.size) {
            E aux1 = this.remove(pos1);
            pos1--;
            pos2--;

            E aux2 = this.remove(pos2);
            pos1++;
            pos2++;

            this.insert(aux2, pos1);
            this.insert(aux1, pos2);
        }
    }
}
