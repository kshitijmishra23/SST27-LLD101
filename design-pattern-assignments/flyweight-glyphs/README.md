# Flyweight — Deduplicate Glyph Styles (Refactoring)

## Narrative (Current Code)
Each `Glyph` stores its own style fields (font,size,bold). Rendering long texts creates thousands of duplicate style objects → memory blow-up.

## Your Task
- Extract immutable `TextStyle` (font,size,bold) as **intrinsic** state.
- Implement `TextStyleFactory` that caches and returns shared `TextStyle` instances by key.
- Modify `Glyph` to hold a `TextStyle` (intrinsic) and a `char` (extrinsic).
- Update `Renderer` to obtain styles via the factory.

## Acceptance Criteria
- Same rendering “cost” as before
- Identical style configs reuse the same `TextStyle` instance (reference equality in a quick check)
- `TextStyle` is immutable

## Hints
- Use a `Map<String, TextStyle>` cache in the factory
- Key suggestion: `"Inter|14|B"`

## Build & Run
```bash
cd flyweight-glyphs/src
javac com/example/render/*.java
java com.example.render.App
```
