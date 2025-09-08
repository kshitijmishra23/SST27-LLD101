package com.example.video;

import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        VideoPipelineFacade facade = new VideoPipelineFacade();

        Path out = facade.process(
            Path.of("in.mp4"),
            Path.of("out.mp4"),
            true,        // grayscale
            0.5,         // scale
            3            // sharpen strength
        );

        System.out.println("Wrote " + out);
    }
}
