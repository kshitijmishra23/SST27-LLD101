package com.example.game;

/**
 * Starter demo using only the base character.
 * TODOs guide you to implement decorators and compose them.
 */
public class GameDemo {
    public static void main(String[] args) {
        Character base = new BaseCharacter();

        System.out.println("--- Base ---");
        base.move();
        base.attack();

        // === YOUR TASKS ===
        // 1) Create CharacterDecorator that implements Character and wraps another Character.
        // 2) Create concrete decorators, for example:
        //      - SpeedBoost (adds +N to speed, overrides getSpeed() and move() print)
        //      - DamageBoost (adds +N to damage, overrides getDamage() and attack() print)
        //      - GoldenAura (changes sprite, small buffs, logs aura on actions)
        // 3) Show composition:
        //      a) Base + SpeedBoost + DamageBoost
        //      b) Add GoldenAura (sprite change + buffs)
        //      c) Remove GoldenAura by recomposing (rebuild chain without it)
        //
        // Example (after you implement):
        // Character buffed = new DamageBoost(new SpeedBoost(base, 3), 15);
        // buffed.move();
        // buffed.attack();
        //
        // Character shiny = new GoldenAura(buffed);
        // shiny.move();
        // shiny.attack();
        //
        // Character withoutAura = buffed; // removal by recomposition
        // withoutAura.move();
        // withoutAura.attack();
    }
}
