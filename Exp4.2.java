import java.util.*;

class Card {
    String suit;
    String rank;

    Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

class CardCollection {
    private Map<String, Set<Card>> cardsBySuit = new HashMap<>();

    void addCard(String suit, String rank) {
        cardsBySuit.putIfAbsent(suit, new HashSet<>());
        Card newCard = new Card(suit, rank);
        if (cardsBySuit.get(suit).contains(newCard)) {
            System.out.println("Error: Card \"" + newCard + "\" already exists.");
        } else {
            cardsBySuit.get(suit).add(newCard);
            System.out.println("Card added: " + newCard);
        }
    }

    void findCardsBySuit(String suit) {
        if (cardsBySuit.containsKey(suit) && !cardsBySuit.get(suit).isEmpty()) {
            for (Card card : cardsBySuit.get(suit)) {
                System.out.println(card);
            }
        } else {
            System.out.println("No cards found for " + suit + ".");
        }
    }

    void displayAllCards() {
        if (cardsBySuit.isEmpty()) {
            System.out.println("No cards found.");
            return;
        }
        for (Set<Card> cards : cardsBySuit.values()) {
            for (Card card : cards) {
                System.out.println(card);
            }
        }
    }

    void removeCard(String suit, String rank) {
        if (cardsBySuit.containsKey(suit)) {
            Card cardToRemove = new Card(suit, rank);
            if (cardsBySuit.get(suit).remove(cardToRemove)) {
                System.out.println("Card removed: " + cardToRemove);
                if (cardsBySuit.get(suit).isEmpty()) {
                    cardsBySuit.remove(suit);
                }
            } else {
                System.out.println("Error: Card \"" + cardToRemove + "\" not found.");
            }
        } else {
            System.out.println("Error: No cards found for suit " + suit + ".");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CardCollection cc = new CardCollection();
        cc.displayAllCards();
        cc.addCard("Spades", "Ace");
        cc.addCard("Hearts", "King");
        cc.addCard("Diamonds", "10");
        cc.addCard("Clubs", "5");
        cc.findCardsBySuit("Hearts");
        cc.findCardsBySuit("Diamonds");
        cc.displayAllCards();
        cc.addCard("Hearts", "King");
        cc.removeCard("Diamonds", "10");
    }
}

