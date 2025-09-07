package com.example.imports;
import java.nio.file.Path;
public interface ProfileImporter {
    int importFrom(Path csvFile);
}
