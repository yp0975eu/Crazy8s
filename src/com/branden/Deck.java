package com.branden;
import java.util.*;

/**
 * Created by badams on 3/10/16.
 */
public class Deck {
    private int deckSize = 52;
    private String[] suites = {"Spades","Clubs","Hearts","Diamonds"};
    private ArrayList unShuffledDeck = new ArrayList();
    private ArrayList shuffledDeck = new ArrayList();
    // contains the string value of a valid suite that can be played

    Deck(){
        setUnShuffledDeck();
        setShuffledDeck();
    }

    private void setUnShuffledDeck(){
        for (int i = 0; i < deckSize; i++) {
            unShuffledDeck.add(i);
        }
    }
    private void setShuffledDeck(){
        int index;
        Random rnd = new Random();
        // randomly get ints from the un-shuffled deck of cards
        // remove the card from the deck with each iteration.

        while(unShuffledDeck.size() > 0){
            index = rnd.nextInt( unShuffledDeck.size() );
            shuffledDeck.add( unShuffledDeck.remove( index ) );
        }
    }
    private void setDeckSize(){
        deckSize = shuffledDeck.size();
    }
    public int getDeckSize(){
       return deckSize;
    }


    // removes card from top of deck ( index 0 );
    public int getCard(){
        int card;

        card = (int) shuffledDeck.remove(0);
        // update deck size
        setDeckSize();
        return card;
    }
    public void deal(Player p1, Player p2){
        int cardsPerHand = 5;

        for (int i = 0; i < cardsPerHand; i++) {

            p1.addCard( getCard() );
            p2.addCard( getCard() );
        }

    }

    public String[] getSuites( ){
        return suites;
    }


}
