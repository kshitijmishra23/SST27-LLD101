package com.example.render;

/** Intrinsic state for glyphs: immutable and shared via factory. */
public final class TextStyle {
    private final String font;
    private final int size;
    private final boolean bold;

    public TextStyle(String font, int size, boolean bold) {
        this.font = font;
        this.size = size;
        this.bold = bold;
    }

    public String getFont() { return font; }
    public int getSize() { return size; }
    public boolean isBold() { return bold; }

    public int drawCost() {
        return size + (bold ? 10 : 0);
    }

    @Override
    public String toString() {
        return font + "|" + size + "|" + (bold ? "B" : "N");
    }
}
