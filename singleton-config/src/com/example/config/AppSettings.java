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
    private static final long serialVersionUID = 1L;

    private static volatile AppSettings INSTANCE;

    private final Properties props = new Properties();

    private AppSettings() {
        if (INSTANCE != null) {
            throw new IllegalStateException("AppSettings already initialized");
        }
    }

    public static AppSettings getInstance() {
        AppSettings result = INSTANCE;
        if (result == null) {
            synchronized (AppSettings.class) {
                result = INSTANCE;
                if (result == null) {
                    result = new AppSettings();
                    INSTANCE = result;
                }
            }
        }
        return result;
    }

    public void loadFromFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }

    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
}
