package com.example.imageviewer;

public class ImageProxy implements Image {
    private final String fileName;
    private HighResImage realImage;   // null until the first display() call

    public ImageProxy(String fileName) {
        this.fileName = fileName;
        // Notice: we do NOT create HighResImage here — that is the whole point.
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void display() {
        // TODO: Load the real image lazily (only on the very first call to display),
        //       then delegate the display call to it.
        //
        // Hint: if realImage is null, create a new HighResImage(fileName) and assign it,
        //       then call realImage.display().
        throw new UnsupportedOperationException("Implement lazy loading in ImageProxy");
    }
}
