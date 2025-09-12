package com.example.game;

/** ConcreteDecorator: increases damage by a fixed delta. */
public class DamageBoost extends CharacterDecorator {
    private final int delta;
    public DamageBoost(Character inner, int delta) { super(inner); this.delta = delta; }
    @Override public int getDamage() { return inner.getDamage() + delta; }
    @Override public void attack() {
        System.out.println("[DamageBoost +" + delta + "]");
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }
}
