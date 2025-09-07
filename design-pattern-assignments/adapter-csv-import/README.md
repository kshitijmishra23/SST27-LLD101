# Adapter — CSV Import (Feature Implementation)

## Narrative (Current Code)
You must add a CSV import feature. The only available utility is a low-level `NaiveCsvReader` that returns `List<String[]>`. The domain service `ProfileService` expects validated fields.

## Your Task
Implement `CsvProfileImporter` that adapts `NaiveCsvReader` to the `ProfileImporter` interface:
- Parse: columns `id,email,displayName`
- Validate: skip invalid rows (missing id/email or bad email)
- Count successful imports

Wire `App` to accept a CSV path and print a summary.

## Acceptance Criteria
- `java com.example.imports.App users.csv` prints created profiles and `Imported N profiles`
- Invalid rows are skipped with an explanatory message
- `ProfileService` remains unchanged

## Hints
- Use `Objects.requireNonNull`
- Do validation in the adapter; keep the domain service clean

## Build & Run
```bash
cd adapter-csv-import/src
javac com/example/imports/*.java
java com.example.imports.App users.csv
```
