package reundo;

public class ReundoEditor {
    private final String text;

    private ReundoEditor(Builder builder) {
        this.text = builder.text;
    }

    public String getText() {
        return text;
    }

    public ReundoEditor withText(String text) {
        return new Builder().text(text).build();
    }

    @Override
    public String toString() {
        return text;
    }

    public static class Builder {
        private String text;

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public ReundoEditor build() {
            return new ReundoEditor(this);
        }
    }
}
