package historicoNavegador;

public class Browser {
    private String url;

    public Browser(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "URL: " + this.url;
    }
}
