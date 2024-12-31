
package com.samaham.warcardgame;

/**
 *
 * @author Isaia, Matthew
 * Represents AI player in the game. 
 */

 // This class extends from the base/parent Participant class and implements somewhat of an AI behavior.
public class Machine extends Participant {
    /**
     * Constructor for Machine.
     * @param name The name of the AI player.
     * @param game The game instance the machine is part of.
     */
    public Machine(String name, Game game) {
        super(name, game);
    }

    // Implementing the abstract methods
    
    // Simulates AI by 'drawing a card' or null if the deck is empty
    @Override
    public Card drawCard() {
    	// checks if AI has enough cards to draw
        if (hasCards()) {
            Card drawnCard = getDeck().remove(0);  // AI draws the top card
            System.out.println(getName() + " drew: " + drawnCard);  // Print the card the AI drew
            return drawnCard;
            // return null if no cards are available to draw
        } else {
            System.out.println(getName() + " has no cards left to draw!");
            return null;  // Return null if no cards are left
        }
    }

    // Adds a crd to the AI's dek
    @Override
    public void addCardToDeck(Card card) {
        getDeck().add(card);  // Adds the card to the end of the deck
    }

    // Check's if AI's deck contain any cards
    @Override
    public boolean hasCards() {
        return !getDeck().isEmpty();  // Checks if the deck is not empty
    }
    
    // Executes the AI's turn in the game by drawing a card; this method simulates the AI taking it's turn and plays automatically.
    public void playTurn() {
        System.out.println(getName() + "'s turn to play!");
        drawCard();  // AI plays its turn by drawing a card
    }
    
    
    /** Previous implementation of playTurn (commented out
     * Demonstrates another way the turn could of been executed
     */
    /* 
    @Override
    public void playTurn() {
        System.out.println(getName() + " is taking its turn...");
        Card drawnCard = drawCard();
        System.out.println(getName() + " drew: " + drawnCard);
    }
    */
}
