package com.example.imageviewer;

public class HighResImage implements Image {
    private final String fileName;

    public HighResImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("  [DISK] Loading high-res image: " + fileName);
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void display() {
        System.out.println("  [DISPLAY] Showing: " + fileName);
    }
}
