
package com.samaham.warcardgame;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author isaia, matthew
 * Abstract base class represnting a participant in the War game.
 * This class is extended by both 'User' and 'Machine' classes.
 */

public abstract class Participant {
    private final List<Card> deck; 
    private String name; 
    private int wins; 
    private int losses; 
    private Game game;
    
    
    // Initializes deck as an empty list, sets wins and losses to 0.
    public Participant(String name, Game game){
        this.name = name;
        this.game = game;
        this.deck = new ArrayList<>();
        this.wins = 0; 
        this.losses = 0;
    }

    // method for drawing a card from the deck; implemented by sub classes
    public abstract Card drawCard();  
    
    // method for adding a card to the participant's deck; implemented by sub classes
    public abstract void addCardToDeck(Card card);  
    
    // method to check if participant has any cards in their deck; implemented by sub classes
    public abstract boolean hasCards();  

    /*
     * Common class methods shared by all participants
     */
    
    // getters/setters
    public String getName() {
        return name;
    }

    public Game getGame() {
        return game;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }
    
    /*
     * Increments wins and loss counts by 1
     */

    public void incrementWins() {
        wins++;
    }

    public void incrementLosses() {
        losses++;
    }
    
    /*
     * Provides string representation of participant's deck status:
     * Name, wins, losses, and how many cards are remaining.
     */

    @Override
    public String toString() {
        return name + " | Wins: " + wins + ", Losses: " + losses + ", Cards Remaining: " + deck.size();
    }

    // Protected function to allow access to participant's deck.
    protected List<Card> getDeck() {
        return deck;
    }

    // Gets the number of cards remainng in participant's deck
    public int getDeckSize() {
        return deck.size();
    }
    
    

    /*
     * The following commented-out methods illustrates previous additional functionality for participant behavior.
     * These methods could be revisited or modified as needed in the future.

    public String getName(){
        return name;
    }

    // checks if participant has any cards remaining in their deck
    public boolean hasCards(){
        return !deck.isEmpty(); // true if deck is not empty, false otherwise
    }

    public Card drawCard(){
        return deck.poll(); // removes, returns card at front of Deque, 
    }

    // new method: adds a card to bottom of participant's deck
    public void addCardToDeck(Card card){
        deck.offer(card); // end of deque
    }

    // new method: adds multiple cards to bottom of participant's deck
    public void addCardsToCard(Iterable<Card> cards){
        for (Card c : cards){
            deck.offer(c); // add each card individually to the deck
        }
    }

    // new method: keep track of number of cards remaining in participant's deck
    public int getDeckSize(){
        return deck.size();
    }

    // abstract method; implemented by child classes
    // didcates how much ea participant makes a descision (AI logic for Machine)
    public abstract void playTurn();

    public void incrementWins(){
        wins++;
    }

    public void incrementLosses(){
        losses++;
    }

    // retrieves number of wins for the participant
    public int getWins(){
        return wins;
    }

    // retrieves number of losses for the participant
    public int getLosses(){
        return losses;
    }


    // retrieves game instance; participant is part of
    public WarCardGame getGame(){
        return game;
    }


    @Override
    public String toString(){
        return name + " (Wins: " + wins + " | Losses: " + losses + " | Cards in Deck: " + getDeckSize() + ")";
    }

    */

}
