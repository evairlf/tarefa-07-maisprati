package gerenciadorDeProcessos;

public class Process {
    private String name;

    public Process(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Nome do processo: " + this.name;
    }
}
