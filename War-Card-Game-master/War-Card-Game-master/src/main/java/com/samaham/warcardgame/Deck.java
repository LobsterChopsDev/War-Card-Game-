
package com.samaham.warcardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Isaia, Matthew
 * 
 * Class represents a deck of cards for the game.
 * It includes the functionality to intiailize, shuffle, and distribute cards.
 */
public class Deck {
    private final List<Card> cards;

    // Initializes the deck with 52-cards and shuffles it.
    public Deck(){
        cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }

    /*
     * Initializes deck with standard 52-cards
     * Each card is a combination of a Suit and a Value
     */
    private void initializeDeck() {
        for (Suit suit : Suit.values()) { // Iterate through all suits
            for (Value value : Value.values()) { // Iterate through all values
                cards.add(new Card(suit, value)); // Create a new card and add to the deck
            }
        }
    }

    /*
     * Shuffles deck using Collections.shuffle method
     * Needed to add this method; alternative hardcoded method would be:
     */

    public void shuffle() {
        Collections.shuffle(cards); // Shuffle the list of cards
    }

    /**
     * Deals cards evenly between two participants.
     * Cards are alternated between the two starting with player1
     *
     * @param player1 The first participant.
     * @param player2 The second participant.
     */
    public void deal(Participant player1, Participant player2) {
        for (int i = 0; i < cards.size(); i++) {
            if (i % 2 == 0) {
                player1.addCardToDeck(cards.get(i)); // Add card to player 1's deck
            } else {
                player2.addCardToDeck(cards.get(i)); // Add card to player 2's deck
            }
        }
    }

    /**
     * Retrieves the number of cards remaining in the deck.
     *
     * @return The size of the deck.
     */
    public int getDeckSize() {
        return cards.size();
    }

    // Converts deck's content to a human-readable string format for better output
    @Override
    public String toString() {
        StringBuilder deckString = new StringBuilder("Deck contains:\n");
        for (Card card : cards) {
            deckString.append(card).append("\n"); // Append each card to the string
        }
        return deckString.toString();
    }

}
