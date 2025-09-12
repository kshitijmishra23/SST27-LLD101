package com.example.game;

/** ConcreteDecorator: visual aura + small passive buffs + sprite swap. */
public class GoldenAura extends CharacterDecorator {
    public GoldenAura(Character inner) { super(inner); }
    @Override public String getSprite() { return "golden_" + inner.getSprite(); }
    @Override public int getSpeed()  { return inner.getSpeed() + 1; }
    @Override public int getDamage() { return inner.getDamage() + 2; }
    @Override public void move()   { System.out.println("[GoldenAura ✨]"); super.move(); }
    @Override public void attack() { System.out.println("[GoldenAura ✨]"); super.attack(); }
}
