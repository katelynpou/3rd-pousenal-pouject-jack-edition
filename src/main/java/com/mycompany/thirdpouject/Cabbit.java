/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thirdpouject;

/**
 *
 * @author kkvu5
 */

public class Cabbit {
    private String name;
    private int hunger;
    private int mood;
    private int hygiene;
    private int health;
    
    public Cabbit(String name) {
        this.name = name;
        this.hunger = 50;
        this.mood = 50;
        this.hygiene = 50;
        this.health = 50;
    }
    public void feed() {
        hunger += Food.hunger_value;
        if (hunger > 100) hunger = 100;
    }
    public void play() {
        mood += 10;
        if (mood > 100) mood = 100;
    }
    public void shower() {
        hygiene = 100;
    }
    
    public void potion() {
        health += 50;
        if (health > 100) health = 100;
    }
}
