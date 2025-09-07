package com.example.video;

/** Odd legacy API expecting a 'handle' string; returns a new handle string. */
public class LegacySharpen {
    public String applySharpen(String framesHandle, int strength) { 
        return "HANDLE:" + strength; 
    }
}
