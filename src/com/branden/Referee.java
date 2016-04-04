package com.branden;

import java.util.*;
/**
 * Created by badams on 3/10/16.
 */
public class Referee {
    String validSuite;
    private ArrayList discardPile = new ArrayList();

    public Boolean playedCardValid(int card){
        Card lastPlayedCard = getLastPlayedCard();
        Card playedCard = new Card(card);
        Boolean validPlay =  false;

        if ( playedCard.getValue() == 8 ) {
            validPlay = true;
        }
        else if ( getValidSuite().equalsIgnoreCase( playedCard.getSuit() ) ){
            //System.out.println("Played same suite");
            validPlay = true;
        }
        else if ( lastPlayedCard.getValue() == playedCard.getValue()){
            //System.out.println("Played same value");
            validPlay = true;
        }
        else {
            System.out.println("Invalid card");
        }

        return validPlay;

    }
    public Boolean checkForWild( int playedCard ){
        Card card = new Card( playedCard );
        return card.getValue() == 8;

    }

    public Boolean keepPlaying(Player p1, Player p2, Deck deck){
        return p1.getHand().size() > 0 && p2.getHand().size() > 0 && deck.getDeckSize() > 0;
    }
    public void setValidSuite( String suite ){
        validSuite = suite;
    }
    public String getValidSuite(){
        return validSuite;
    }

    public void pickSuite(Deck deck){
        System.out.println("Pick a suite: ");

        int suiteNumber = -1;

        Scanner input = new Scanner( System.in );
        Boolean validInput = false;
        String[] suites = deck.getSuites();

        for (int i = 0; i < suites.length; i++) {
            System.out.println(i + " : " + suites[i]);
        }
        while( !validInput ){
            while( !input.hasNextInt() ) {
                System.out.println("You must enter a valid number");
                input.next();
            }
            suiteNumber = input.nextInt();
            if(suiteNumber < 0 || suiteNumber > suites.length ){
                validInput = false;
            } else {
                validInput = true;
            }
        }
        setValidSuite( suites[suiteNumber] );
    }
    public void addToDiscardPile( int playedCard){
        discardPile.add(playedCard);
    }
    // Shows the last card added to the discard pile
    public Card getLastPlayedCard(){
        return new Card( (int) discardPile.get( discardPile.size() - 1) );
    }
    public void viewLastPlayedCard(){
        int cardValue;

        cardValue = (int) discardPile.get( discardPile.size() - 1);

        Card card = new Card( cardValue );

        // show the last first played card
        System.out.println("\tDiscard Pile");
        System.out.println("\t  ________");
        System.out.println("\t |        |");
        System.out.println("\t\t" + card.showCard());
        System.out.println("\t |________|\n\n");

    }

    public void checkHand( Player player, Deck deck){
        while ( !player.canPlayCard( getLastPlayedCard().getIntValue(), getValidSuite() ) ) {
            System.out.println("Must draw a card");
            player.addCard( deck.getCard() );
        }
    }
}
