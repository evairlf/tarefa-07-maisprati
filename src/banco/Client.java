package banco;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Client {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    private final int id;
    private String name;

    public Client(String name) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Cliente ID: %d, Nome: %s", id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
