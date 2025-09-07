# Adapter — Payments (Refactoring)

## Narrative (Current Code)
OrderService directly depends on two mismatched SDKs (`FastPayClient`, `SafeCashClient`), uses a string `provider` switch, and duplicates glue logic.

## Your Task
Introduce an **Adapter** so `OrderService` depends only on a `PaymentGateway` interface. Create:
- `PaymentGateway` (target interface): `String charge(String customerId, int amountCents)`
- `FastPayAdapter` and `SafeCashAdapter` mapping to their respective SDKs
- A simple map-based registry in `App` to select the gateway

Refactor `OrderService` to accept a `PaymentGateway` and remove provider branching.

## Acceptance Criteria
- `OrderService` calls **only** `PaymentGateway`
- Adding a new provider requires no change to `OrderService`
- Running `App` prints transaction IDs for both providers

## Hints
- Use constructor injection or a `Map<String, PaymentGateway>`
- Keep adapters stateless
- Use `Objects.requireNonNull` to validate inputs

## Build & Run
```bash
cd adapter-payments/src
javac com/example/payments/*.java
java com.example.payments.App
```
