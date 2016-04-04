package com.branden;

public class Main {

    public static void main(String[] args) {

        Deck deck = new Deck();
        Player player1 = new Player("Branden");
        Computer player2 = new Computer();
        Referee referee = new Referee();
        deck.deal(player1, player2);

        // flip the first card
        int card = deck.getCard();
        referee.addToDiscardPile( card );
        // suite is the first card's suite
        referee.setValidSuite( referee.getLastPlayedCard().getSuit());
        referee.viewLastPlayedCard();

        while( referee.keepPlaying( player1, player2, deck) ) {

            // Check if the payer can play a card, if not then draw a card, then show the hand
            //player1.checkHand( deck, );
            referee.checkHand( player1, deck );
            player1.viewHand();
            card = player1.pickCard();
            //card = player1.autoPick( deck.getLastPlayedCard(), deck.getValidSuite() );

            while (!referee.playedCardValid( card ) ) {
                card = player1.pickCard();
            }

            player1.discardCard(card);
            referee.addToDiscardPile(card);
            referee.setValidSuite( referee.getLastPlayedCard().getSuit() );

            referee.viewLastPlayedCard();

            if ( referee.checkForWild( card ) ){
                referee.pickSuite( deck );
                System.out.println("\n----------------------\nThe suite is : " +  referee.getValidSuite() +"\n--- -------------------\n");

            }
            //player2.viewHand();
            // check if player 2 can play card
            referee.checkHand( player2, deck );
            //card = player2.pickCard();

            card = player2.autoPick( referee.getLastPlayedCard().getIntValue(), referee.getValidSuite() );

            while (!referee.playedCardValid( card )) {
                //card = player2.pickCard();
                card = player2.autoPick( referee.getLastPlayedCard().getIntValue(), referee.getValidSuite() );

            }

            player2.discardCard(card);
            referee.addToDiscardPile(card);
            referee.setValidSuite( referee.getLastPlayedCard().getSuit() );
            if ( referee.checkForWild( card ) ){

                referee.setValidSuite( player2.autoPickSuite() );
                System.out.println("\n----------------------\nThe suite is : " +  referee.getValidSuite() +"\n----------------------\n");
            }
            referee.viewLastPlayedCard();


        }
        if ( deck.getDeckSize() == 0){
            System.out.println("We ran out of cards. Game Over");
        }
        // display winner
        // TODO get scoring to work after game is over
        System.out.println("Game Over");
    }
}