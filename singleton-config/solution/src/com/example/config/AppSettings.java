package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Properties;

public final class AppSettings implements Serializable {
    private static final long serialVersionUID = 1L;
    private static volatile boolean constructed = false;

    private final Properties props = new Properties();

    private AppSettings() {
        if (constructed) throw new RuntimeException("Singleton already constructed");
        constructed = true;
    }

    private static class Holder {
        static final AppSettings INSTANCE = new AppSettings();
    }

    public static AppSettings getInstance() {
        return Holder.INSTANCE;
    }

    public synchronized void loadFromFile(Path file) {
        Objects.requireNonNull(file, "file");
        try (InputStream in = Files.newInputStream(file)) {
            props.clear();
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public synchronized String get(String key) {
        Objects.requireNonNull(key, "key");
        return props.getProperty(key);
    }

    private Object readResolve() {
        return getInstance();
    }
}
