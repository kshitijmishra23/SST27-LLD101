package com.example.game;

/** ConcreteDecorator: increases speed by a fixed delta. */
public class SpeedBoost extends CharacterDecorator {
    private final int delta;
    public SpeedBoost(Character inner, int delta) { super(inner); this.delta = delta; }
    @Override public int getSpeed() { return inner.getSpeed() + delta; }
    @Override public void move() {
        System.out.println("[SpeedBoost +" + delta + "]");
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite());
    }
}
