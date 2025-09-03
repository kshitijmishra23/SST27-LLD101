package com.example.config;

import java.nio.file.Path;

/** Thin wrapper that encourages re-loading and multiple instances. */
public class SettingsLoader {
    public AppSettings load(Path file) {
        AppSettings instance = AppSettings.getInstance();
        instance.loadFromFile(file);
        return instance;
    }
}
