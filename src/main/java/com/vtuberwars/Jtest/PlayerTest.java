package com.vtuberwars.Jtest;
import  com.vtuberwars.model.player.*;
import  com.vtuberwars.util.*;

import org.junit.*;

public class PlayerTest {
    private Player player;

    @Before
    public void setUp() {
        player = new Player("Test","test.csv");
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Test", player.getName());
    }

    @Test
    public void testPlayerDeckSize() {
        Assert.assertEquals(42, player.getCardsAtDeck().getNEff());
    }

    @Test
    public void testRemoveDeckCard(){
        player.getCardsAtDeck().deleteCard(0);
        Assert.assertEquals(41, player.getCardsAtDeck().getNEff());
    }

    @Test
    public void testMoveToHandAndDiscard(){
        player.addToHand(player.getACardAtDeck(0), 0);
        Assert.assertEquals(1, player.getCardsAtHand().getNEff());
        Assert.assertEquals(41, player.getCardsAtDeck().getNEff());
        player.discardHand(0);
        Assert.assertEquals(0, player.getCardsAtHand().getNEff());
    }


    @Test
    public void testMoveToField(){
        player.addToHand(player.getACardAtDeck(0), 0);
        Assert.assertEquals(player.getACardAtHand(0).getName(), "Obsidian");
        player.moveToField(0, 0);
        Assert.assertEquals(1, player.getCardsAtField().getNEff());
        Assert.assertEquals(41, player.getCardsAtDeck().getNEff());
        Assert.assertEquals(player.getACardAtField(0).getName(), "Obsidian");
    }

    @Test
    public void maxCapDeckReached(){
        for(int i = 0; i < 10; i++){
            player.addToHand(player.getACardAtDeck(0), 0);
        }
        Assert.assertEquals(5, player.getCardsAtHand().getNEff());
        Assert.assertEquals(32, player.getCardsAtDeck().getNEff());
        Assert.assertEquals(player.getACardAtHand(0).getName(), "Deathly Magic");
        Assert.assertEquals(player.getACardAtHand(1).getName(), "Obsidian");
        Assert.assertEquals(player.getACardAtHand(2).getName(), "Obsidian");
        Assert.assertEquals(player.getACardAtHand(3).getName(), "Obsidian");
        Assert.assertEquals(player.getACardAtHand(4).getName(), "Obsidian");
        player.addToHand(player.getACardAtDeck(0), 0);
        Assert.assertEquals(5, player.getCardsAtHand().getNEff());
        Assert.assertEquals(player.getACardAtHand(0).getName(), "Herobrine's Blessing");
        Assert.assertEquals(player.getACardAtHand(1).getName(), "Obsidian");
        Assert.assertEquals(player.getACardAtHand(2).getName(), "Obsidian");
        Assert.assertEquals(player.getACardAtHand(3).getName(), "Obsidian");
        Assert.assertEquals(player.getACardAtHand(4).getName(), "Obsidian");
    }
}
