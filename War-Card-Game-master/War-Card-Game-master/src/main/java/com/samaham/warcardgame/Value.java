
package com.samaham.warcardgame;

/**
 *
 * @author isaia and matthew
 */
public enum Value {
    /*
     * Ranks for the playing cards, each rank has a numerical value for comparison.
     * Range from 2 to 14
     */

    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);

    // stores the numerical value
    public final int rank;

    // constructor for the values, this will assign the numerical rank to each card value
    Value(int rank){
        this.rank = rank;
    }

    // getter; meant to retrieve the numerical rank of the card values
    public int getRank(){
        return rank;
    }
}
