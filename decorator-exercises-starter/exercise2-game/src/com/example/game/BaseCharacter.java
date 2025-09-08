package com.example.game;

/**
 * Baseline character with default stats and sprite.
 * You will extend behavior by wrapping this object with decorators.
 */
public class BaseCharacter implements Character {
    private int speed = 5;
    private int damage = 10;
    private String sprite = "base.png";

    @Override
    public void move() {
        System.out.println("Moving at speed " + speed + " with sprite " + sprite);
    }

    @Override
    public void attack() {
        System.out.println("Attacking with damage " + damage + " using sprite " + sprite);
    }

    @Override
    public int getSpeed() { return speed; }

    @Override
    public int getDamage() { return damage; }

    @Override
    public String getSprite() { return sprite; }
}
