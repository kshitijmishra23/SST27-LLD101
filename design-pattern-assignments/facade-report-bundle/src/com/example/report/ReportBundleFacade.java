package com.example.report;

import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

public class ReportBundleFacade {
    private final JsonWriter writer = new JsonWriter();
    private final Zipper zipper = new Zipper();
    private final AuditLog log = new AuditLog();

    /**
     * Orchestrates writing JSON → zipping → logging
     */
    public Path export(Map<String,Object> data, Path outDir, String baseName) {
        Objects.requireNonNull(data, "data");
        Objects.requireNonNull(outDir, "outDir");
        Objects.requireNonNull(baseName, "baseName");

        // Step 1: write JSON
        Path json = writer.write(data, outDir, baseName);

        // Step 2: zip it
        Path zip = zipper.zip(json, outDir.resolve(baseName + ".zip"));

        // Step 3: log success
        log.log("exported " + zip);

        return zip;
    }
}
