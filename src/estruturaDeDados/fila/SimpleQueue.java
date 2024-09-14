package estruturaDeDados.fila;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleQueue<T> {
    private final Queue<T> queue = new LinkedList<>();

    // Adiciona um item à fila
    public void enqueue(T item) {
        queue.add(item);
    }

    // Remove e retorna o item do início da fila
    public T dequeue() {
        return queue.poll();
    }

    // Verifica se a fila está vazia
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Retorna o número de itens na fila
    public int size() {
        return queue.size();
    }

    // Exibe todos os elementos da fila
    public void showAllElements() {
        if (queue.isEmpty()) {
            System.out.println("A fila está vazia.");
            return;
        }

        for (T item : queue) {
            System.out.println(item);
        }
    }
}
