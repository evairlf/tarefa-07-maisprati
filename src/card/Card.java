package card;

public class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getValue() {
        return rank;
    }

    public void setValue(String value) {
        this.rank = value;
    }

    @Override
    public String toString() {
        return this.rank + " de " + this.suit;
    }
}
