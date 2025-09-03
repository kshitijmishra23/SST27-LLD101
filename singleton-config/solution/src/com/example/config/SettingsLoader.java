package com.example.config;

import java.nio.file.Path;
import java.util.Objects;

public class SettingsLoader {
    public AppSettings load(Path file) {
        Objects.requireNonNull(file, "file");
        AppSettings s = AppSettings.getInstance();
        s.loadFromFile(file);
        return s;
    }
}
