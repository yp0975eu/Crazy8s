package com.branden;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by badams on 5/17/16.
 */
public class PlayerTest {

    @Test
    public void testAddCard() throws Exception {
        // create a new player
        Player player = new Player("TestPlayer");
        // test that when a player is initialized there are 0 cards in the hand
        assertEquals( 0, player.getHand().size() );
        // add card
        player.addCard(3);
        // test that the hand size is now 1
        assertEquals(1, player.getHand().size());
    }
}