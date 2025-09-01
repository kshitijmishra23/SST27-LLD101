Exercise A — Singleton Refactoring (Config/Registry)
----------------------------------------------------
Narrative: CLI app loads settings and exposes them globally. Current design is not a real singleton,
not thread-safe, and vulnerable to reflection/serialization.

Tasks
1) Make AppSettings a proper, thread-safe singleton (lazy init; private ctor).
2) Block reflection-based multiple construction and preserve singleton on serialization (readResolve).
3) Update SettingsLoader to use the singleton (no 'new').

Acceptance
- Single instance across threads/process lifetimes within a JVM run.
- Reflection cannot construct a second instance; deserialization returns the same instance.
- Loading properties works; values accessible via get(key).

Build/Run (Starter)
  cd singleton-config/src
  javac com/example/config/*.java
  java com.example.config.App


