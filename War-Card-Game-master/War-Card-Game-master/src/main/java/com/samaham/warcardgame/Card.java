/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samaham.warcardgame;

/**
 *
 * @author Isaia, Matthew
 */
public class Card {
    // suits of the cards, and the numerical value of the cards (HEARTS, ACE, etc)
    private final Suit suit;
    private final Value value;
    // count to track state of cards
    private static int cardCount = 0;

    public Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
        increaseCardCount();
    }

    // getters
    public Value getValue(){
        return value;
    }

    public Suit getSuit(){
        return suit;
    }

    // method used to display the card's suit, and value
    // "VALUE OF SUIT"
    @Override
    public String toString(){
        return value + " of " + suit;
    }


    /* Previous comparison method
     * Brainstorming... added a new method here so our main game class does not have to take care of comparing cards
     * public int compare(Card otherCard){
     * return Integer.compare(this.value.getRank(), other.Card.value..getRank());
     *  }
     */

     // comparing cards --> if-else structure
    public int compare(Card otherCard){
        if (this.value.getRank() > otherCard.value.getRank()){
            return 1; // this card is a higher rank
        } else if (this.value.getRank() < otherCard.value.getRank()){
            return -1; // this card is a lower rank
        } else {
            return 0; // ranks are equal
        }
    }
    
    public static int getCardCount() {
        return cardCount;
    }
    
    public static void increaseCardCount() {
        cardCount++;
    }
}
