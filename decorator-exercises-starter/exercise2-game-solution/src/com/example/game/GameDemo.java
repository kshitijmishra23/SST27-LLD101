package com.example.game;

/** Demo for the game solution: stacking and removing decorators. */
public class GameDemo {
    public static void main(String[] args) {
        Character base = new BaseCharacter();

        System.out.println("--- Base ---");
        base.move();
        base.attack();
        StatusPanel.print(base);

        System.out.println("\n--- After scoring 100 pts (Speed+Damage) ---");
        Character buffed = new DamageBoost(new SpeedBoost(base, 3), 15);
        buffed.move();
        buffed.attack();
        StatusPanel.print(buffed);

        System.out.println("\n--- Also picked GoldenAura ---");
        Character shiny = new GoldenAura(buffed);
        shiny.move();
        shiny.attack();
        StatusPanel.print(shiny);

        System.out.println("\n--- Aura expired (rebuild chain without GoldenAura) ---");
        Character withoutAura = buffed;
        withoutAura.move();
        withoutAura.attack();
        StatusPanel.print(withoutAura);
    }
}
