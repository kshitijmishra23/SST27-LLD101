package com.example.render;

public class Renderer {
    public int render(String text) {
        int cost = 0;
        for (char c : text.toCharArray()) {
            Glyph g = new Glyph(c, "Inter", 14, (c % 7 == 0)); // TODO: refactor with TextStyle flyweights
            cost += g.drawCost();
        }
        return cost;
    }
}
