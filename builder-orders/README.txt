Exercise C — Builder Pattern (Orders & Discounts)
-------------------------------------------------
Narrative: Order aggregate uses telescoping constructors and setters, allows invalid states,
and leaks mutability from OrderLine.

Tasks
1) Introduce Order.Builder with required id, customerEmail, and at least one line.
2) Validate email format, discount range 0..100, non-empty lines; centralize in build().
3) Make Order externally immutable (no setters, unmodifiable lines, defensive copy of lines).

Build/Run (Starter)
  cd builder-orders/src
  javac com/example/orders/*.java TryIt.java
  java TryIt


