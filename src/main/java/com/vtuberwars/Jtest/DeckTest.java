package com.vtuberwars.Jtest;

import  com.vtuberwars.model.cardspace.*;
import  com.vtuberwars.util.*;

import org.junit.*;

public class DeckTest {
    private CardSpace deck;

    @Before
    public void setUp() {
        try{
            this.deck = DeckGenerator.loadDeck("test.csv");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testDeckSize(){
        Assert.assertEquals(this.deck.getNEff(), 42);
    }
    @Test
    public void testGetCardByIdx(){
        Assert.assertEquals(this.deck.getCard(3).getId(),18);
    }
    @Test
    public void testRandomDeck(){
        this.deck = DeckGenerator.generateDeck(49);
        Assert.assertEquals(this.deck.getNEff(), 49);
    }


}
