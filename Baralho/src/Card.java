public class Card {
    private final Rank rank;
    private final Suit suit;
    private boolean faceDown;

    public Card(Rank rank, Suit suit){
        this(rank, suit, true);
    }

    public Card(Rank rank, Suit suit, boolean faceDown) {
        this.rank = rank;
        this.suit = suit;
        this.faceDown = faceDown;
    }

    public String cardAsString() { return  isFaceDown() ? "XX" : rank + " " + suit; }

    public void faceDown(){
        faceDown = true;
    }

    public void faceUp(){
        faceDown = false;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public boolean isFaceDown() {
        return faceDown;
    }
}

