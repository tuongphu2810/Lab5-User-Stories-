package com.example.lab5Userstories;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    ArrayList<Card> cards = new ArrayList<>();

    public Deck() {

        String[] ranks = {
                "A", "2", "3", "4", "5", "6", "7",
                "8", "9", "10", "J", "Q", "K"
        };

        String[] suits = {
                "spades",
                "hearts",
                "clubs",
                "diamonds"
        };

        for (int i = 0; i < suits.length; i++) {

            for (int j = 0; j < ranks.length; j++) {

                String rank = ranks[j];
                String suit = suits[i];

                String imagePath = "";

                if (rank.equals("A")) {

                    imagePath =
                            "/cards/ace_of_" + suit + ".png";

                } else if (rank.equals("J")) {

                    imagePath =
                            "/cards/jack_of_" + suit + "2.png";

                } else if (rank.equals("Q")) {

                    imagePath =
                            "/cards/queen_of_" + suit + "2.png";

                } else if (rank.equals("K")) {

                    imagePath =
                            "/cards/king_of_" + suit + "2.png";

                } else {

                    imagePath =
                            "/cards/" + rank + "_of_" + suit + ".png";
                }

                Card card =
                        new Card(rank, suit, imagePath);

                cards.add(card);
            }
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}