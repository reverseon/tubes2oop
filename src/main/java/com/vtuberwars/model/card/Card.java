package com.vtuberwars.model.card;

public class Card {
    private int id;
    private String name;
    private String imagePath;
    private String description;
    private int manaCost;
    private TypeCard typeCard;

    public Card(int id, String name, String imagePath, String description, int manaCost, TypeCard typeCard) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.description = description;
        this.manaCost = manaCost;
        this.typeCard = typeCard;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public String getDescription() {
        return this.description;
    }

    public int getManaCost() {
        return this.manaCost;
    }

    public TypeCard getTypeCard() {
        return this.typeCard;
    }
}
