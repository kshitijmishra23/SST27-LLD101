# Facade — Report Bundle Export (Feature Implementation)

## Narrative (Current Code)
Caller orchestrates 3 utilities: `JsonWriter` → `Zipper` → `AuditLog`. This is error-prone and leaks subsystem order & details.

## Your Task
Create `ReportBundleFacade` with:
```java
Path export(java.util.Map<String,Object> data, java.nio.file.Path outDir, String baseName)
```
Inside, orchestrate: write JSON → zip it to `baseName.zip` in `outDir` → log success.
Refactor `App` to use **only** the facade.

## Acceptance Criteria
- `App` no longer directly uses `JsonWriter`, `Zipper`, or `AuditLog`
- On success: prints path to the `.zip` and writes an entry to `audit.log`
- Any IO errors surface as `UncheckedIOException`

## Hints
- Keep the facade thin; do not change the utility classes
- Validate inputs with `Objects.requireNonNull`

## Build & Run
```bash
cd facade-report-bundle/src
javac com/example/report/*.java
java com.example.report.App
```
