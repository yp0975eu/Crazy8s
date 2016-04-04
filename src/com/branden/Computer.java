package com.branden;

import java.util.HashMap;

public class Computer extends Player {
    Computer(){
        super( "Computer" );
    }
    // The computer's logic to choose a card
    public int autoPick(int lastPlayedCard, String validSuite){
        Card card;
        int cardInt = -1;
        Card lastCard = new Card ( lastPlayedCard );
        Boolean canPlay;

        for (int i = 0; i < hand.size(); i++) {

            cardInt = hand.get(i);
            card = new Card( cardInt );

            // if last card was 8 then check the deck for a the valid suite
            if ( lastCard.getValue() == 8 ){
                canPlay = card.getSuit().equalsIgnoreCase( validSuite );
            } else {
                canPlay = card.getSuit().equalsIgnoreCase( lastCard.getSuit() );
            }

            if ( canPlay || card.getValue() == 8 || card.getValue() == lastCard.getValue() ){
                // print out the string representation of the card
                System.out.println(
                        "\n----------------------\nComputer chose: "
                                +   getCardString( cardInt  )
                                +"\n----------------------\n"
                );
                return cardInt;
            }
        }
        return cardInt;
    }

    public String autoPickSuite( ){
        HashMap<String, Integer> suitCount = new HashMap<>();
        // initialize suiteCount array to all 0s;
        String[] suits = Deck.getSuites();
        for (int i = 0; i < suits.length; i++) {
            suitCount.put( suits[i], 0 );
        }
        Card card;

        // get count of each suite in hand.
        for (int i = 0; i < hand.size(); i++) {

            card =  new Card( hand.get(i));
            int count = suitCount.get( card.getSuit() );
            suitCount.put( card.getSuit(),  ++count);
        }
        // return the first suite with the highest count
        // TODO if there is a tie between suits then decide which suite is better to play
        int count = 0;
        String highestSuit = "";
        int highestSuitCount = 0;
        for (String suit : suitCount.keySet() ) {
            // first iteration
            if ( count == 0){
                highestSuitCount = suitCount.get(suit);
                highestSuit = suit;

            } else {
                if ( suitCount.get(suit) > highestSuitCount ){
                    highestSuitCount = suitCount.get(suit);
                    highestSuit = suit;
                }
            }
            count++;
        }
        return highestSuit;
    }

}
