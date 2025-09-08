package com.example.render;

public class Renderer {
    public int render(String text) {
        int cost = 0;
        for (char c : text.toCharArray()) {
            TextStyle style = TextStyleFactory.get("Inter", 14, (c % 7 == 0));
            Glyph g = new Glyph(c, style);
            cost += g.drawCost();
        }
        return cost;
    }
}
