# Proxy Pattern — Starter Problems (Java)

This package contains **starter code only** (no proxies implemented) for two exercises.
You will **add Proxy-based solutions** yourself.

## Contents
- `exercise1-image-viewer/` — A gallery that holds `Image` objects; add a `Virtual Proxy` to defer expensive disk loading until the image is actually displayed.
- `exercise2-document-access/` — A document store with read/write operations; add a `Protection Proxy` that enforces role-based access control.

> These folders compile and run as-is, but stub methods throw `UnsupportedOperationException`. Your task is to implement the proxies and compose them in the demo classes as directed below.

---

## Background: Proxy Pattern

A **Proxy** sits in front of a real object, implements the **same interface**, and controls access to it. The client never knows (or cares) whether it is talking to the real object or its proxy.

Three common variants:
| Variant | What the proxy adds |
|---|---|
| **Virtual Proxy** | Delays creation/loading of an expensive object until it is actually needed |
| **Protection Proxy** | Checks permissions before forwarding a call |
| **Caching Proxy** | Returns a cached result instead of hitting the real service repeatedly |

Key rule: **the proxy and the real object share the same interface**, so the caller's code does not change.

---

## Exercise 1 — Image Viewer (Virtual Proxy)

**Problem.** A `Gallery` needs to show a list of high-resolution images. `HighResImage` loads its file from disk the moment it is constructed — even if the image is never displayed. With thousands of images this is wasteful.

**Existing code**
- `Image` — interface with `getFileName()` and `display()`
- `HighResImage implements Image` — prints `[DISK] Loading ...` in the **constructor** (simulating expensive I/O), then `[DISPLAY] Showing ...` in `display()`

**Your goals**
1. Complete `ImageProxy` so that `HighResImage` is created **only** when `display()` is called for the first time. Subsequent `display()` calls on the same proxy must reuse the already-loaded image (no second disk load).
2. In `Demo.java`, create 5 `ImageProxy` objects, list all their file names, then display only the images at index 0 and 2. Verify that only those two images produce a `[DISK]` line, and that calling `display()` on index 0 again does **not** produce a second `[DISK]` line.

**Expected output (structure)**
```
=== Image Gallery ===

Listing all images (no loading expected):
  landscape.jpg
  portrait.jpg
  skyline.jpg
  waterfall.jpg
  sunset.jpg

Displaying selected images:
  [DISK] Loading high-res image: landscape.jpg
  [DISPLAY] Showing: landscape.jpg
  [DISK] Loading high-res image: skyline.jpg
  [DISPLAY] Showing: skyline.jpg

Displaying landscape.jpg again (no reload):
  [DISPLAY] Showing: landscape.jpg
```

**Build & Run**
```bash
# from repository root
javac exercise1-image-viewer/src/com/example/imageviewer/*.java
java -cp exercise1-image-viewer/src com.example.imageviewer.Demo
```

---

## Exercise 2 — Document Access (Protection Proxy)

**Problem.** `RealDocumentService` stores company documents. Any code that holds a reference can read or write freely. You need to enforce that only `EDITOR` users can write; `VIEWER` users may only read.

**Existing code**
- `DocumentService` — interface with `read(String docId)` and `write(String docId, String content)`
- `RealDocumentService implements DocumentService` — in-memory store pre-loaded with three documents
- `Role` — enum `{ VIEWER, EDITOR }`
- `User` — holds a `name` and a `Role`

**Your goals**
1. Complete `AccessControlProxy`:
   - `read()` — allowed for both roles; print `[ACCESS] <name> read <docId>` then delegate.
   - `write()` — allowed only for `EDITOR`; if the user is a `VIEWER`, throw `SecurityException` with message `"<name> does not have write permission"`. Otherwise print `[ACCESS] <name> wrote <docId>` then delegate.
2. In `DocumentDemo.java`:
   - Wrap `realService` in an `AccessControlProxy` for `Alice (VIEWER)`. Read `"doc-001"` (must succeed). Attempt to write `"doc-004"` and catch the `SecurityException`, printing `"Blocked: " + e.getMessage()`.
   - Wrap `realService` in an `AccessControlProxy` for `Bob (EDITOR)`. Write `"doc-004"` with content `"Final notes"`. Read it back and print the content.

**Expected output (structure)**
```
=== Document Access Demo ===

--- Viewer: Alice (VIEWER) ---
[ACCESS] Alice read doc-001
  Q1 Financial Report: Revenue $4.2M, Expenses $3.1M
Blocked: Alice does not have write permission

--- Editor: Bob (EDITOR) ---
[ACCESS] Bob wrote doc-004
  [STORE] Saved: doc-004
[ACCESS] Bob read doc-004
  Final notes
```

**Build & Run**
```bash
javac exercise2-document-access/src/com/example/docaccess/*.java
java -cp exercise2-document-access/src com.example.docaccess.DocumentDemo
```

---

## Notes
- Do **not** modify `HighResImage`, `RealDocumentService`, `Role`, or `User` — only add the proxies and fill in the demo classes.
- Both proxies must implement the **same interface** as the real object.
- The caller (`Demo`, `DocumentDemo`) should reference the interface type, not the concrete proxy class.
- A `SecurityException` is an unchecked exception in Java — no `throws` declaration is needed.
