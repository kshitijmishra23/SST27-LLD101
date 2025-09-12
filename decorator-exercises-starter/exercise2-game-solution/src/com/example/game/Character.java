package com.example.game;

/** Component interface for a playable character. */
public interface Character {
    void move();
    void attack();
    int getSpeed();
    int getDamage();
    String getSprite();
}
