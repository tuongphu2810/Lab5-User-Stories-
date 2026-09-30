package com.example.lab5Userstories;

public class Card {

    String rank;
    String suit;
    String imagePath;

    public Card(String rank, String suit, String imagePath) {
        this.rank = rank;
        this.suit = suit;
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}
