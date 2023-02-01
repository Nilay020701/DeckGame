package io.deckgame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

class Deck {
    private int noOfCards = 52;
    private String[] type = new String[]{"Spades", "Hearts", "Club", "Diamonds"};
    private String[] value = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "Queen", "King", "Ace"};

    private HashSet<String> cardsTaken = new HashSet<>();
    private HashSet<String> cardDeck = new HashSet<>();
    private int a;
    private int b;

    private Random random = new Random();

    protected Deck() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                cardDeck.add(value[i] + "_of_" + type[j]);
            }
        }

    }

    protected void shuffleDeck() {


        int low = 1;
        int high = 52;
        int remove = random.nextInt(high - low) + low;

        ArrayList<String> insert = new ArrayList<>();
        for (int i = 0; i < remove; i++) {
            String card = getRandomCard();
            while (cardsTaken.contains(card)) {
                card = getRandomCard();
            }
            cardDeck.remove(card);
            insert.add(card);
        }

        for (int i = insert.size() - 1; i >= 0; i--) {
            cardDeck.add(insert.get(i));
        }

        System.out.println("Deck Shuffled.");
    }

    private String getRandomCard() {
        int low = 0;
        int high = 13;
        int val = random.nextInt(high - low) + low;
        high = 4;
        int typ = random.nextInt(high - low) + low;

        String s = value[val] + "_of_" + type[typ];
        a = typ;
        b = val;

        return s;
    }

    protected String getCard() {

        String card = getRandomCard();

        while (cardsTaken.contains(card)) {
            card = getRandomCard();
        }

        cardsTaken.add(card);
        cardDeck.remove(card);

        noOfCards--;
        return card;
    }


    protected void restoreDeck() {
        Iterator<String> itr = cardsTaken.iterator();
        while (itr.hasNext()) {
            String s = itr.next();
            cardDeck.add(s);
        }
    }

    protected void printDeck() {

        System.out.println("\nCards left in deck are (:");
        int i = 1;
        for (String s : cardDeck)
            System.out.println(i++ + " " + s);
        System.out.println();
    }

    protected void returnCardToDeck(String cardToReturn) {
        cardsTaken.remove(cardToReturn);
        cardDeck.add(cardToReturn);
    }

    protected int getTyp() {
        return a;
    }

    protected int getVal() {
        return b;
    }
}

