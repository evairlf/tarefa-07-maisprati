package impressao;

public class Document {
    private String name;
    private int numberPages;
    private boolean isColorful;

    public Document(String name, int numberPages, boolean isColorful) {
        this.name = name;
        this.numberPages = numberPages;
        this.isColorful = isColorful;
    }

    public String getName() {
        return name;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public boolean isColorful() {
        return isColorful;
    }

    @Override
    public String toString() {
        return "Documento: " + this.name +
                ", número de páginas: " + this.numberPages +
                ", colorido: " + (this.isColorful ? "Sim" : "Não");
    }
}
