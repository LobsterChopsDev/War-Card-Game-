
package com.samaham.warcardgame;

import java.util.Scanner;

/**
 *
 * @author Isaia, Matthew
 * Represents the human player class in the War game
 * Class extends the abstract Participant class and provides user functionality for a user to play their turns.
 */

public class User extends Participant {
    private final Scanner scanner;

    public User(String name, Game game, Scanner scanner){
        super(name, game);
        this.scanner = scanner;
    }

    /*
     * Prompts user to draw a card during their turn. The card drawn from user's deck, or null, if no cards are left.
     */
    @Override
    public Card drawCard() {
        // Prompt user to press Enter to draw a card
        System.out.println(getName() + ", it's your turn! Press Enter to draw a card.");
        scanner.nextLine(); 

        // Check if the user has any cards left
        if (hasCards()) {
            Card drawnCard = getDeck().remove(0);  // 
            System.out.println(getName() + " drew: " + drawnCard);  // 
            return drawnCard;
        } else {
        	// notify if user deck is empty
            System.out.println(getName() + " has no cards left to draw!");
            return null;  
        }
    }

    /*
     * Adds a card to user's deck
     */
    @Override
    public void addCardToDeck(Card card) {
        // Adds the card to the end of the deck (bottom)
        getDeck().add(card);
    }

    // Checks if there are any cards left in the deck
    @Override
    public boolean hasCards() {
        return !getDeck().isEmpty();
    }

    /*
     * Allow user to play their turn interactively; prompts user to draw a card
     */
    public void playTurn() {
        System.out.println(getName() + "'s turn to play!");
        
        
        /**
         * Previous original implementation for playTurn()
         * Plays the machine's turn by automatically drawing a card.
         */
        /* 
         @Override
        public void playTurn() {
            System.out.println(getName() + ", it's your turn.");
            System.out.println("Press Enter to draw a card...");
            scanner.nextLine(); // Wait for user input
            Card drawnCard = drawCard();
            System.out.println(getName() + " drew: " + drawnCard);
        }
            */
        // Implementing the abstract methods
        // Implementing the abstract methods from Participant class
    }
}
