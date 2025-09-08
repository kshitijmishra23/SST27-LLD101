package com.example.render;

public class App {
    public static void main(String[] args) {
        Renderer r = new Renderer();
        System.out.println("Cost=" + r.render("Hello Flyweight! ".repeat(2000)));
        System.out.println("Unique styles created: " + TextStyleFactory.cacheSize());
    }
}
