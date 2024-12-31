

/*
 * Main game class for the War card game
 * This class contains the main execution method to initialize and run the game
 * Date: September 24, 2024
 * Names: Matthew, Isaiah
 */

package com.samaham.warcardgame;

/**
*
* @author Isaia, Matthew
*/

import java.util.Scanner;

/*
 * Handles setup, game logic, and player interactions.
 */

public class Game {
    private User humanPlayer;
    private Machine aiPlayer;
    private Deck deck;
    private int roundNumber; 
    private Scanner scanner;

    // initializes game components
    public Game(){
        this.deck = new Deck(); 
        this.roundNumber = 1;
        this.scanner = new Scanner(System.in);
    }
 
    /*
     * Sets up the game with players, deals cards to both participants
     */
    public void setupGame(){
        Utils.systemPrint("Welcome to War!", ANSI.YELLOW);
        
        // prompt for player's name
        System.out.println("Enter your name: ");
        String playerName = scanner.nextLine().trim();
        if (playerName.isEmpty()) {
        	playerName = "Human"; // default name if none is provided
        }

        humanPlayer = new User(playerName, this, scanner);  // Pass scanner to User
        aiPlayer = new Machine("AI", this);

        // shuffling deck, deal cards to individual players
        Utils.systemPrint("Setting up game...", ANSI.YELLOW);
        deck.shuffle();
        deck.deal(humanPlayer, aiPlayer);

        Utils.systemPrint("Let's begin!", ANSI.YELLOW);
    }

    /*
     * Start game and alternates turns between user and the machine
     * Game continues while one player runs out of cards, the player loses
     */
    public void startGame() {
        Utils.systemPrint("Starting Game!", ANSI.YELLOW);
        while (humanPlayer.hasCards() && aiPlayer.hasCards()) {
            Utils.systemPrint("\n--- ROUND " + roundNumber + " ---", ANSI.RED);

            // Human player's turn
            Card humanCard = humanPlayer.drawCard();  // Now waits for user input to draw a card

            // AI player's turn
            Card aiCard = aiPlayer.drawCard();

            // Check if both players successfully played a card
            if (humanCard != null && aiCard != null) {
                determineRoundWinner(humanCard, aiCard);
            }

            // Print updated status after the round
            System.out.println(humanPlayer);
            System.out.println(aiPlayer);

            roundNumber++;  // Increase round number
            
         // Check if any player has lost all their cards
            if (!humanPlayer.hasCards() || !aiPlayer.hasCards()) {
                break;  // End the game if a player runs out of cards
            }
        }

        determineGameWinner();
        scanner.close();
    
    }

    /*
     * Compares cards drawn by both players and updates scores accordingly.
     * When it's a tie, both players draw another card, new cards are compared, and 
     * whichever is greater wins the round.
     */
    private void determineRoundWinner(Card humanCard, Card aiCard) {
        int result = humanCard.compare(aiCard);

        while (result == 0) { // Handle ties
            Utils.systemPrint("It's a tie! Both players draw again!", ANSI.BLUE);
            Card humanAdditionalCard = humanPlayer.drawCard();
            Card aiAdditionalCard = aiPlayer.drawCard();

            // If a player runs out of cards during the tie
            if (humanAdditionalCard == null || aiAdditionalCard == null) {
                Utils.systemPrint("A player ran out of cards during a tie!", ANSI.RED);
                return;
            }

            humanCard = humanAdditionalCard;
            aiCard = aiAdditionalCard;
            result = humanCard.compare(aiCard);
        }

        if (result > 0) {
            // Human wins
            Utils.systemPrint(humanPlayer.getName() + " wins the round!", ANSI.YELLOW);
            humanPlayer.addCardToDeck(humanCard);
            humanPlayer.addCardToDeck(aiCard);
            humanPlayer.incrementWins();
            aiPlayer.incrementLosses();
        } else {
            // AI wins
            Utils.systemPrint(aiPlayer.getName() + " wins the round!", ANSI.YELLOW);
            aiPlayer.addCardToDeck(humanCard);
            aiPlayer.addCardToDeck(aiCard);
            aiPlayer.incrementWins();
            humanPlayer.incrementLosses();
        }
    }

    /*
     * Determines the winner of the game based on the number of wins.
     */
    private void determineGameWinner() {
        Utils.systemPrint("\n--- Game Over ---", ANSI.YELLOW);

        // Display final results
        System.out.println(humanPlayer);
        System.out.println(aiPlayer);

        // Compare wins to determine the overall winner
        if (humanPlayer.getWins() > aiPlayer.getWins()) {
            Utils.systemPrint(humanPlayer.getName() + " is the overall winner!", ANSI.RED);
        } else if (humanPlayer.getWins() < aiPlayer.getWins()) {
            Utils.systemPrint(aiPlayer.getName() + " is the overall winner!", ANSI.RED);
        } else {
            Utils.systemPrint("The game is a draw!", ANSI.RED);
        }
    }

    // Main method: Creates an instance of the game, sets it up, and starts the game loop
    public static void main(String[] args) {
        Game game = new Game();
        game.setupGame();
        game.startGame();
    }
}
