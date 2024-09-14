package estruturaDeDados.listas;

import estruturaDeDados.utils.Node;

public class ListaSimples<E> {
    private Node<E> head;

    public ListaSimples() {
        this.head = null;
    }

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public E get(int index) {
        checkIndex(index);
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getElement();
    }

    public void remove(int index) {
        checkIndex(index);
        if (index == 0) {
            head = head.getNext();
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
    }

    public int size() {
        int count = 0;
        Node<E> current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void showAllElements() {
        Node<E> current = head;
        while (current != null) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index fora dos limites: " + index);
        }
    }
}
