package com.branden;

/**
 * Created by badams on 3/10/16.
 */
public class Card {

    private int value;
    private int intValue;
    private String suit;
    private String symbol;
    // takes an int and returns the value and face associated with the card
    Card( int cardNumber ){
        setSuit( cardNumber );
        setValue( cardNumber );
        setIntValue( cardNumber );
    }
    public int getValue() {
        return value;
    }
    private void setValue(int cardNumber) {
        // card number is an int 0 - 51 representing the individual cards of a deck
        // There are only 13 cards to a suite.
        // SetValue takes mod 13 and adds 1 to account for arrays being 0 based.

        // 0 - 1 ( Ace )
        // 1 - 2
        // 2 - 3
        // ...
        // 10 - Jack
        // 11 - Queen
        // 12 - King
        this.value =  (cardNumber % 13) + 1;
    }
    public String getSuit() {
        return suit;
    }
    private void setSuit(int cardNumber) {
        // card number is an int 0 - 51 representing the individual cards of a deck
        String suitName;
        String symbolString;
        // 0 -12 Spades
        if ( cardNumber < 12){
            suitName = "Spades";
            symbolString = "\u2664";
        }
        // if it's grater than 12 then it's not a spade so it has to be one of the other suites
        // if it's passed the first if, then it's greater than 12 and so check if it's a club, etc...
        else if ( cardNumber < 25){
            suitName = "Clubs";
            symbolString = "\u2667";

        } else if ( cardNumber < 38){
            suitName = "Hearts";
            symbolString = "\u2665";

        } else if ( cardNumber <= 51){
            suitName = "Diamonds";
            symbolString = "\u2666";

        } else {
            System.out.println("Error, Card number" + cardNumber );
            suitName = "Error";
            symbolString = "Error";
        }
        this.symbol = symbolString;
        this.suit = suitName;
    }
    public String getSymbol() {
        return symbol;
    }
    public String showCard(){
        return getValue() + " " + getSymbol();
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }
}
