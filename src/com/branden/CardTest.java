package com.branden;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

/**
 * Created by badams on 5/17/16.
 */
public class CardTest {
        protected Card card;

        @Before
        public void setUp(){
                // pass in any integer that is a valid card.
                // we need a card instance to access the isSuite Methods
               this.card = new Card(2);
        }
        // test if a negative integer results in false;
        @Test
        public void testNegativeSpade() throws Exception{
            assertEquals( false, card.isSpade(-1) );
        }
        @Test
        public void testOuterLimitSpade() throws Exception{
            assertEquals( false, card.isSpade(14) );

        }
        @Test
        public void testValidSpade() throws Exception{
            assertEquals( false, card.isSpade(13) );

        }
        // test if a negative integer results in false;
        @Test
        public void testClubs() throws Exception{
            // test for negative
            assertEquals( false, card.isClub(-1) );
            // if card is out of bounds
            assertEquals( false, card.isClub(12) );
            assertEquals( false, card.isClub(40) );
            // if card is in bounds
            assertEquals( true, card.isClub(13) );
            assertEquals( true, card.isClub(25) );
        }




}