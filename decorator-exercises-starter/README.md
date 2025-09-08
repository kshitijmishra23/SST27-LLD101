# Decorator Pattern — Starter Problems (Java)

This package contains **starter code only** (no decorators implemented) for two exercises.
You will **add Decorator-based solutions** yourself.

## Contents
- `exercise1-notifications/` — Start from an existing `EmailNotifier` and extend with runtime-composable channels (SMS, WhatsApp, Slack) using Decorator.
- `exercise2-game/` — A game character with `move()` and `attack()`; as points increase, stackable buffs should change speed, damage, and sprite using Decorator.

> These folders compile and run as-is, but only the baseline behavior is present. Your task is to add decorators and compose them in the demo classes as directed below.

---

## Exercise 1 — Notification Service

**Problem.** You already have a notifier that emails text notifications via `notify(String text)`. Clients want combinations like Email+SMS, Email+WhatsApp, Email+Slack, and even Email+SMS+Slack, configurable at runtime.

**Your goals**
1. Define a base *decorator* type that implements `Notifier` and wraps another `Notifier`.
2. Create concrete decorators for `SMS`, `WhatsApp`, and `Slack` that add their sending logic and then delegate to the wrapped notifier.
3. In `Demo.java`, compose decorators to satisfy these examples:
   - Email + SMS
   - Email + WhatsApp
   - Email + Slack
   - Email + WhatsApp + Slack

**Build & Run**
```bash
# from repository root
javac exercise1-notifications/src/com/example/notifications/*.java
java -cp exercise1-notifications/src com.example.notifications.Demo
```

---

## Exercise 2 — Game Character Power-ups

**Problem.** A character exposes `move()` and `attack()`. As the player scores points, speed should increase, attack damage should increase, and the sprite/image should change. These enhancements should be **stackable at runtime** and independently removable (by rebuilding the composition).

**Your goals**
1. Create a base decorator `CharacterDecorator` that implements `Character` and wraps another `Character`.
2. Implement concrete decorators, e.g.:
   - `SpeedBoost` (+N to speed)
   - `DamageBoost` (+N to damage)
   - `GoldenAura` (changes sprite and small buffs)
3. In `GameDemo.java`, show composition at runtime:
   - Base only.
   - Base + SpeedBoost + DamageBoost.
   - Add `GoldenAura`, then remove it by recomposing.

**Build & Run**
```bash
javac exercise2-game/src/com/example/game/*.java
java -cp exercise2-game/src com.example.game.GameDemo
```

---

## Notes
- Do **not** modify the base classes; add behavior by wrapping.
- Keep the **same interfaces** so clients can treat decorated objects as the original types.
- Prefer small, single-responsibility decorators.
