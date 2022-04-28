package com.vtuberwars.model.card;

import com.vtuberwars.model.cardspace.CardSpace;
import com.vtuberwars.model.cardspace.ModifiableCardSpace;

import java.lang.reflect.Field;

public abstract class Card {
    private int id;
    private String name;
    private String imagePath;
    private String description;
    private int manaCost;

    public Card(int id, String name, String imagePath, String description, int manaCost) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.description = description;
        this.manaCost = manaCost;
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
    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }
    public int getManaCost() {
        return this.manaCost;
    }
    public void printInfo() {
        System.out.println("id: " + this.id);
        System.out.println("name: " + this.name);
        System.out.println("imagePath: " + this.imagePath);
        System.out.println("description: " + this.description);
        System.out.println("manaCost: " + this.manaCost);
    }
    public abstract void apply(CardSpace Fields, int position);
//    public abstract void render();
}
