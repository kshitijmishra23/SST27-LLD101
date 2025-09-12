package com.example.game;

/** Utility to print a consolidated character status. */
public final class StatusPanel {
    private StatusPanel() {}
    public static void print(Character c) {
        System.out.println("== STATUS ==");
        System.out.println("Speed : " + c.getSpeed());
        System.out.println("Damage: " + c.getDamage());
        System.out.println("Sprite: " + c.getSprite());
    }
}
