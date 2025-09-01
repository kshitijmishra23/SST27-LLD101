package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * FAULTY "Singleton": public constructor, getInstance() returns a NEW instance each time,
 * not thread-safe, reload allowed anytime, mutable global state, reflection+serialization-friendly.
 */
public class AppSettings implements Serializable {
    private final Properties props = new Properties();
    private static volatile AppSettings appSettings;

    private AppSettings() { 
        if (appSettings != null) {
            throw new IllegalStateException("Singleton already initialized.");
        }
    } // should not be public for true singleton

    public static AppSettings getInstance() {
        if (appSettings == null) {
            synchronized (AppSettings.class) {
                if (appSettings == null) {
                    appSettings = new AppSettings();    
                }
            }
        }
        return appSettings;
    }

    public void loadFromFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    // This method fixes the singleton issue during de-serialization, jvm will return the same instance instead of creating a new one.
    protected Object readResolve() {
        return getInstance();
    }

    public String get(String key) {
        return props.getProperty(key);
    }
}