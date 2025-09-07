package com.example.report;
import java.time.*; import java.nio.file.*; import java.io.*;

public class AuditLog {
    public void log(String msg) {
        try {
            Files.writeString(Path.of("audit.log"), Instant.now() + " " + msg + "\n",
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) { throw new UncheckedIOException(e); }
    }
}
