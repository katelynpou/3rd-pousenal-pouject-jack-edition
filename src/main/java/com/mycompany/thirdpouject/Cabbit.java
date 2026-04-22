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
        hunger = clamp(mood + Food.hunger_value);
    }
    public void play() {
        mood = clamp(mood + 10);
    }
    public void shower() {
        hygiene = 100;
    }
    
    public void potion() {
        health += 50;
        if (health > 100) health = 100;
    }
    
    // getter functions
        public String getName()  { 
            return name;    
        }
        
        public int getHunger()   { 
            return hunger;  
        }
        
        public int getMood()     { 
            return mood;    
        }
        
        public int getHygiene()  { 
            return hygiene; 
        }
        
        public int getHealth()   { 
            return health;  
        }

    
    
    // decay functions in relation to the game's timer
    public void decayHunger(int n)  {
        hunger  = clamp(hunger  - n);
    }
    
    public void decayMood(int n)    {
        mood    = clamp(mood    - n);
    }
    public void decayHygiene(int n) {
        hygiene = clamp(hygiene - n);
    }
    public void decayHealth(int n)  {
        health  = clamp(health  - n);
    }
    
    private int clamp(int v) {
        return Math.max(0, Math.min(100, v));
    }

}
