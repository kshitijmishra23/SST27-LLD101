package com.example.game;

public interface Character {
    void move();                // prints action including current speed/sprite
    void attack();              // prints action including current damage/sprite
    int getSpeed();
    int getDamage();
    String getSprite();         // current "image" id/path/name
}
