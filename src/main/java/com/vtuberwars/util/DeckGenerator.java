package com.vtuberwars.util;

import com.vtuberwars.model.CLI.GameBoard;
import com.vtuberwars.model.card.*;
import com.vtuberwars.model.cardspace.CardSpace;
import com.vtuberwars.model.cardspace.DeckCardSpace;
import com.vtuberwars.model.player.Player;

import com.vtuberwars.util.CSVReader;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class  DeckGenerator {
    public static List<SpellSwap> arrSwap = new ArrayList<SpellSwap>();
    public static List<SpellMorph> arrMorph = new ArrayList<SpellMorph>();
    public static List<SpellPotion> arrPotion = new ArrayList<SpellPotion>();
    public static List<CharacterCard> arrCharacter = new ArrayList<CharacterCard>();

    private static final String CHARACTER_CSV_FILE_PATH = "card/data/character.csv";
    private static final String SPELL_MORPH_CSV_FILE_PATH = "card/data/spell_morph.csv";
    private static final String SPELL_POTION_CSV_FILE_PATH = "card/data/spell_ptn.csv";
    private static final String SPELL_SWAP_CSV_FILE_PATH = "card/data/spell_swap.csv";
    private static final String ROOT_TO_RESOURCE_PATH = "/src/main/resources/com/vtuberwars/";

    public static void loadCharCards() throws IOException, URISyntaxException {
        try {
            String cwd = System.getProperty("user.dir");
            File characterCSVFile = new File(cwd + ROOT_TO_RESOURCE_PATH + CHARACTER_CSV_FILE_PATH);
            CSVReader characterReader = new CSVReader(characterCSVFile, "\t");
            characterReader.setSkipHeader(true);
            List<String[]> characterRows = characterReader.read();
            CharacterCard charCard;
            for (String[] row : characterRows) {
                charCard = new CharacterCard(Integer.parseInt(row[0]) , row[1],cwd + ROOT_TO_RESOURCE_PATH + row[4], row[3], Integer.parseInt(row[7]), CharacterCard.characterTypeDeckParsing.get(row[2]), Float.parseFloat(row[5]), Float.parseFloat(row[6]), Float.parseFloat(row[8]), Float.parseFloat(row[9]));
                arrCharacter.add(charCard);
            }
        } catch (IOException e) {
            throw e;
        }
    }
    public static void loadSpellMorphCards() throws IOException, URISyntaxException {
        try {
            String cwd = System.getProperty("user.dir");
            File characterCSVFile = new File(cwd + ROOT_TO_RESOURCE_PATH + SPELL_MORPH_CSV_FILE_PATH);
            CSVReader characterReader = new CSVReader(characterCSVFile, "\t");
            characterReader.setSkipHeader(true);
            List<String[]> characterRows = characterReader.read();
            for (String[] row : characterRows) {
                SpellMorph morphCard = new SpellMorph(Integer.parseInt(row[0]) , row[1], cwd + ROOT_TO_RESOURCE_PATH + row[3], row[2], Integer.parseInt(row[5]), 0, Integer.parseInt(row[4]));
                arrMorph.add(morphCard);
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public static void loadSpellPtnCards() throws IOException, URISyntaxException {
        try {
            String cwd = System.getProperty("user.dir");
            File characterCSVFile = new File(cwd + ROOT_TO_RESOURCE_PATH +  SPELL_POTION_CSV_FILE_PATH);
            CSVReader characterReader = new CSVReader(characterCSVFile, "\t");
            characterReader.setSkipHeader(true);
            List<String[]> characterRows = characterReader.read();
            for (String[] row : characterRows) {
                SpellPotion ptnCard = new SpellPotion(Integer.parseInt(row[0]) , row[1], cwd + ROOT_TO_RESOURCE_PATH + row[3], row[2], Integer.parseInt(row[6]), Integer.parseInt(row[7]), Integer.parseInt(row[4]), Integer.parseInt(row[5]));
                arrPotion.add(ptnCard);
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public static void loadSpellSwapCards() throws IOException, URISyntaxException {
        try {
            String cwd = System.getProperty("user.dir");
            File characterCSVFile = new File(cwd + ROOT_TO_RESOURCE_PATH +  SPELL_SWAP_CSV_FILE_PATH);
            CSVReader characterReader = new CSVReader(characterCSVFile, "\t");
            characterReader.setSkipHeader(true);
            List<String[]> characterRows = characterReader.read();
            for (String[] row : characterRows) {
                SpellSwap swapCard = new SpellSwap(Integer.parseInt(row[0]) , row[1], cwd + ROOT_TO_RESOURCE_PATH + row[3], row[2], Integer.parseInt(row[5]), Integer.parseInt(row[4]));
                arrSwap.add(swapCard);
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public static CardSpace generateDeck(int cardCap){
        Random random = new Random();
        CardSpace deckCardSpace = new CardSpace(cardCap);
        try {
            DeckGenerator.loadCharCards();
            DeckGenerator.loadSpellMorphCards();
            DeckGenerator.loadSpellPtnCards();
            DeckGenerator.loadSpellSwapCards();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }

        //MEMASTIKAN KARTU KARAKTER MINIMAL ADA 15 KARTU
        int charCardRand = cardCap - 24;
        for(int i = 0; i < charCardRand; i++) {
            deckCardSpace.insertCard(CharacterCard.cctorCharacter(DeckGenerator.arrCharacter.get(random.nextInt(18))));
        }
        //MEMASTIKAN KARTU SPELLPOTION MINIMAL ADA 14 KARTU
        for(int i = 0; i < 14; i++) {
            deckCardSpace.insertCard(SpellPotion.cctorPotion(DeckGenerator.arrPotion.get(random.nextInt(18))));
        }
        //MEMASTIKAN KARTU SPELLSWAP MINIMAL ADA 5 KARTU
        for(int i = 0; i < 5; i++) {
            deckCardSpace.insertCard(SpellSwap.cctorSwap(DeckGenerator.arrSwap.get(random.nextInt(10))));
        }
        //MEMASTIKAN KARTU SPELLMORPH MINIMAL ADA 5 KARTU
        for(int i = 0; i < 5; i++) {
            deckCardSpace.insertCard(SpellMorph.cctorMorph(DeckGenerator.arrMorph.get(random.nextInt(6))));
        }
        shuffleDeck(deckCardSpace);
        return deckCardSpace;
    }
    public static void shuffleDeck(CardSpace deckCardSpace) {
        Random random = new Random();
        int shuffleNum = random.nextInt(300)+100;
        for(int i = 0; i < shuffleNum; i++) {
            deckCardSpace.swapPlace(random.nextInt(deckCardSpace.getNEff()), random.nextInt(deckCardSpace.getNEff()));
        }
    }
//    public static void main(String[] args) throws IOException, URISyntaxException {
//        Random random = new Random();
//        int cardCap = random.nextInt(21)+40;
//        System.out.println("Card Capacity : " + cardCap);
//        CardSpace deck = generateDeck(cardCap);
//        for(int i = 0; i < deck.getNEff(); i++) {
//            System.out.println(i);
//            deck.getCard(i).printInfo();
//        }
//    }
}
