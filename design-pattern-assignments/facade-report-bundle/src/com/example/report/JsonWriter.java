package com.example.report;
import java.io.*; import java.nio.file.*; import java.util.Map;

public class JsonWriter {
    public Path write(Map<String,Object> data, Path outDir, String fileName) {
        try {
            Files.createDirectories(outDir);
            Path p = outDir.resolve(fileName + ".json");
            try (BufferedWriter w = Files.newBufferedWriter(p)) {
                w.write("{"ok":true,"name":"" + data.get("name") + ""}");
            }
            return p;
        } catch (IOException e) { throw new UncheckedIOException(e); }
    }
}
