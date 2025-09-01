Exercise B — Immutable Classes (Profiles)
----------------------------------------
Narrative: Profile service builds UserProfile objects that currently have multiple constructors,
public setters, and scattered validation. Refactor to an immutable class with a Builder.

Tasks
1) Refactor UserProfile to immutable (private final fields, no setters).
2) Introduce Builder with required id, email; optional phone, displayName, address, marketingOptIn, twitter, github.
3) Centralize validation in Builder.build() using Validation helpers.
4) Update ProfileService to stop mutating after creation.

Build/Run (Starter demo)
  cd immutable-profiles/src
  javac com/example/profiles/*.java TryIt.java
  java TryIt

