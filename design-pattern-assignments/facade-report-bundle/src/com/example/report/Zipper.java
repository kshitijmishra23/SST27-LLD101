package com.example.report;
import java.io.*; import java.nio.file.*; import java.util.zip.*;

public class Zipper {
    public Path zip(Path file, Path outZip) {
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(outZip))) {
            zos.putNextEntry(new ZipEntry(file.getFileName().toString()));
            Files.copy(file, zos); zos.closeEntry();
        } catch (IOException e) { throw new UncheckedIOException(e); }
        return outZip;
    }
}
