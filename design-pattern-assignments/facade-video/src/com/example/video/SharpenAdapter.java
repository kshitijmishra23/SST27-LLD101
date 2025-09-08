package com.example.video;

import java.util.Objects;

/** Adapter to bridge LegacySharpen's handle-based API to Frame[]. */
public class SharpenAdapter {
    private final LegacySharpen legacy;

    public SharpenAdapter(LegacySharpen legacy) {
        this.legacy = Objects.requireNonNull(legacy, "legacy");
    }

    public Frame[] sharpen(Frame[] frames, int strength) {
        Objects.requireNonNull(frames, "frames");

        // Convert frames → fake handle
        String handle = "HANDLE:" + frames.length;

        // Call legacy API
        String resultHandle = legacy.applySharpen(handle, strength);

        // Convert back to frames (simulated)
        // (Here we simply return the same frames for demo purposes)
        return frames;
    }
}
