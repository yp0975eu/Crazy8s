package com.branden;

import java.util.*;

/**
 * Created by badams on 3/10/16.
 */
public class Player {
    private String name;
    private int score;
    private ArrayList hand = new ArrayList();
    Scanner userInput = new Scanner( System.in );
    private Boolean hasMove = false;
    private Boolean canMakeMove = false;

    Player( String name ){
        setName(name);
    }
    public ArrayList getHand() {
        return hand;
    }

    public void addCard(int card) {

        hand.add(card);
    }

    public void viewHand(){
        System.out.println("\n----  Your Hand    ---");

        for (int i = 0; i < hand.size(); i++) {
            System.out.println( i + " : " + getCardString( (int) hand.get(i) ) ) ;

        }
        System.out.println("----------------------\n");

    }

    public String getCardString(int card) {
        Card c = new Card( card );
        return c.showCard();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // get card int value from hand
    public int pickCard(){
        int input = -1; // initialize to invalid value
        int card;
        Boolean inputValid = false;
        System.out.println("Enter number to play card.");

        while ( !inputValid ){
            while( !userInput.hasNextInt() ){
                System.out.println("You must enter an integer to select a card.");
                userInput.next();
            }
            input = userInput.nextInt();
            if ( input < 0 || input > hand.size() -1 ){
                System.out.println("You must choose a valid card.");

            } else{
                inputValid = true;
            }
        }
        // get selection from hand
        card = (int) hand.get(input);

        // print out the string representation of the card
        System.out.println(
                "\n----------------------\nYou chose: "
                +   getCardString( card  )
                +"\n----------------------\n"
        );

        return card;
    }

    // remove card from hand
    public void discardCard( int card ){
        hand.remove( hand.indexOf( card ) );

    }

    public Boolean getHasMove() {
        return hasMove;
    }
    public void setHasMove(Boolean canMakeMove) {
      hasMove = canMakeMove;

    }
    public boolean canPlayCard( int lastPlayedCard, String validSuite ){
        Boolean canMakeMove = false;
        Card card;
        Card lastCard = new Card ( lastPlayedCard );
        Boolean canPlaySuite = false;
        for (int i = 0; i < hand.size(); i++) {
            card = new Card( (int ) hand.get(i) );

            if ( lastCard.getValue() == 8 ){
                canPlaySuite = card.getSuit().equalsIgnoreCase( validSuite );
            } else {
                canPlaySuite = card.getSuit().equalsIgnoreCase( lastCard.getSuit() );
            }

            if ( canPlaySuite || card.getValue() == 8 || card.getValue() == lastCard.getValue() ){
                canMakeMove = true;
            }
        }

        setHasMove( canMakeMove );
        return getHasMove();
    }

    // The computer's logic to choose a card
    public int autoPick(int lastPlayedCard, String validSuite){
        Card card;
        int cardInt = -1;
        Card lastCard = new Card ( lastPlayedCard );
        Boolean canPlay = false;

        for (int i = 0; i < hand.size(); i++) {

            cardInt = (int ) hand.get(i);
            card = new Card( cardInt );

            // if last card was 8 then check the deck for a the valid suite
            if ( lastCard.getValue() == 8 ){
                canPlay = card.getSuit().equalsIgnoreCase( validSuite );
            } else {
                canPlay = card.getSuit().equalsIgnoreCase( lastCard.getSuit() );
            }

            if ( canPlay || card.getValue() == 8 || card.getValue() == lastCard.getValue() ){
                // print out the string representation of the card
                System.out.println( "Computer chose: " + getCardString( cardInt  ) );
                return cardInt;
            }
        }
        return cardInt;
    }

}
